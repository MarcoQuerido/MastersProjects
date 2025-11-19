import org.scalacheck.Gen
import pj.domain.schedule.generators.dependant.TaskGenerator.genTask
import pj.domain.Task

val taskSamples: List[Option[Task]] =
  List.fill(5)(genTask.sample)

taskSamples.zipWithIndex.foreach {
  case (Some(task), i) =>
    println(s"[$i] Task ID: ${task.taskId}, Duration: ${task.duration}, Resources: ${task.requiredResources.map(_.resourceType.to).mkString(", ")}")
  case (None, i) =>
    println(s"[$i] Failed to generate")
}
