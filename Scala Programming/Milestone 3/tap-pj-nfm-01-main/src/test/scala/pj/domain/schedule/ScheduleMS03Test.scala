package pj.domain.schedule

import org.scalatest.funsuite.AnyFunSuite
import pj.domain.*
import pj.domain.schedule.generators.dependant.TaskGenerator.genTask

import org.scalatest.EitherValues.*

class ScheduleMS03Test extends AnyFunSuite:

  test("overlaps: true when intervals partially overlap"):
    val result = ScheduleMS03.overlaps(0, 10, 5, 15)
    assert(result)

  test("overlaps: true when one interval is fully within the other"):
    val result = ScheduleMS03.overlaps(0, 10, 2, 5)
    assert(result)

  test("overlaps: false when intervals are adjacent but not overlapping"):
    val result = ScheduleMS03.overlaps(0, 10, 10, 15)
    assert(!result)

  test("overlaps: false when first ends before second starts"):
    val result = ScheduleMS03.overlaps(0, 5, 6, 10)
    assert(!result)

  test("overlaps: true when both intervals start at same time"):
    val result = ScheduleMS03.overlaps(5, 10, 5, 8)
    assert(result)

  test("overlaps: false when second ends before first starts"):
    val result = ScheduleMS03.overlaps(10, 20, 0, 9)
    assert(!result)

  test("scheduleUnit: should return one scheduled task when all resources are available"):
    val humanId = HumanId.from("HRS_1").getOrElse(fail("Invalid HumanId"))
    val resourceType = ResourceType.from("PRST_1").getOrElse(fail("Invalid ResourceType"))
    val human = HumanResource(humanId, "Joana", Set(resourceType))

    val physicalResourceId = PhysicalResourceId.from("PRS_1").getOrElse(fail("Invalid PhysicalResourceId"))
    val physical = PhysicalResource(physicalResourceId, resourceType)
    val physicalResourceRef = PhysicalResourceRef(resourceType)

    val taskId = TaskId.from("TSK_1").getOrElse(fail("Invalid TaskId"))
    val task = Task(taskId, 5, List(physicalResourceRef))
    val taskRef = TaskRef.from("TSK_1").getOrElse(fail("Invalid TaskRef"))

    val result: Result[List[TaskSchedule]] = ScheduleMS03.scheduleUnit(
      orderId = OrderId.from("ORD_1").getOrElse(fail("Invalid OrderId")),
      productId = ProductId.from("PRD_1").getOrElse(fail("Invalid ProductId")),
      productNumber = 1,
      taskRefs = List(taskRef),
      allTasks = List(task),
      allHumans = List(human),
      allPhysicals = List(physical),
      taskMap = Map("TSK_1" -> task),
      scheduledSoFar = Nil
    )

    val schedList = result.fold(
      err => fail(s"Expected scheduling to succeed, but failed with: $err"),
      identity
    )

    val sched = schedList.headOption.fold {
      fail("Expected one scheduled task, but got None")
    }(identity)

    assert(sched.taskId == task.taskId)
    assert(sched.allocatedHumanResources.contains(human.id))
    assert(sched.allocatedPhysicalResources.contains(physical.resourceId))

  test("scheduleUnit: should fail when taskRef is missing from taskMap"):
    val taskRef = TaskRef.from("TSK_404").getOrElse(fail("Invalid TaskRef"))
    val orderId = OrderId.from("ORD_1").getOrElse(fail("Invalid OrderId"))
    val productId = ProductId.from("PRD_1").getOrElse(fail("Invalid ProductId"))

    val result = ScheduleMS03.scheduleUnit(
      orderId = orderId,
      productId = productId,
      productNumber = 1,
      taskRefs = List(taskRef),
      allTasks = Nil,
      allHumans = Nil,
      allPhysicals = Nil,
      taskMap = Map(),
      scheduledSoFar = Nil
    )

    result.fold(
      err => assert(err == DomainError.TaskDoesNotExist(taskRef)),
      _ => fail("Expected TaskDoesNotExist error, but got success")
    )

  test("scheduleUnit: should fail when task has no required resources"):
    val taskId = TaskId.from("TSK_1").getOrElse(fail("Invalid TaskId"))
    val task = Task(taskId, 5, List())
    
    val taskRef = TaskRef.from("TSK_1").getOrElse(fail("Invalid TaskRef"))
    val orderId = OrderId.from("ORD_1").getOrElse(fail("Invalid OrderId"))
    val productId = ProductId.from("PRD_1").getOrElse(fail("Invalid ProductId"))

    val result = ScheduleMS03.scheduleUnit(
      orderId = orderId,
      productId = productId,
      productNumber = 1,
      taskRefs = List(taskRef),
      allTasks = List(task),
      allHumans = Nil,
      allPhysicals = Nil,
      taskMap = Map("TSK_1" -> task),
      scheduledSoFar = Nil
    )

    result.fold(
      err => assert(err == DomainError.ResourceUnavailable("TSK_1", "unknown")),
      _ => fail("Expected failure due to missing required resources, but got success")
    )

  test("scheduleUnit: should fail when no available human or physical resources") {
    val task = genTask.sample.fold(fail("Could not generate task"))(identity)

    val taskRef = TaskRef.from("TSK_1").getOrElse(fail("Invalid TaskRef"))
    val orderId = OrderId.from("ORD_1").getOrElse(fail("Invalid OrderId"))
    val productId = ProductId.from("PRD_1").getOrElse(fail("Invalid ProductId"))

    val result = ScheduleMS03.scheduleUnit(
      orderId = orderId,
      productId = productId,
      productNumber = 1,
      taskRefs = List(taskRef),
      allTasks = List(task),
      allHumans = List(), // no humans
      allPhysicals = List(), // no physicals
      taskMap = Map("TSK_1" -> task),
      scheduledSoFar = Nil
    )

    result.fold(
      {
        case DomainError.ImpossibleSchedule(_) => succeed
        case other => fail(s"Expected ImpossibleSchedule, got: $other")
      },
      _ => fail("Expected failure due to no available resources, but got success")
    )
  }