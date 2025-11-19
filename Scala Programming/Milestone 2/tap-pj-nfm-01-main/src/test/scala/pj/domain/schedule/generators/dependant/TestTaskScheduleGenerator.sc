import org.scalacheck.Gen
import pj.domain.TaskSchedule
import pj.domain.schedule.generators.complex.HumanResourceGenerator
import pj.domain.schedule.generators.complex.PhysicalResourceGenerator
import pj.domain.schedule.generators.dependant.TaskScheduleGenerator.genTaskSchedule

val humansOpt = Gen.listOfN(10, HumanResourceGenerator.genHumanResource).sample
val physicalsOpt = Gen.listOfN(10, PhysicalResourceGenerator.genPhysicalResource).sample

(humansOpt, physicalsOpt) match
  case (Some(humans), Some(physicals)) =>
    val scheduleGen = genTaskSchedule(humans, physicals)

    val scheduleSamples: List[Option[TaskSchedule]] =
      List.fill(5)(scheduleGen.sample)

    scheduleSamples.zipWithIndex.foreach {
      case (Some(schedule), i) =>
        println(s"[$i] TaskSchedule:")
        println(s"Order ID: ${schedule.orderId}")
        println(s"Product ID: ${schedule.productId}")
        println(s"Product Number: ${schedule.productNumber}")
        println(s"Task ID: ${schedule.taskId}")
        println(s"Start Time: ${schedule.startTime}")
        println(s"End Time: ${schedule.endTime}")
        println(s"Human Resources: ${schedule.allocatedHumanResources.mkString(", ")}")
        println(s"Physical Resources: ${schedule.allocatedPhysicalResources.mkString(", ")}")
        println("\n")
      case (None, i) =>
        println(s"[$i] Failed to generate task schedule.")
    }

  case _ =>
    println("Failed to generate human or physical resources.")
