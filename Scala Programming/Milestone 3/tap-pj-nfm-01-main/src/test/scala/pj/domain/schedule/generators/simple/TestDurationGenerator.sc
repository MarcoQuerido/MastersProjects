import pj.domain.schedule.generators.simple.DurationGenerator
import java.time.Duration

val maybeDuration: Option[Duration] = DurationGenerator.genDuration.sample

val samples = List.fill(20)(DurationGenerator.genDuration.sample)
samples.foreach {
  case Some(dur) => println(s"${dur.toSeconds} seconds")
  case None      => println("Failed to generate.")
}
