package pj.domain

final case class Product(productId: ProductId, name: String, taskRefs: List[TaskRef])
