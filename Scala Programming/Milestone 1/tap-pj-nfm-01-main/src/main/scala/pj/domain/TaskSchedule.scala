package pj.domain

final case class TaskSchedule(
  orderId: String,
  productId: String,
  productNumber: Int,
  taskId: String,
  startTime: Int,
  endTime: Int,
  allocatedHumanResources: List[String],
  allocatedPhysicalResources: List[String])

