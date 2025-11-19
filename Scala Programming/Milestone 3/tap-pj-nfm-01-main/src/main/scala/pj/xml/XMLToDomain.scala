package pj.xml

import pj.domain.*
import pj.xml.XML.*

import scala.util.Try
import scala.xml.Node

object XMLToDomain:

  def fromProduction(xml: Node): Result[ProductionInput] =
    for
      orders <- XML.traverse((xml \\ "Order").toList, fromOrderAttributes)
      products <- XML.traverse((xml \\ "Product").toList, fromProductAttributes)
      humans <- fromHumanResources(xml)
      physicals <- fromPhysicalResources(xml)
      availableTypes = physicals.map(_.resourceType).toSet
      tasks <- XML.traverse((xml \\ "Task").toList, fromTaskAttributes(_, availableTypes))
    yield ProductionInput(orders, products, tasks, humans, physicals)

  private def fromOrderAttributes(xml: Node): Result[Order] =
    for
      sid <- fromAttribute(xml, "id")
      orderId <- OrderId.from(sid)
      productRef <- fromAttribute(xml, "prdref")
      productId <- ProductId.from(productRef)
      quantityStr <- fromAttribute(xml, "quantity")
      quantity <- Try(quantityStr.toInt)
        .toOption
        .filter(_ > 0)
        .toRight(DomainError.InvalidQuantity(quantityStr))
    yield Order(orderId, productId, quantity)

  private def fromProductAttributes(xml: Node): Result[Product] =
    for
      sid <- fromAttribute(xml, "id")
      productId <- ProductId.from(sid)
      name <- fromAttribute(xml, "name")
      taskRefs <- XML.traverse((xml \ "Process").toList, fromProcessAttributes)
    yield Product(productId, name, taskRefs)

  private def fromProcessAttributes(xml: Node): Result[TaskRef] =
    for
      ref <- fromAttribute(xml, "tskref")
      taskRef <- TaskRef.from(ref)
    yield taskRef

  private def fromTaskAttributes(xml: Node, availableTypes: Set[ResourceType]): Result[Task] =
    for
      sid <- fromAttribute(xml, "id")
      taskId <- TaskId.from(sid)
      durationStr <- fromAttribute(xml, "time")
      duration <- Try(durationStr.toInt).toOption.toRight(DomainError.InvalidDurationValue(durationStr))

      // Extract raw type strings first
      typeStrings = (xml \ "PhysicalResource").toList.map(_ \@ "type").map(_.trim)

      // Ensure all types exist
      _ <- typeStrings
        .find(t => !availableTypes.exists(_.to == t))
        .map(missing => Left(DomainError.TaskUsesNonExistentPRT(missing)))
        .getOrElse(Right(()))

      // Parse types
      resourceRefs <- XML.traverse(typeStrings, ResourceType.from).map(_.map(pj.domain.PhysicalResourceRef.apply))
    yield Task(taskId, duration, resourceRefs)


  private def fromResourceRef(xml: Node): Result[PhysicalResourceRef] =
    for
      resTypeStr <- fromAttribute(xml, "type")
      resType <- ResourceType.from(resTypeStr)
    yield PhysicalResourceRef(resType)


  private def fromHumanResources(xml: Node): Result[List[HumanResource]] =
    XML.traverse((xml \\ "Human").toList, fromHumanResourceAttributes)

  private def fromHumanResourceAttributes(xml: Node): Result[HumanResource] =
    for
      idStr <- fromAttribute(xml, "id")
      id <- HumanId.from(idStr)
      name <- fromAttribute(xml, "name")
      skillNodes = (xml \ "Handles").toList
      skillTypes <- XML.traverse(skillNodes, skillNode =>
        fromAttribute(skillNode, "type").flatMap(ResourceType.from)
      )
    yield HumanResource(id, name, skillTypes.toSet)

  private def fromPhysicalResources(xml: Node): Result[List[PhysicalResource]] =
    XML.traverse((xml \\ "Physical").toList, fromPhysicalResourceAttributes)

  private def fromPhysicalResourceAttributes(xml: Node): Result[PhysicalResource] =
    for
      idStr <- fromAttribute(xml, "id")
      id <- PhysicalResourceId.from(idStr)
      typeStr <- fromAttribute(xml, "type")
      resType <- ResourceType.from(typeStr)
    yield PhysicalResource(id, resType)
