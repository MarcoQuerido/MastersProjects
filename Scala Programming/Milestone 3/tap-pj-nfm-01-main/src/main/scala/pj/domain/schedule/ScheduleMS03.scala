package pj.domain.schedule

import scala.xml.{Elem, XML}
import pj.domain.*
import pj.xml.{DomainToXML, XMLFileWriter2, XMLToDomain}
import java.io.File
import scala.io.Source
import scala.util.{Try, Success, Failure}

object ScheduleMS03 extends Schedule:

  def create(xml: Elem): Result[Elem] =
    for
      input <- XMLToDomain.fromProduction(xml)
      inputFileName = findMatchingFileNameByContent(xml, "files/assessment/ms03/")
      scheduled <- scheduleAll(input)
      output <- DomainToXML.generateOutputXML(
        scheduled,
        input.humans.map(h => h.id.to -> h.name).toMap
      )
      _ <- XMLFileWriter2.saveXMLToFile(output, inputFileName.getOrElse(""))
    yield output

  private def scheduleAll(input: ProductionInput): Result[List[TaskSchedule]] =
    val productMap = input.products.map(p => p.productId -> p).toMap
    val taskMap = input.tasks.map(t => t.taskId.to -> t).toMap

    val initial: Result[List[TaskSchedule]] = Right(Nil)
    val sortedOrders = input.orders.sortBy(_.orderId.to)

    sortedOrders.foldLeft(initial):
      case (accResult, order) =>
        for
          schedulesSoFar <- accResult
          product <- productMap.get(order.productId).toRight(DomainError.ProductDoesNotExist(order.productId))
          scheduledOrder <- scheduleOrder(order, product, input.tasks, input.humans, input.physicals, taskMap, schedulesSoFar)
        yield schedulesSoFar ++ scheduledOrder

  private def scheduleOrder(
                             order: Order,
                             product: Product,
                             allTasks: List[Task],
                             allHumans: List[HumanResource],
                             allPhysicals: List[PhysicalResource],
                             taskMap: Map[String, Task],
                             alreadyScheduled: List[TaskSchedule]
                           ): Result[List[TaskSchedule]] =
    val units = List.tabulate(order.quantity)(i => i + 1)
    val initial: Result[(List[TaskSchedule], List[TaskSchedule])] = Right((Nil, alreadyScheduled))

    units.foldLeft(initial) { case (accResult, unitNumber) =>
      for
        (unitSchedules, globalSoFar) <- accResult
        scheduledUnit <- scheduleUnit(order.orderId, product.productId, unitNumber, product.taskRefs, allTasks, allHumans, allPhysicals, taskMap, globalSoFar ++ unitSchedules)
      yield (unitSchedules ++ scheduledUnit, globalSoFar ++ scheduledUnit)
    }.map(_._1)

  def scheduleUnit(
                    orderId: OrderId,
                    productId: ProductId,
                    productNumber: Int,
                    taskRefs: List[TaskRef],
                    allTasks: List[Task],
                    allHumans: List[HumanResource],
                    allPhysicals: List[PhysicalResource],
                    taskMap: Map[String, Task],
                    scheduledSoFar: List[TaskSchedule]
                  ): Result[List[TaskSchedule]] =
    val initial: Result[(Int, List[TaskSchedule])] = Right((0, Nil))

    taskRefs.foldLeft(initial) { case (accResult, taskRef) =>
      for
        (startAfter, acc) <- accResult
        task <- taskMap.get(taskRef.to).toRight(DomainError.TaskDoesNotExist(taskRef))
        (start, end, physMap) <- findEarliestSlot(task, startAfter, allHumans, allPhysicals, scheduledSoFar)
        humanIds = physMap.map(_._2.id).distinct
        physicalIds = physMap.map(_._1.resourceId)
        sched = TaskSchedule(orderId, productId, productNumber, task.taskId, start, end, humanIds, physicalIds)
      yield (end, sched :: acc)
    }.map(_._2.reverse)

  private def findEarliestSlot(
                                task: Task,
                                earliestStart: Int,
                                allHumans: List[HumanResource],
                                allPhysicals: List[PhysicalResource],
                                scheduled: List[TaskSchedule]
                              ): Result[(Int, Int, List[(PhysicalResource, HumanResource)])] =

    val duration = task.duration
    val requiredTypes = task.requiredResources.map(_.resourceType.to)
    val maxSearchTime = 10000 // value to avoid infinite loop

    def isFreeHuman(h: HumanResource, start: Int, end: Int): Boolean =
      !scheduled.exists(s => s.allocatedHumanResources.contains(h.id) && overlaps(s.startTime, s.endTime, start, end))

    def isFreePhysical(p: PhysicalResource, start: Int, end: Int): Boolean =
      !scheduled.exists(s => s.allocatedPhysicalResources.contains(p.resourceId) && overlaps(s.startTime, s.endTime, start, end))

    def findValidAssignments(start: Int, end: Int): Option[List[(PhysicalResource, HumanResource)]] =
      def tryAssign(typesLeft: List[String], usedPhys: Set[String], usedHumans: Set[String]): Option[List[(PhysicalResource, HumanResource)]] =
        typesLeft match
          case Nil => Some(Nil)
          case tpe :: rest =>
            val candidates = for
              p <- allPhysicals if p.resourceType.to == tpe && isFreePhysical(p, start, end) && !usedPhys.contains(p.resourceId.to)
              h <- allHumans if h.skills.exists(_.to == tpe) && isFreeHuman(h, start, end) && !usedHumans.contains(h.id.to)
            yield (p, h)

            candidates.view.flatMap { case (p, h) =>
              tryAssign(rest, usedPhys + p.resourceId.to, usedHumans + h.id.to).map((p, h) :: _)
            }.headOption

      tryAssign(requiredTypes, Set.empty, Set.empty)

    @annotation.tailrec
    def search(t: Int): Result[(Int, Int, List[(PhysicalResource, HumanResource)])] =
      if t > maxSearchTime then // avoid infinite loop
        Left(DomainError.ImpossibleSchedule(""))
      else
        val end = t + duration
        findValidAssignments(t, end) match
          case Some(assignments) => Right((t, end, assignments))
          case None => search(t + 1)

    search(earliestStart)

  def overlaps(aStart: Int, aEnd: Int, bStart: Int, bEnd: Int): Boolean =
    !(aEnd <= bStart || bEnd <= aStart)

  //https://www.scala-lang.org/api/3.x/scala/io/Source$.html
  private def findMatchingFileNameByContent(inputXml: Elem, directoryPath: String): Option[String] =
    val dir = new File(directoryPath)

    val matchingFileOption: Option[File] = dir.listFiles()
      .filter(_.isFile)
      .filter(file => file.getName.startsWith("validAgenda") && file.getName.endsWith("_in.xml"))
      .find { file =>
        val result = Try:
          val fileContent = Source.fromFile(file, "UTF-8").mkString
          val fileElem = XML.loadString(fileContent)
          inputXml == fileElem
        result match
          case Success(isMatch) => isMatch
          case Failure(e) =>
            println(s"Warning: Could not read or parse file '${file.getName}' in '$directoryPath'. Error: ${e.getMessage}")
            false
      }

    matchingFileOption.map(_.getName)