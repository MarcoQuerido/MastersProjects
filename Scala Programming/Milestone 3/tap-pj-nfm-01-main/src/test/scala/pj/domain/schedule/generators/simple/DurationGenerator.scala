package pj.domain.schedule.generators.simple

import org.scalacheck.Gen

import java.time.Duration

object DurationGenerator:

  val minDurationMinutes = 1
  val maxDurationMinutes = 240  // 4 hours limit for a task was defined 

  def genDuration: Gen[Duration] =
    for
      minutes <- Gen.choose(minDurationMinutes, maxDurationMinutes)
    yield Duration.ofMinutes(minutes.toLong)
