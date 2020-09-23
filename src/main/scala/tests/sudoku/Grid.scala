package tests.sudoku

import java.security.InvalidParameterException

import scala.annotation.tailrec
import scala.util.Try

/**
 * RULES OF SUDOKU:
 * Sudoku Rule № 1: Each of the 9 3x3 sub-boxes of the grid must contain the digits 1-9 without repetition
 * Sudoku Rule № 2: Each row must contain the digits 1-9 without repetition
 * Sudoku Rule № 3: Each column must contain the digits 1-9 without repetition
 * Sudoku Rule № 4: Each square must contain a number
 * */
object Grid {

  def validate(rows:Seq[Seq[Int]]) = {
    rowsCheck(rows)
    columnsCheck(rows)
    squaresCheck(rows)
  }

  @tailrec
  final def rowsCheck(r:Seq[Seq[Int]]):Boolean =
    if (r.isEmpty) true
    else if(r.head.sortBy(identity) == (1 to 9)) rowsCheck(r.tail)
    else throw new InvalidParameterException("row integrity check failed")


  def columnsCheck(r:Seq[Seq[Int]]):Boolean = Try{
    rowsCheck(r.transpose)
  } getOrElse(throw new InvalidParameterException("column integrity check failed"))


  //https://mathoverflow.net/questions/129143/verifying-the-correctness-of-a-sudoku-solution

  def squaresCheck(rows: Seq[Seq[Int]]):Boolean = {
    val isValid = !rows.map(_.sliding(3,3).toSeq).sliding(3,3).toSeq.map(_.transpose.map(_.flatten)).flatten.exists(_.sorted!=(1 to 9))
    if(isValid) true
    else throw new InvalidParameterException("square integrity check failed")
  }


}

