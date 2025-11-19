package pj.domain

final case class TaskSchedule(
  orderId: OrderId,
  productId: ProductId,
  productNumber: Int,
  taskId: TaskId,
  startTime: Int,
  endTime: Int,
  allocatedHumanResources: List[HumanId],
  allocatedPhysicalResources: List[PhysicalResourceId])

