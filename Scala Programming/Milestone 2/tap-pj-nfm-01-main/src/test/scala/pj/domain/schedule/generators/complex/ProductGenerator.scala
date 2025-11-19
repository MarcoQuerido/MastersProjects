package pj.domain.schedule.generators.complex

import org.scalacheck.Gen
import pj.domain.*

object ProductGenerator:

  val minValueId = 1
  val maxValueId = 500  // 500 products max
  val minTaskRef = 1
  val maxTaskRef = 200  // 200 taskref max

  def genProductId: Gen[ProductId] =
    for
      raw <- Gen.choose(minValueId, maxValueId).map(n => s"PRD_$n")
      id <- ProductId.from(raw).fold(_ => Gen.fail, Gen.const)
    yield id

  def genTaskRef: Gen[TaskRef] =
    for {
      raw <- Gen.choose(minTaskRef, maxTaskRef).map(n => s"TSK_$n")
      ref <- TaskRef.from(raw).fold(_ => Gen.fail, Gen.const)
    } yield ref

  def genProductName: Gen[String] =
    Gen.alphaStr.suchThat(_.trim.nonEmpty)

  def genProduct: Gen[Product] =
    for
      id <- genProductId
      name <- genProductName
      taskRefs <- Gen.nonEmptyListOf(genTaskRef)
    yield Product(id, name, taskRefs)
