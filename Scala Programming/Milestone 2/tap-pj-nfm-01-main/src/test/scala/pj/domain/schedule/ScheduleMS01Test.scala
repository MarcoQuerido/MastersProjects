package pj.domain.schedule

import scala.language.adhocExtensions
import org.scalatest.funsuite.AnyFunSuite
import pj.domain.schedule.ScheduleMS01
import pj.domain.*

import scala.xml.XML

// TODO: Create the code to test a functional domain model for schedule creation.
//       create files in the files/test/ms01 folder
class ScheduleMS01Test extends AnyFunSuite:

  test("valid input should return scheduled XML - basic validation"):
    val xml = XML.loadFile("files/test/ms01/valid_in.xml")
    val result = ScheduleMS01.create(xml)
    assert(result.isRight)

  test("missing physical resource should return error"):
    val xml = XML.loadFile("files/test/ms01/missingPhysicalResource_in.xml")
    val result = ScheduleMS01.create(xml)
    assert(result.isLeft)
    assert(result == Left(DomainError.TaskUsesNonExistentPRT("PRST 2")))

  test("missing human resource should return error"):
    val xml = XML.loadFile("files/test/ms01/missingHumanResource_in.xml")
    val result = ScheduleMS01.create(xml)
    assert(result.isLeft)
    assert(result == Left(DomainError.XMLError("Attribute id is empty/undefined in Human")))

  test("invalid quantity should return an error"):
    val xml = XML.loadFile("files/test/ms01/invalidQuantity_in.xml")
    val result = ScheduleMS01.create(xml)
    assert(result.isLeft)

  test("invalid order ID should return an error"):
    val xml = XML.loadFile("files/test/ms01/invalidOrderId_in.xml")
    val result = ScheduleMS01.create(xml)
    assert(result.isLeft)

  test("invalid product ID should return an error"):
    val xml = XML.loadFile("files/test/ms01/invalidProductId_in.xml")
    val result = ScheduleMS01.create(xml)
    assert(result.isLeft)

  test("missing resources should return an error"):
    val xml = XML.loadFile("files/test/ms01/missingResources_in.xml")
    val result = ScheduleMS01.create(xml)
    assert(result.isLeft)

  test("empty XML schedule should return an error"):
    val emptyXml = <Production xmlns="http://www.dei.isep.ipp.pt/tap-2025" xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance" xsi:schemaLocation="http://www.dei.isep.ipp.pt/tap-2025 ../../production.xsd "></Production>
    val result = ScheduleMS01.create(emptyXml)
    assert(result.isLeft)

  test("invalid duration should return an error"):
    val xml = XML.loadFile("files/test/ms01/invalidDuration_in.xml")
    val result = ScheduleMS01.create(xml)
    assert(result.isLeft)

  test("missing task should return error"):
    val xml = XML.loadFile("files/test/ms01/missingTask_in.xml")
    val result = ScheduleMS01.create(xml)
    assert(result.isLeft)
    assert(result == Left(DomainError.XMLError("Attribute id is empty/undefined in Task")))

  test("missing taskref should return error"):
    val xml = XML.loadFile("files/test/ms01/missingTaskRef_in.xml")
    val result = ScheduleMS01.create(xml)
    assert(result.isLeft)
    assert(result == Left(DomainError.XMLError("Attribute tskref is empty/undefined in Process")))

  test("missing order should return error"):
    val xml = XML.loadFile("files/test/ms01/missingOrder_in.xml")
    val result = ScheduleMS01.create(xml)
    assert(result.isLeft)
    assert(result == Left(DomainError.XMLError("Attribute id is empty/undefined in Order")))

  test("missing prdref should return error"):
    val xml = XML.loadFile("files/test/ms01/missingPrdRef_in.xml")
    val result = ScheduleMS01.create(xml)
    assert(result.isLeft)
    assert(result == Left(DomainError.XMLError("Attribute prdref is empty/undefined in Order")))