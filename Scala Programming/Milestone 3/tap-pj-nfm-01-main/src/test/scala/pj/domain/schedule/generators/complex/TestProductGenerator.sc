import org.scalacheck.Gen
import pj.domain.schedule.generators.complex.ProductGenerator.genProduct
import pj.domain.Product

val productSamples: List[Option[Product]] =
  List.fill(5)(genProduct.sample)

productSamples.zipWithIndex.foreach {
  case (Some(prod), i) =>
    println(s"[$i] Product ID: ${prod.productId}, TaskRefs: ${prod.taskRefs.map(identity).mkString(", ")}")
  case (None, i) =>
    println(s"[$i] Failed to generate")
}
