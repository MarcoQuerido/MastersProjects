package pj.domain

import scala.util.Try
import pj.domain.DomainError.*

import scala.annotation.targetName

// Duration
opaque type Duration = Int

object Duration:
  def from(value: String): Result[Duration] =
    Try(value.toInt).toOption match
      case Some(d) if d > 0 => Right(d)
      case _ => Left(InvalidDurationValue(value))

  extension (value: Duration)
    @targetName("DurationTo")
    def to: Int = value

// TaskId
opaque type TaskId = String

object TaskId:
  def from(value: String): Result[TaskId] =
    val trimmed = value.trim
    if trimmed.matches("TSK_[0-9]+") then Right(trimmed)
      else Left(InvalidTaskId(trimmed))

  extension (value: TaskId)
    @targetName("TaskIdTo")
    def to: String = value

// TaskRef — reference to an existing task
opaque type TaskRef = String

object TaskRef:
  def from(value: String): Result[TaskRef] =
    val trimmed = value.trim
    if trimmed.matches("TSK_[0-9]+") then Right(trimmed)
      else Left(InvalidTaskId(trimmed))

  extension (value: TaskRef)
    @targetName("TaskRefTo")
    def to: String = value


// OrderId
opaque type OrderId = String

object OrderId:
  def from(value: String): Result[OrderId] =
    val trimmed = value.trim
    if trimmed.matches("ORD_[0-9]+") then Right(trimmed)
    else Left(InvalidOrderId(trimmed))

  extension (value: OrderId)
    @targetName("OrderIdTo")
    def to: String = value

// ProductId
opaque type ProductId = String

object ProductId:
  def from(value: String): Result[ProductId] =
    val trimmed = value.trim
    if trimmed.matches("PRD_[0-9]+") then Right(trimmed)
      else Left(InvalidProductId(trimmed))

  extension (value: ProductId)
    @targetName("ProductIdTo")
    def to: String = value

// HumanId
opaque type HumanId = String

object HumanId:
  def from(value: String): Result[HumanId] =
    val trimmed = value.trim
    if trimmed.matches("HRS_[0-9]+") then Right(trimmed)
      else Left(InvalidHumanId(trimmed))

  extension (value: HumanId)
    @targetName("HumanIdTo")
    def to: String = value

// Physical Resource Type
opaque type ResourceType = String

object ResourceType:
  def from(value: String): Result[ResourceType] =
    if value.matches("PRST ?[0-9]+") then Right(value)
    else Left(InvalidResourceType(value))

  extension (value: ResourceType)
    @targetName("ResourceTypeTo")
    def to: String = value

// Physical Resource ID
opaque type PhysicalResourceId = String

object PhysicalResourceId:
  def from(value: String): Result[PhysicalResourceId] =
    val trimmed = value.trim
    if trimmed.matches("PRS_[0-9]+") then Right(trimmed)
    else Left(InvalidPhysicalId(trimmed))


  extension (value: PhysicalResourceId)
    @targetName("PhysicalResourceIdTo")
    def to: String = value

// Time of Schedule
opaque type TimeOfSchedule = Int

object TimeOfSchedule:
  def from(value: String): Result[TimeOfSchedule] =
    Try(value.toInt).toOption match
      case Some(t) if t >= 0 => Right(t)
      case _ => Left(InvalidTimeOfScheduleValue(value))

  extension (value: TimeOfSchedule)
    @targetName("TimeOfScheduleTo")
    def to: Int = value

// Quantity
opaque type Quantity = Int

object Quantity:
  def from(value: String): Result[Quantity] =
    Try(value.toInt).toOption match
      case Some(d) if d > 0 => Right(d)
      case _ => Left(InvalidQuantity(value))

  extension (value: Quantity)
    @targetName("QuantityTo")
    def to: Int = value