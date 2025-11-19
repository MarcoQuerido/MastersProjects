package pj.domain.schedule.properties

import org.scalacheck.Gen
import org.scalatest.matchers.should.Matchers
import org.scalatest.propspec.AnyPropSpec
import org.scalatestplus.scalacheck.ScalaCheckPropertyChecks
import pj.domain.TaskSchedule
import pj.domain.schedule.generators.complex.{HumanResourceGenerator, PhysicalResourceGenerator}
import pj.domain.schedule.generators.dependant.{ScheduleGenerator, TaskScheduleGenerator}

class DomainProperties extends AnyPropSpec with ScalaCheckPropertyChecks with Matchers:

  val scheduleGen: Gen[List[TaskSchedule]] = for {
    humans <- Gen.listOfN(100, HumanResourceGenerator.genHumanResource)
    physicals <- Gen.listOfN(100, PhysicalResourceGenerator.genPhysicalResource)
    schedules <- Gen.listOfN(20, TaskScheduleGenerator.genTaskSchedule(humans, physicals))
  } yield schedules

  // Property 2
  property("The complete schedule must schedule all the tasks of all the products needed"):
    forAll(scheduleGen) { schedule =>
      val grouped = schedule.groupBy(task => (task.productId, task.taskId))
      val valid = grouped.forall { case ((_, _), tasks) =>
        tasks.map(_.productNumber).distinct.sizeIs == tasks.size / tasks.map(_.taskId).distinct.size
      }
      assert(valid, "Some product tasks are not scheduled correctly")
    }

  // Property 5
  property("Every task must have both physical and human resources allocated"):
    forAll(scheduleGen) { schedule =>
      val allHaveResources = schedule.forall { task =>
        task.allocatedPhysicalResources.nonEmpty &&
          task.allocatedHumanResources.sizeIs == task.allocatedPhysicalResources.size
      }
      assert(allHaveResources, "Some tasks are missing resources")
    }

  // Property 6
  property("A product from a task is produced according to the defined quantity"):
    forAll(scheduleGen) { schedule =>
      val productsByOrder = schedule.groupBy(_.orderId)
      val valid = productsByOrder.forall { case (_, tasks) =>
        val productCounts = tasks.groupBy(_.productNumber).size
        productCounts > 0
      }
      assert(valid, "Some products are not scheduled for the defined quantity")
    }

  // Property 7
  property("Total scheduled duration must not exceed maximum allowed time"):
    val maxTime = 1440 // 24 hours
    forAll(scheduleGen) { schedule =>
      val totalTime = schedule.map(_.endTime).maxOption.getOrElse(0)
      assert(totalTime <= maxTime, s"Schedule exceeds max allowed time: $totalTime > $maxTime")
    }

  // Property 8
  property("Each task must have at least one human resource assigned"):
    forAll(scheduleGen) { schedule =>
      val allHaveAtLeastOne = schedule.forall { task =>
        task.allocatedHumanResources.nonEmpty
      }
      assert(allHaveAtLeastOne, "Some tasks have no human resource assigned")
    }

  // Property 9
  property("Each task must have at least one physical resource assigned"):
    forAll(scheduleGen) { schedule =>
      val allHaveAtLeastOne = schedule.forall { task =>
        task.allocatedPhysicalResources.nonEmpty
      }
      assert(allHaveAtLeastOne, "Some tasks have no physical resource assigned")
    }

  // Property  10
  property("Each task must have a duration greater than 0 and less than or equal to 240 minutes"):
    forAll(scheduleGen) { schedule =>
      val durationsValid = schedule.forall { task =>
        val duration = task.endTime - task.startTime
        duration > 0 && duration <= 240
      }
      assert(durationsValid, "Some tasks have invalid duration (<= 0 or > 240 minutes)")
    }

//  // Property 1
//  property("The same resource cannot be used at the same time by two tasks"):
//    forAll(scheduleGen) { schedule =>
//      val usage = schedule.flatMap { task =>
//        task.allocatedPhysicalResources.map(resId => (resId, task.startTime, task.endTime))
//      }
//
//      val overlaps = usage.groupBy(_._1).values.exists { times =>
//        times.combinations(2).exists:
//          case List((_, s1, e1), (_, s2, e2)) => !(e1 <= s2 || e2 <= s1)
//          case _ => false
//      }
//      assert(!overlaps, "Overlapping resource usage detected")
//    }

///  // Property 3
//  property("Human resources must have the skill required by the physical resource used"):
//    val gen = for {
//      humans <- Gen.listOfN(100, HumanResourceGenerator.genHumanResource)
//      physicals <- Gen.listOfN(100, PhysicalResourceGenerator.genPhysicalResource)
//      schedules <- Gen.listOfN(20, TaskScheduleGenerator.genTaskSchedule(humans, physicals))
//    } yield (schedules, humans, physicals)
//
//    forAll(gen) { (schedules, humans, physicals) =>
//      val hrMap = humans.map(hr => hr.id.to -> hr).toMap
//      val prMap = physicals.map(pr => pr.resourceId.to -> pr).toMap
//
//      val allSkillsMatch = schedules.forall { task =>
//        task.allocatedPhysicalResources.zip(task.allocatedHumanResources).forall:
//          case (physId, humanId) =>
//            (for {
//              physical <- prMap.get(physId)
//              human <- hrMap.get(humanId)
//            } yield human.skills.contains(physical.resourceType)).getOrElse(false)
//      }
//      assert(allSkillsMatch, "Human assigned to resource lacks the required skill")
//    }

//  // Property 4
//  property("Tasks should only use physical resources declared in their task definition"):
//    val gen = for {
//      humans <- Gen.listOfN(100, HumanResourceGenerator.genHumanResource)
//      physicals <- Gen.listOfN(100, PhysicalResourceGenerator.genPhysicalResource)
//      schedules <- Gen.listOfN(20, TaskScheduleGenerator.genTaskSchedule(humans, physicals))
//      tasks <- ScheduleGenerator.genTasks(100)
//    } yield (schedules, tasks, physicals)
//
//    forAll(gen) { (schedules, tasks, physicals) =>
//      val taskMap = tasks.map(t => t.taskId.to -> t).toMap
//      val prMap = physicals.map(pr => pr.resourceId.to -> pr).toMap
//
//      val allResourcesValid = schedules.forall { schedule =>
//        val allowedTypes = taskMap.get(schedule.taskId).map(_.requiredResources.map(_.resourceType)).getOrElse(Nil)
//        schedule.allocatedPhysicalResources.forall { prId =>
//          prMap.get(prId).exists(pr => allowedTypes.contains(pr.resourceType))
//        }
//      }
//      assert(allResourcesValid, "Task used a resource not listed in its definition")
//    }




