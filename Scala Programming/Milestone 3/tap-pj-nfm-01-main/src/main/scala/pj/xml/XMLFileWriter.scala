package pj.xml

import pj.domain.{DomainError, Result}

import java.io.{File, FileWriter, PrintWriter}
import scala.util.{Try, Using}
import scala.xml.{Elem, PrettyPrinter}

object XMLFileWriter:
// https://www.scala-lang.org/api/2.12.17/scala-xml/scala/xml/PrettyPrinter.html
  def saveXMLToFile(xml: Elem): Result[Unit] = {
    val projectDir = "/Users/diogoisep/Desktop/TAP/tap-pj-nfm-01/files/assessment/ms03"
    val relativePath = "assessment_out.xml"
    val absolutePath = projectDir + "\\" + relativePath

    val file = new File(absolutePath)

    try
      val printer = new PrettyPrinter(80, 2)
      val writer = new FileWriter(file)
      try
        writer.write(printer.format(xml))
      finally
        writer.close()
      Right(())
    catch
      case e: Exception => Left(DomainError.XMLError(e.getMessage))
  }