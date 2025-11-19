package pj.domain.schedule.generators.dependant

import org.scalacheck.Gen
import pj.domain.*
import pj.domain.schedule.generators.simple.DurationGenerator

object TaskGenerator:

  val minValueId = 1
  val maxValueId = 500 // 500 Tasks
  val minValueResource = 1
  val maxValueResource = 10 // 10 Physical Resources max for a task
  val rawResourceTypes: List[String] = (minValueResource to maxValueResource).map(n => s"PRST $n").toList

  def genTaskId: Gen[TaskId] =
    for {
      raw <- Gen.choose(minValueId, maxValueId).map(n => s"TSK_$n")
      id  <- TaskId.from(raw).fold(_ => Gen.fail, Gen.const)
    } yield id

  def genPhysicalResourceRefs(numberOfRT: Int): Gen[List[PhysicalResourceRef]] =
    for
      pickedRaw <- Gen.pick(numberOfRT, rawResourceTypes) // pick distinct elements
      refs <- pickedRaw.toList.foldLeft(Gen.const(List.empty[PhysicalResourceRef])) { (accGen, raw) =>
        accGen.flatMap { acc =>
          ResourceType.from(raw) match
            case Right(resourceType) =>
              Gen.const(PhysicalResourceRef(resourceType) :: acc)
            case Left(_) =>
              Gen.fail // fail the whole generator if any conversion fails
        }
      }
    yield refs

  def genTask: Gen[Task] =
    for
      id <- genTaskId
      duration <- DurationGenerator.genDuration.map(_.toMinutes.toInt)
      numRes <- Gen.chooseNum(minValueResource, maxValueResource)
      required <- genPhysicalResourceRefs(numRes)
    yield Task(id, duration, required)
