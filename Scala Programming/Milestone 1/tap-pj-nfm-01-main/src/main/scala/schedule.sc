import pj.domain.schedule.ScheduleMS01

import scala.xml.XML.load
import pj.xml.XMLFileWriter

//val agenda = load("C:\\Users\\andre\\Documents\\tap-pj-nfm-01\\files\\assessment\\ms01\\validAgenda_01_in.xml")
val agenda = load("C:\\Users\\marko\\OneDrive\\Documentos\\validAgenda_01_in.xml")

// Fulfilling the "This complete schedule, when available, should be persisted on disk." requirement
val result = ScheduleMS01.create(agenda) match {
  case Right(validatedAgenda) =>
    // Save the resulting XML to a file
    XMLFileWriter.saveXMLToFile(validatedAgenda)
  case Left(error) =>
    Left(error)
}