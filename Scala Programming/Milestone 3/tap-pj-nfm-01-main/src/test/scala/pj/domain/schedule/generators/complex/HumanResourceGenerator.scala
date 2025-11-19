package pj.domain.schedule.generators.complex

import org.scalacheck.Gen
import pj.domain.*

object HumanResourceGenerator:

  val minValueId = 1
  val maxValueId = 500  // 500 workers
  val minValueResourceType = 1
  val maxValueResourceType = 40 // 40 resource types max

  def genHumanResourceId: Gen[HumanId] =
    for
      raw <- Gen.choose(minValueId, maxValueId).map(n => s"HRS_$n")
      id <- HumanId.from(raw).fold(_ => Gen.fail, Gen.const)
    yield id

  def genResourceType: Gen[ResourceType] = 
    for
      raw <- Gen.choose(minValueResourceType, maxValueResourceType).map(n => s"PRST $n")
      rt <- ResourceType.from(raw).fold(_ => Gen.fail, Gen.const)
    yield rt

  def genResourceTypeSet: Gen[Set[ResourceType]] = 
    for
      count <- Gen.chooseNum(1, 10)
      list <- Gen.listOfN(count, genResourceType)
    yield list.toSet

  def genHumanName: Gen[String] =
    Gen.alphaStr.suchThat(_.trim.nonEmpty)

  def genHumanResource: Gen[HumanResource] =
    for
      id <- genHumanResourceId
      name <- genHumanName
      skills <- genResourceTypeSet
    yield HumanResource(id, name, skills)
