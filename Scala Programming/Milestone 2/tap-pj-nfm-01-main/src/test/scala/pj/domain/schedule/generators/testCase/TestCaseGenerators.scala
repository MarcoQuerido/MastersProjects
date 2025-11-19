package pj.domain.schedule.generators.testCase

import org.scalacheck.Gen
import pj.domain.*
import pj.domain.schedule.generators.complex.PhysicalResourceGenerator.genPhysicalResourceId
import pj.domain.schedule.generators.complex.ProductGenerator.genProductId
import pj.domain.schedule.generators.dependant.OrderGenerator.genOrderId
import pj.domain.schedule.generators.dependant.TaskGenerator.{genPhysicalResourceRefs, genTaskId}
import pj.domain.schedule.generators.simple.DurationGenerator.genDuration

import java.time.Duration

object TestCaseGenerators:

  // 1. Task that only requires 1 physical resource
  def genTaskWithOnePhysicalResource: Gen[Task] =
    for {
      taskId <- genTaskId
      duration <- genDuration
      durationMinutes = duration.toMinutes.toInt
      resourceId <- genPhysicalResourceId
      resourceRefs <- genPhysicalResourceRefs(1)
      resourceRef <- Gen.oneOf(resourceRefs)
    } yield Task(taskId, durationMinutes, List(resourceRef))

  // 2. Tasks with zero duration
  def genTaskWithZeroDuration: Gen[Task] =
    for {
      taskId <- genTaskId
    } yield Task(taskId, 0, Nil)

  // 3. Multiple tasks using the same physical resource (to simulate resource contention)
  def genTasksSharingSameResource(count: Int): Gen[List[Task]] =
    for {
      resourceRefs <- genPhysicalResourceRefs(1)
      resourceRef <- Gen.oneOf(resourceRefs)
      tasks <- Gen.listOfN(count,
        for {
          taskId <- genTaskId
          duration <- genDuration
          durationMinutes = duration.toMinutes.toInt
        } yield Task(taskId, durationMinutes, List(resourceRef))
      )
    } yield tasks

  // 4. Task with a reference to a non-existent resource (Invalid Case)
  def genTaskWithMissingResource: Gen[Task] =
    for {
      taskId <- genTaskId
      duration <- genDuration
      durationMinutes = duration.toMinutes.toInt
      resourceRefs <- genPhysicalResourceRefs(1)
    } yield Task(taskId, durationMinutes, List(PhysicalResourceRef(ResourceType.InvalidRT)))

  // 5. Dependent execution chain of tasks
  def genDependentTaskChain(n: Int): Gen[List[Task]] =
    Gen.sequence[List[Task], Task]((0 until n).map { i =>
      for {
        taskId <- genTaskId
        duration <- genDuration
        durationMinutes = duration.toMinutes.toInt
        resourceId <- genPhysicalResourceId
        resourceRefs <- genPhysicalResourceRefs(1)
        resourceRef <- Gen.oneOf(resourceRefs)
      } yield Task(taskId, durationMinutes, List(resourceRef))
    })

  // 6. Order with quantity zero
  def genOrderWithZeroQuantity: Gen[Order] =
    for {
      orderId <- genOrderId
      productId <- genProductId
    } yield Order(orderId, productId, 0)

  // 7. Task with maximum allowed duration
  def genTaskWithMaxDuration: Gen[Task] =
    for {
      taskId <- genTaskId
      resourceRefs <- genPhysicalResourceRefs(1)
      resourceRef <- Gen.oneOf(resourceRefs)
    } yield Task(taskId, 240, List(resourceRef)) // 240 minutes = 4 hours

  // 8. Task with no resources
  def genTaskWithNoResources: Gen[Task] =
    for {
      taskId <- genTaskId
      duration <- genDuration
      durationMinutes = duration.toMinutes.toInt
    } yield Task(taskId, durationMinutes, Nil)