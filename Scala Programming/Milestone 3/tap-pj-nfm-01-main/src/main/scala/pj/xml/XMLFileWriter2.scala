package pj.xml

import pj.domain.{DomainError, Result}
import pj.io.FileIO

import java.io.File
import scala.xml.Elem

object XMLFileWriter2:

  def saveXMLToFile(xml: Elem, fileName: String): Result[Unit] =
    val validName = fileName.startsWith("validAgenda") && fileName.endsWith("_in.xml")

    if !validName then
      Right(())
    else
      val outputDir = File("files/assessment/ms03")
      val fileNameFinal = fileName.replace("in","out")
      val outputPath = File(outputDir, fileNameFinal)
      
      FileIO.save(outputPath.toString, xml)
      Right(())
