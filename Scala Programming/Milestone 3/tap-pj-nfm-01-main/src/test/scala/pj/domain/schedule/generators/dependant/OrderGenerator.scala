package pj.domain.schedule.generators.dependant

import org.scalacheck.Gen
import pj.domain.*
import pj.domain.schedule.generators.complex.ProductGenerator
import pj.domain.schedule.generators.simple.QuantityGenerator

object OrderGenerator:

  val minValueId = 1
  val maxValueId = 999

  def genOrderId: Gen[OrderId] =
    for {
      raw <- Gen.choose(minValueId, maxValueId).map(n => s"ORD_$n")
      id  <- OrderId.from(raw).fold(_ => Gen.fail, Gen.const)
    } yield id

  def genOrder: Gen[Order] =
    for
      id <- genOrderId
      productId <- ProductGenerator.genProductId
      quantity <- QuantityGenerator.genQuantity
    yield Order(id, productId, quantity)
