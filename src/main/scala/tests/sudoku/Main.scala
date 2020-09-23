package tests.sudoku

import java.security.InvalidParameterException

import scala.io.Source
import scala.util.{Failure, Success, Try}

object Main {

  def validateInput(lines: Seq[String]) = {
    Try{
      if(lines.length==9 && !lines.exists(_.length==9)) lines.map(_.split(",").map(_.toInt).toSeq)
      else throw new InvalidParameterException("Invalid input")
    }} match{
    case Failure(e) => throw e
    case Success(rows) => rows
  }

  def main(args: Array[String]): Unit = {
    val path = args(0)
    val lines: Seq[String] = Source.fromFile(path).getLines.toList
    Try{Grid.validate( validateInput(lines) )} match{
      case Failure(e) => {
        println("INVALID")
        println(e.getStackTrace()(0).getClassName+": "+e.getMessage())
        println(e.getMessage())
      }
      case Success(_) =>  println("VALID")
    }}
}
