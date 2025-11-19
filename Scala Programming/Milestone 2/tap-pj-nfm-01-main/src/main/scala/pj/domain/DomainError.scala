package pj.domain

type Result[A] = Either[DomainError,A]

enum DomainError:
  case IOFileProblem(error: String)
  case XMLError(error: String)
  case InvalidDurationValue(error: String)
  case InvalidTaskId(error: String)
  case InvalidOrderId(error: String)
  case InvalidQuantity(error: String)
  case InvalidProductId(error: String)
  case InvalidHumanId(error: String)
  case InvalidResourceType(error: String)
  case InvalidResourceValue(error: String)
  case ImpossibleSchedule(error:String)
  case InvalidTimeOfScheduleValue(error: String)
  case MissingPhysicalResource(error: String)
  case MissingHumanResource(error: String)
  case TaskDoesNotExist(error: TaskRef)
  case ProductDoesNotExist(error: ProductId)
  case InvalidPhysicalId(value: String)
  case TaskUsesNonExistentPRT(value: String)
  case ResourceUnavailable(taskId: String, resourceType: String)
  case MissingProduct(taskId: String)
  case InvalidTaskReference(taskId: String)
  case InvalidAgenda(reason: String)
  case EmptySchedule (reason: String)

