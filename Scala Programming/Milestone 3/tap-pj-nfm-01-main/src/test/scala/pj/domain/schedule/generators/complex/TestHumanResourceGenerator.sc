import org.scalacheck.Gen
import pj.domain.HumanResource
import pj.domain.schedule.generators.complex.HumanResourceGenerator

val samples: List[Option[HumanResource]] =
  List.fill(5)(HumanResourceGenerator.genHumanResource.sample)

samples.zipWithIndex.foreach {
  case (Some(h), i) =>
    println(s"[$i] ${h.id}, ${h.name}, skills: ${h.skills.mkString(", ")}")
  case (None, i) =>
    println(s"[$i] Failed to generate")
}
