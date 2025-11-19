package pj.domain.schedule

import scala.xml.Elem
import pj.domain.*
import pj.xml.{DomainToXML, XMLToDomain}
import scala.annotation.tailrec

object ScheduleMS01 extends Schedule:

  // Entry point for scheduling.
  // Converts input XML to domain model, applies scheduling, then converts result back to XML.
  def create(xml: Elem): Result[Elem] =
    for
      input <- XMLToDomain.fromProduction(xml) // Parse and validate XML into domain model
      scheduled <- naiveScheduling(input) // Schedule tasks using naive strategy
      outputXml <- DomainToXML.generateOutputXML(
        scheduled,
        input.humans.map(h => h.id.to -> h.name).toMap // Map human IDs to names for output
      )
    yield outputXml

  // Naive scheduling strategy that processes all orders in ascending order of their IDs.
  // Each order is handled one after another, and each of its product units is scheduled in full before the next order begins.
  private def naiveScheduling(input: ProductionInput): Result[List[TaskSchedule]] =
    input.orders match
      case Nil =>
        // No orders to schedule, fail early
        Left(DomainError.EmptySchedule(input.toString))

      case nonEmptyOrders =>
        val productMap: Map[ProductId, Product] =
          input.products.map(p => p.productId -> p).toMap

        // Do all orders refer to valid products?
        nonEmptyOrders.find(order => !productMap.contains(order.productId)) match
          case Some(missingOrder) =>
            Left(DomainError.ProductDoesNotExist(missingOrder.productId))

          case None =>
            nonEmptyOrders.sortBy(_.orderId.to).foldLeft(
              // foldLeft goes through each order and carries forward a tuple of (currentTime, accumulatedSchedules)
              Right((0, List.empty[TaskSchedule])): Result[(Int, List[TaskSchedule])]
            ) {
              // for each order
              case (Right((currentTime, acc)), order) =>
                val product = productMap(order.productId)
                // Calls function that schedules all units of this order (based on quantity) and returns a new time and a list of TaskSchedules
                scheduleOrder(order, product, input.tasks, input.humans, input.physicals, currentTime).map:
                  // Appends new schedules to the accumulator
                  case (newTime, orderSchedules) =>
                    (newTime, acc ++ orderSchedules)

              case (left, _) =>
                left
                // At the end of the fold, the result is a Right((finalTime, allSchedules))
                // We just extract the list of TaskSchedule using .map(_._2) (first,second element)
            }.map(_._2)

  // Schedules each unit of the product for the specified order.
  // Each unit is scheduled one after the other using the same task sequence defined in the product.
  private def scheduleOrder(
                             order: Order,
                             product: Product,
                             allTasks: List[Task],
                             allHumans: List[HumanResource],
                             allPhysicals: List[PhysicalResource],
                             startFrom: Int
                           ): Result[(Int, List[TaskSchedule])] =

    // Create a list of placeholder elements representing each unit of the product
    // E.g., if quantity = 3, then we’ll have List((), (), ())
    val productUnits = List.fill(order.quantity)(())

    // Schedule each unit of the product one at a time, sequentially

    // ZipWithIndex: Builds a new iterable collection by applying a partial function to all elements of this iterable collection on which the function is defined.
    productUnits.zipWithIndex.foldLeft(Right((startFrom, List.empty[TaskSchedule])): Result[(Int, List[TaskSchedule])]):
      // foldLeft will go over each unit in sequence, keeping currentTime and acc
      case (Right((currentTime, acc)), (_, index)) =>
        // acc: a list of all scheduled tasks so far
        // Determine the current product unit number (1-based)
        val productNumber = index + 1
        // Schedule all tasks for this unit of the product
        scheduleOneProduct(
          productNumber,
          product.taskRefs,
          currentTime,
          allTasks,
          allHumans,
          allPhysicals,
          order.orderId,
          product.productId
        ).map { case (newTime, schedulesForUnit) =>
          // On success, update current time and add the new unit's task schedules to the accumulated list
        (newTime, acc ++ schedulesForUnit)
        }

      case (left, _) =>
        // If scheduling failed for a previous unit, stop processing and propagate the error
        left

  // Matches physical resources required by a task from the available pool.
  // Each required type must be matched by a resource of the same type.
  // If any required type is unavailable, the entire matching fails.
  private def matchPhysicals(
                              neededTypes: List[String],          // List of required resource types
                              available: List[PhysicalResource],  // All currently available physical resources
                              taskId: String                      // ID of the task that needs these resources (for error reporting)
                            ): Result[List[PhysicalResource]] =   // Either a successful list of assigned resources or a DomainError

    @tailrec  // It goes step-by-step through the needed types and tries to find a matching resource in the pool
    def loop(
              needed: List[String],               // Remaining resource types to match
              pool: List[PhysicalResource],       // Remaining available resources to choose from
              acc: List[PhysicalResource]         // Successfully matched resources (accumulator)
            ): Result[List[PhysicalResource]] = needed match
      case Nil =>
        // All required types have been matched, return reversed accumulator (original order)
        Right(acc.reverse)

      // There are still resource types left
      case headType :: tail =>
        // Try to find a physical resource matching the required type
        pool.find(_.resourceType.to == headType) match
          case Some(p) =>
            // Resource found: remove it from the pool to avoid reuse and add to accumulator
            // and continue matching the remaining types
            val updatedPool = pool.filterNot(_.resourceId == p.resourceId)
            loop(tail, updatedPool, p :: acc)

          // If no resource matches the type, return an error
          case None =>
            // No available resource matches the required type, return an error
            Left(DomainError.ResourceUnavailable(taskId, headType))

    // Start the recursive matching loop with initial parameters
    loop(neededTypes, available, Nil)

  // Matches human resources required by a task from the available pool based on skill types.
  // Each required skill must be matched by a human who possesses it.
  // If any required skill is not found, the matching fails entirely.
  private def matchHumans(
                           requiredTypes: List[String],
                           availableHumans: List[HumanResource],
                           taskId: String
                         ): Result[List[HumanId]] =

    @tailrec
    def loop(
              needed: List[String], // Remaining skill types to match
              pool: List[HumanResource], // Remaining available humans to choose from
              acc: List[HumanId] // Successfully matched skill-human pairs (accumulator)
            ): Result[List[HumanId]] = needed match // List of HumanIds
      case Nil =>
        // All required skills matched successfully
        Right(acc.reverse)

      case headType :: tail =>
        // Look for a human who has the required skill
        pool.find(_.skills.exists(_.to == headType)) match
          case Some(h) =>
            // Human found: remove from pool to avoid reuse, and record skill-to-name mapping
            val updatedPool = pool.filterNot(_.id == h.id)
            loop(tail, updatedPool, h.id :: acc)

          case None =>
            // No human with required skill found, return an error
            Left(DomainError.ResourceUnavailable(taskId, headType))

    loop(requiredTypes, availableHumans, Nil)

  // Schedules all tasks for a single unit of a product.
  // It ensures that each task is scheduled in order, using available resources,
  // and returns the final time after the last task and the full task schedule.
  private def scheduleOneProduct(
                                  productNumber: Int,
                                  taskRefs: List[TaskRef],
                                  startTime: Int,
                                  allTasks: List[Task],
                                  allHumans: List[HumanResource],
                                  allPhysicals: List[PhysicalResource],
                                  orderId: OrderId,
                                  productId: ProductId
                                ): Result[(Int, List[TaskSchedule])] =

    // Build a map of task IDs to task details for fast lookup
    val taskMap: Map[String, Task] = allTasks.map(task => task.taskId.to -> task).toMap

    // Ensure all task references actually exist in the task list
    taskRefs.find(ref => !taskMap.contains(ref.to)) match
      case Some(missingRef) =>
        // Return an error if any task reference is missing
        Left(DomainError.TaskDoesNotExist(missingRef))

      case None =>
        // Proceed to schedule each task in the order defined by taskRefs
        taskRefs.foldLeft(Right((startTime, List.empty[TaskSchedule])): Result[(Int, List[TaskSchedule])]):
          // acc: accumulated list of scheduled tasks
          case (Right((currentTime, acc)), taskRef) =>
            // Get task details using the reference
            val task = taskMap(taskRef.to)

            // Extract the required resource types for this task
            val neededTypes = task.requiredResources.map(_.resourceType.to)

            // Attempt to match physical and human resources to the required types
            for
              matchedPhysicals <- matchPhysicals(neededTypes, allPhysicals, task.taskId.to)
              matchedHumans <- matchHumans(neededTypes, allHumans, task.taskId.to)
            yield
              // Successfully matched resources:
              // - Extract IDs of physicals
              // - Extract names of humans
              // zip: joins both lists together to sync physicalIds, humanNames, and then unzip to separate the lists

              val physicalIds: List[PhysicalResourceId] = matchedPhysicals.map(_.resourceId)
              val humanIds: List[HumanId] = matchedHumans

              // The original intent was to associate each human with a specific physical resource.
              // By zipping them together, we enforce that each matched physical goes with a matched human (based on type).
              // Then we unzip them to return to two lists again, but now knowing they are paired in order.

              // Define the time window for the task execution
              val start = currentTime
              val end = start + task.duration

              // Create a TaskSchedule record
              val schedule = TaskSchedule(
                orderId = orderId,
                productId = productId,
                productNumber = productNumber,
                taskId = task.taskId,
                startTime = start,
                endTime = end,
                allocatedHumanResources = humanIds.distinct,
                allocatedPhysicalResources = physicalIds.distinct
              )

              // Accumulate the schedule and update the time
              (end, schedule +: acc)

          case (left, _) =>
            // If an error occurred in a previous step, propagate it without continuing
            left
