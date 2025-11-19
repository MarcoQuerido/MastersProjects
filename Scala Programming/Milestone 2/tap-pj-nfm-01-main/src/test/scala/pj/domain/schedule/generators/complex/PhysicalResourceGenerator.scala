package pj.domain.schedule.generators.complex

import org.scalacheck.Gen
import pj.domain.*

object PhysicalResourceGenerator:

  val minValueId = 1
  val maxValueId = 99
  val minValueTypes = 1
  val maxValueTypes = 200
  
  def genPhysicalResourceId: Gen[PhysicalResourceId] =
    for
      raw <- Gen.choose(minValueId, maxValueId).map(n => s"PRS_$n")
      id  <- PhysicalResourceId.from(raw).fold(_ => Gen.fail, Gen.const)
    yield id
  
  def genResourceType: Gen[ResourceType] =
    for
      raw <- Gen.choose(minValueTypes, maxValueTypes).map(n => s"PRST $n")
      rt  <- ResourceType.from(raw).fold(_ => Gen.fail, Gen.const)
    yield rt

  def genPhysicalResource: Gen[PhysicalResource] =
    for
      id <- genPhysicalResourceId
      tpe <- genResourceType
    yield PhysicalResource(id, tpe)
