package pj.domain.schedule

import org.scalatest.funsuite.AnyFunSuite
import pj.domain.*
import pj.domain.DomainError.*

class SimpleTypesParsingTest extends AnyFunSuite:

  // Physical Resource ID
  test("PhysicalResourceId.from should accept valid ID with spaces"):
    val result = PhysicalResourceId.from("  PRS_9  ")
    assert(result.canEqual(Right("PRS_9")))

  test("PhysicalResourceId.from should accept valid ID"):
    val result = PhysicalResourceId.from("PRS_9")
    assert(result.canEqual(Right("PRS_9")))

  test("PhysicalResourceId.from should reject invalid ID"):
    val result = PhysicalResourceId.from("PRC_9")
    assert(result == Left(InvalidPhysicalId("PRC_9")))

  // Order ID
  test("OrderId.from should accept valid ID with spaces"):
    val result = OrderId.from("  ORD_2  ")
    assert(result.canEqual(Right("ORD_2")))

  test("OrderId.from should accept valid ID"):
    val result = OrderId.from("ORD_2")
    assert(result.canEqual(Right("ORD_2")))

  test("OrderId.from should reject invalid ID"):
    val result = OrderId.from("ODR_2")
    assert(result == Left(InvalidOrderId("ODR_2")))

  // Product ID
  test("ProductId.from should accept valid ID with spaces"):
    val result = ProductId.from("  PRD_1  ")
    assert(result.canEqual(Right("PRD_1")))

  test("ProductId.from should accept valid ID"):
    val result = ProductId.from("PRD_1")
    assert(result.canEqual(Right("PRD_1")))

  test("ProductId.from should reject invalid ID"):
    val result = ProductId.from("PROD-001")
    assert(result == Left(InvalidProductId("PROD-001")))

  // Task ID
  test("TaskId.from should accept valid ID with spaces"):
    val result = TaskId.from("  TSK_99  ")
    assert(result.canEqual(Right("TSK_99")))

  test("TaskId.from should accept valid ID"):
    val result = TaskId.from("TSK_99")
    assert(result.canEqual(Right("TSK_99")))

  test("TaskId.from should reject invalid ID"):
    val result = TaskId.from("TASK99")
    assert(result == Left(InvalidTaskId("TASK99")))

  // Duration
  test("Duration.from should accept positive integer"):
    val result = Duration.from("15")
    assert(result.canEqual(Right(15)))

  test("Duration.from should reject non-numeric value"):
    val result = Duration.from("abc")
    assert(result == Left(InvalidDurationValue("abc")))

  test("Duration.from should reject zero or negative value"):
    assert(Duration.from("0") == Left(InvalidDurationValue("0")))
    assert(Duration.from("-5") == Left(InvalidDurationValue("-5")))

  // ResourceType
  test("ResourceType.from should accept valid type"):
    val result = ResourceType.from("PRST 1")
    assert(result.canEqual(Right("PRST 1")))

  test("ResourceType.from should reject invalid type"):
    val result = ResourceType.from("PSRT1")
    assert(result == Left(InvalidResourceType("PSRT1")))

  // Human ID
  test("HumanId.from should accept valid ID with spaces"):
    val result = HumanId.from("  HRS_123  ")
    assert(result.canEqual(Right("HRS_123")))

  test("HumanId.from should accept valid ID"):
    val result = HumanId.from("HRS_123")
    assert(result.canEqual(Right("HRS_123")))

  test("HumanId.from should reject invalid ID"):
    val result = HumanId.from("HR_123")
    assert(result == Left(InvalidHumanId("HR_123")))

  // Time of Schedule
  test("TimeOfSchedule.from should accept valid time"):
    val result = TimeOfSchedule.from("8")
    assert(result.canEqual(Right(8)))

  test("TimeOfSchedule.from should reject negative time"):
    val result = TimeOfSchedule.from("-1")
    assert(result == Left(InvalidTimeOfScheduleValue("-1")))
