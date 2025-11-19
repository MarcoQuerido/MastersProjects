package pj.domain

final case class Task(taskId: TaskId, duration: Int, requiredResources: List[PhysicalResourceRef])
