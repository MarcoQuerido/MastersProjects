package pj.xml

import pj.domain.*
import pj.domain.DomainError.*
import scala.xml.Elem

object DomainToXML:

  def generateOutputXML(schedule: List[TaskSchedule], humanIdToName: Map[String, String]): Result[Elem] =
    Right(scheduleListToXML(schedule, humanIdToName))

  private def generateErrorXML(error: DomainError): Elem =
      <error xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
             xsi:noNamespaceSchemaLocation="../../scheduleError.xsd"
             message={error.toString}/>

  private def generateErrorXML2(error: ImpossibleSchedule): Elem =
      <error xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
             xsi:noNamespaceSchemaLocation="../../scheduleError.xsd"
             message={error.getClass.getSimpleName}/>

  private def scheduleListToXML(schedules: List[TaskSchedule], humanIdToName: Map[String, String]): Elem =
    <Schedule xmlns="http://www.dei.isep.ipp.pt/tap-2025"
              xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
              xsi:schemaLocation="http://www.dei.isep.ipp.pt/tap-2025 ../../schedule.xsd ">
      { schedules
      .sortBy(ts => (ts.orderId.toString, ts.startTime))
      .map(ts => scheduleToTaskScheduleXML(ts, humanIdToName))
      }
    </Schedule>

  private def scheduleToTaskScheduleXML(ts: TaskSchedule, humanIdToName: Map[String, String]): Elem =
    <TaskSchedule order={ts.orderId.toString}
                  productNumber={ts.productNumber.toString}
                  task={ts.taskId.toString}
                  start={ts.startTime.toString}
                  end={ts.endTime.toString}>
      <PhysicalResources>
        {ts.allocatedPhysicalResources.map(id => <Physical id={id.to}/>)}
      </PhysicalResources>
      <HumanResources>
        {ts.allocatedHumanResources.map(id =>
          <Human name={humanIdToName.getOrElse(id.to, id.to)}/>)}
      </HumanResources>
    </TaskSchedule>

