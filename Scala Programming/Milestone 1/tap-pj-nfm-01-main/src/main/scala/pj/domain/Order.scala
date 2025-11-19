package pj.domain

final case class Order(orderId: OrderId, productId: ProductId, quantity: Int)
