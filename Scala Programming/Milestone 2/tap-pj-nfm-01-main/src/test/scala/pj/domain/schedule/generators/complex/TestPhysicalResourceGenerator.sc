import org.scalacheck.Gen
import pj.domain.schedule.generators.complex.PhysicalResourceGenerator.genPhysicalResource
import pj.domain.PhysicalResource

val resourceSamples: List[Option[PhysicalResource]] =
  List.fill(5)(genPhysicalResource.sample)

resourceSamples.zipWithIndex.foreach {
  case (Some(resource), i) =>
    println(s"[$i] Resource ID: ${resource.resourceId}, Type: ${resource.resourceType}")
  case (None, i) =>
    println(s"[$i] Failed to generate PhysicalResource")
}
