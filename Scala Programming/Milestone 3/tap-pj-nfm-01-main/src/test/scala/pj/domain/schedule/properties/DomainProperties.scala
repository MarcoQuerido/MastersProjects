package pj.domain.schedule.properties

import org.scalacheck.Gen
import org.scalatest.matchers.should.Matchers
import org.scalatest.propspec.AnyPropSpec
import org.scalatestplus.scalacheck.ScalaCheckPropertyChecks
import pj.domain.*
import pj.domain.schedule.generators.dependant.ScheduleGenerator
import pj.domain.schedule.ScheduleMS03
import scala.xml.Elem

class DomainProperties extends AnyPropSpec with ScalaCheckPropertyChecks with Matchers:

  val ScheduleGen: Gen[(List[Order], List[Product], List[Task], List[PhysicalResource], List[HumanResource])] =
    ScheduleGenerator.genSchedule(3, 2, 4, 5, 5)


  // Property 1: Every product must define at least one task reference
  property("Every product must have a non-empty list of task references"):
    forAll(ScheduleGen) { (_, products, _, _, _) =>
      val valid = products.forall(_.taskRefs.nonEmpty)
      assert(valid, "Some products have no task references")
    }

  // Property 2: All tasks must reference valid physical resource types
  property("All tasks must require valid physical resource types"):
    forAll(ScheduleGen) { (_, _, tasks, _, _) =>
      val valid = tasks.forall(task => task.requiredResources.nonEmpty && task.requiredResources.forall(_.resourceType.to.startsWith("PRST")))
      assert(valid, "Some tasks reference invalid or empty physical resource types")
    }

  // Property 3: No two tasks should have the same task ID
  property("Task IDs must be unique across all tasks"):
    forAll(ScheduleGen) { (_, _, tasks, _, _) =>
      val unique = tasks.map(_.taskId).distinct.sizeIs == tasks.size
      assert(unique, "Duplicate task IDs found")
    }

  // Property 4: Each human resource must have at least one skill
  property("Every human resource must have at least one skill"):
    forAll(ScheduleGen) { (_, _, _, _, humans) =>
      val valid = humans.forall(h => h.skills.nonEmpty)
      assert(valid, "Some human resources have no skills")
    }

  // Property 5: All physical resources must have valid resource types
  property("Every physical resource must have a valid resource type"):
    forAll(ScheduleGen) { (_, _, _, physicals, _) =>
      val valid = physicals.forall(pr => pr.resourceType.to.startsWith("PRST"))
      assert(valid, "Some physical resources have invalid resource types")
    }
