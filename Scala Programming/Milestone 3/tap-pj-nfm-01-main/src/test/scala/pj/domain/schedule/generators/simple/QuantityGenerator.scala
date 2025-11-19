package pj.domain.schedule.generators.simple

import org.scalacheck.Gen

object QuantityGenerator:

  val minQuantity = 1
  val maxQuantity = 300   // max quantity of a product

  def genQuantity: Gen[Int] =
    Gen.choose(minQuantity, maxQuantity)
