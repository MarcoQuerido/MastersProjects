package pj.domain.schedule.generators.dependant

import org.scalacheck.Gen
import pj.domain.*
import pj.domain.schedule.generators.complex.ProductGenerator
import pj.domain.schedule.generators.complex.ProductGenerator.genProductId
import pj.domain.schedule.generators.dependant.OrderGenerator.genOrderId
import pj.domain.schedule.generators.dependant.TaskGenerator.genTaskId
import pj.domain.schedule.generators.simple.DurationGenerator
import pj.domain.schedule.generators.simple.DurationGenerator.genDuration

object TaskScheduleGenerator:

  def genTaskSchedule(humans: List[HumanResource], physicals: List[PhysicalResource]): Gen[TaskSchedule] =
    for
      orderId <- genOrderId
      productId <- genProductId
      productNumber <- Gen.choose(1, 100)
      taskId <- genTaskId
      startTime <- Gen.chooseNum(0, 500)
      duration <- genDuration
      durationMinutes = duration.toMinutes.toInt
      endTime = startTime + durationMinutes

      numResources <- Gen.chooseNum(1, 5)

      matchedPairs <- genCompatibleHumanPhysicalPairs(humans, physicals, numResources)
      (humanIds, physicalIds) = matchedPairs.unzip
    yield TaskSchedule(orderId, productId, productNumber, taskId, startTime, endTime, humanIds, physicalIds)

  def genCompatibleHumanPhysicalPairs(
                                       humans: List[HumanResource],
                                       physicals: List[PhysicalResource],
                                       numPairs: Int
                                     ): Gen[List[(HumanId, PhysicalResourceId)]] =

    val compatiblePhysicals = physicals.filter(pr => humans.exists(hr => hr.skills.contains(pr.resourceType)))

    for {
      selectedPhysicals <- Gen.pick(numPairs.min(compatiblePhysicals.size), compatiblePhysicals)

      matchedPairs <-
        val gens: List[Gen[(HumanId, PhysicalResourceId)]] = selectedPhysicals.toList.map { pr =>
          val compatibleHumans = humans.filter(_.skills.contains(pr.resourceType))
          Gen.oneOf(compatibleHumans).map(hr => (hr.id, pr.resourceId))
        }

        gens.foldRight(Gen.const(List.empty[(HumanId, PhysicalResourceId)])) { (genPair, acc) =>
          for {
            pair <- genPair
            rest <- acc
          } yield pair :: rest
        }
    } yield matchedPairs
