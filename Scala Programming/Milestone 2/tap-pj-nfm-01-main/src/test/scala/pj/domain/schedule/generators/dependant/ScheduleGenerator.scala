package pj.domain.schedule.generators.dependant

import org.scalacheck.Gen
import pj.domain.*
import pj.domain.schedule.generators.dependant.TaskGenerator
import pj.domain.schedule.generators.complex.{HumanResourceGenerator, PhysicalResourceGenerator, ProductGenerator}
import pj.domain.schedule.generators.dependant.{OrderGenerator, TaskGenerator}

object ScheduleGenerator:

  def genOrders(n: Int): Gen[List[Order]] =
    Gen.listOfN(n, OrderGenerator.genOrder)

  def genProducts(n: Int): Gen[List[Product]] =
    Gen.listOfN(n, ProductGenerator.genProduct)

  def genTasks(n: Int): Gen[List[Task]] =
    Gen.listOfN(n, TaskGenerator.genTask)

  def genPhysicalResources(n: Int): Gen[List[PhysicalResource]] =
    Gen.listOfN(n, PhysicalResourceGenerator.genPhysicalResource)

  def genHumanResources(n: Int): Gen[List[HumanResource]] =
    Gen.listOfN(n, HumanResourceGenerator.genHumanResource)

  def genSchedule(
                   numOrders: Int,
                   numProducts: Int,
                   numTasks: Int,
                   numPhysicals: Int,
                   numHumans: Int
                 ): Gen[(List[Order], List[Product], List[Task], List[PhysicalResource], List[HumanResource])] =
    for
      orders    <- genOrders(numOrders)
      products  <- genProducts(numProducts)
      tasks     <- genTasks(numTasks)
      physicals <- genPhysicalResources(numPhysicals)
      humans    <- genHumanResources(numHumans)
    yield (orders, products, tasks, physicals, humans)

  // Default generator exposed as a value
  val scheduleGen: Gen[(List[Order], List[Product], List[Task], List[PhysicalResource], List[HumanResource])] =
    genSchedule(numOrders = 3, numProducts = 2, numTasks = 4, numPhysicals = 5, numHumans = 5)