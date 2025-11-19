import org.scalacheck.Gen
import pj.domain.schedule.generators.simple.QuantityGenerator.genQuantity

val quantitySamples: List[Option[Int]] =
  List.fill(20)(genQuantity.sample)

quantitySamples.zipWithIndex.foreach {
  case (Some(qty), i) => println(s"[$i] Quantity: $qty")
  case (None, i)      => println(s"[$i] Failed to generate")
}
