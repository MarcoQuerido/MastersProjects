import pj.domain.schedule.ScheduleMS03

import scala.xml.XML.load
import pj.xml.XMLFileWriter

val agenda = load("Users/diogoisep/Desktop/TAP/tap-pj-nfm-01/files/assessment/ms03")

// Fulfilling the "This complete schedule, when available, should be persisted on disk." requirement
val result = ScheduleMS03.create(agenda) match {
  case Right(validatedAgenda) =>
    // Save the resulting XML to a file
    XMLFileWriter.saveXMLToFile(validatedAgenda)
  case Left(error) =>
    Left(error)
}