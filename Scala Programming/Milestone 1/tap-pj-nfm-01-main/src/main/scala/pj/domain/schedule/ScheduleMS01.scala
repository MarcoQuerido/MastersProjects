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
        Right(scheduled),
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
        val startTime = 0 // Initialize scheduling time counter at 0

        val productMap: Map[ProductId, Product] =
          input.products.map(p => p.productId -> p).toMap

        nonEmptyOrders.find(order => !productMap.contains(order.productId)) match
          case Some(missingOrder) =>
            Left(DomainError.ProductDoesNotExist(missingOrder.productId.to))

          case None =>
            nonEmptyOrders.sortBy(_.orderId.to).foldLeft(
              Right((startTime, List.empty[TaskSchedule])): Result[(Int, List[TaskSchedule])]
            ) {
              case (Right((currentTime, acc)), order) =>
                val product = productMap(order.productId)
                scheduleOrder(order, product, input.tasks, input.humans, input.physicals, currentTime).map:
                  case (newTime, orderSchedules) =>
                    (newTime, acc ++ orderSchedules)

              case (left, _) =>
                left
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
    // Use foldLeft to carry the current time and accumulated task schedules
    productUnits.zipWithIndex.foldLeft(Right((startFrom, List.empty[TaskSchedule])): Result[(Int, List[TaskSchedule])]):
      case (Right((currentTime, acc)), (_, index)) =>
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
          order.orderId.to,
          product.productId.to
        ).map { case (newTime, schedulesForUnit) =>
          // On success, update current time and append the unit's schedule to the result list
          (newTime, acc ++ schedulesForUnit)
        }

      case (left, _) =>
        // If scheduling failed for a previous unit, stop processing and propagate the error
        left

  // Matches physical resources required by a task from the available pool.
  // Each required type must be matched by a resource of the same type.
  // If any required type is unavailable, the entire matching fails.
  private def matchPhysicals(
                              neededTypes: List[String],
                              available: List[PhysicalResource],
                              taskId: String
                            ): Result[List[PhysicalResource]] =

    @tailrec
    def loop(
              needed: List[String],               // Remaining resource types to match
              pool: List[PhysicalResource],       // Remaining available resources to choose from
              acc: List[PhysicalResource]         // Successfully matched resources (accumulator)
            ): Result[List[PhysicalResource]] = needed match
      case Nil =>
        // All required types have been matched, return reversed accumulator (original order)
        Right(acc.reverse)

      case headType :: tail =>
        // Try to find a physical resource matching the required type
        pool.find(_.resourceType.to == headType) match
          case Some(p) =>
            // Resource found: remove it from the pool to avoid reuse and add to accumulator
            val updatedPool = pool.filterNot(_.resourceId == p.resourceId)
            loop(tail, updatedPool, p :: acc)

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
                         ): Result[List[(String, String)]] = // Returns a list of (skillType, humanName) pairs

    @tailrec
    def loop(
              needed: List[String], // Remaining skill types to match
              pool: List[HumanResource], // Remaining available humans to choose from
              acc: List[(String, String)] // Successfully matched skill-human pairs (accumulator)
            ): Result[List[(String, String)]] = needed match
      case Nil =>
        // All required skills matched successfully
        Right(acc.reverse)

      case headType :: tail =>
        // Look for a human who has the required skill
        pool.find(_.skills.exists(_.to == headType)) match
          case Some(h) =>
            // Human found: remove from pool to avoid reuse, and record skill-to-name mapping
            val updatedPool = pool.filterNot(_.id == h.id)
            loop(tail, updatedPool, (headType, h.name) :: acc)

          case None =>
            // No human with required skill found, return an error
            Left(DomainError.ResourceUnavailable(taskId, headType))

    // Start the matching process
    loop(requiredTypes, availableHumans, Nil)

  // Schedules all tasks for a single unit of a product sequentially.
  // It ensures that each task is scheduled in order, using available resources,
  // and returns the final time after the last task and the full task schedule.
  private def scheduleOneProduct(
                                  productNumber: Int,
                                  taskRefs: List[TaskRef],
                                  startTime: Int,
                                  allTasks: List[Task],
                                  allHumans: List[HumanResource],
                                  allPhysicals: List[PhysicalResource],
                                  orderId: String,
                                  productId: String
                                ): Result[(Int, List[TaskSchedule])] =

    // Build a map of task IDs to task details for fast lookup
    val taskMap: Map[String, Task] = allTasks.map(task => task.taskId.to -> task).toMap

    // Ensure all task references actually exist in the task list
    taskRefs.find(ref => !taskMap.contains(ref.to)) match
      case Some(missingRef) =>
        // Return an error if any task reference is missing
        Left(DomainError.TaskDoesNotExist(missingRef.to))

      case None =>
        // Proceed to schedule each task in the order defined by taskRefs
        taskRefs.foldLeft(Right((startTime, List.empty[TaskSchedule])): Result[(Int, List[TaskSchedule])]):
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
              val (physicalIds, humanNames) = matchedPhysicals.map(_.resourceId.to).zip(matchedHumans.map(_._2)).unzip

              // Define the time window for the task execution
              val start = currentTime
              val end = start + task.duration

              // Create a TaskSchedule record
              val schedule = TaskSchedule(
                orderId = orderId,
                productId = productId,
                productNumber = productNumber,
                taskId = task.taskId.to,
                startTime = start,
                endTime = end,
                allocatedHumanResources = humanNames.distinct,       // Avoid duplicates
                allocatedPhysicalResources = physicalIds.distinct    // Avoid duplicates
              )

              // Accumulate the schedule and update the time
              (end, schedule +: acc)

          case (left, _) =>
            // If an error occurred in a previous step, propagate it without continuing
            left
