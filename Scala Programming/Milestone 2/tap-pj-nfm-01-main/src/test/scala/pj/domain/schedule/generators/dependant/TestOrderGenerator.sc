import org.scalacheck.Gen
import pj.domain.Order
import pj.domain.schedule.generators.dependant.OrderGenerator

val genOrder: Gen[Order] = OrderGenerator.genOrder

val orderSamples: List[Option[Order]] =
  List.fill(5)(genOrder.sample)

orderSamples.zipWithIndex.foreach {
  case (Some(order), i) =>
    println(s"[$i] ${order.orderId}, ${order.productId}, qty: ${order.quantity}")
  case (None, i) =>
    println(s"[$i] Failed to generate")
}
