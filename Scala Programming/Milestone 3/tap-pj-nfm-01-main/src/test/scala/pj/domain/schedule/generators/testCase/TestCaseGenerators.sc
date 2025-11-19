import pj.domain.schedule.generators.testCase.TestCaseGenerators.*
import pj.domain.{Order, Task}

val samples = List(
  "Task with One Physical Resource" -> genTaskWithOnePhysicalResource.sample,
  "Task with Zero Duration"         -> genTaskWithZeroDuration.sample,
  "Tasks Sharing Same Resource"     -> genTasksSharingSameResource(3).sample,
  "Task with Missing Resource"      -> genTaskWithMissingResource.sample,
  "Dependent Task Chain"            -> genDependentTaskChain(5).sample,
  "Order with Zero Quantity"        -> genOrderWithZeroQuantity.sample,
  "Task with Max Duration"          -> genTaskWithMaxDuration.sample,
  "Task with No Resources"          -> genTaskWithNoResources.sample
)

samples.zipWithIndex.foreach {
  case ((description, Some(value)), i) =>
    println(s"[${i + 1}] $description:")

    value match
      case tasks: List[Task] =>
        tasks.zipWithIndex.foreach { case (task, idx) =>
          println(s"  ${idx + 1}. $task")
        }
      case task: Task =>
        println(task)
      case order: Order =>
        println(order)

    println()

  case ((description, None), i) =>
    println(s"[${i + 1}] $description: Failed to generate\n")
}
