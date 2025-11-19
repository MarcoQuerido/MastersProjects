import pj.domain.schedule.generators.dependant.ScheduleGenerator

val scheduleSample = ScheduleGenerator.genSchedule(3, 2, 5, 4, 3).sample

scheduleSample match
  case Some((orders, products, tasks, physicals, humans)) =>
    println(s"Orders: ${orders.size}, Products: ${products.size}, Tasks: ${tasks.size}")
    println(s"Physical Resources: ${physicals.size}, Humans: ${humans.size}")
  case None =>
    println("Failed to generate schedule.")
