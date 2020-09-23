package tests.sudoku


import java.security.InvalidParameterException

import org.scalatest.flatspec.AnyFlatSpec
import org.scalatest.matchers.should.Matchers

class ValidateInputSpec  extends AnyFlatSpec with Matchers{

  val validInput = Seq(
    "7,2,6,4,9,3,8,1,5",
    "3,1,5,7,2,8,9,4,6",
    "4,8,9,6,5,1,2,3,7",
    "8,5,2,1,4,7,6,9,3",
    "6,7,3,9,8,5,1,2,4",
    "9,4,1,3,6,2,7,5,8",
    "1,9,4,8,3,6,5,7,2",
    "5,6,7,2,1,4,3,8,9",
    "2,3,8,5,7,9,4,6,1"
  )
  val invalidInputLessRows = Seq( //8 rows
    "7,2,6,4,9,3,8,1,5",
    "3,1,5,7,2,8,9,4,6",
    "4,8,9,6,5,1,2,3,7",
    "8,5,2,1,4,7,6,9,3",
    "6,7,3,9,8,5,1,2,4",
    "9,4,1,3,6,2,7,5,8",
    "1,9,4,8,3,6,5,7,2",
    "5,6,7,2,1,4,3,8,9"
  )
  val invalidCharInput = Seq(
    "7,2,6,4,9,3,8,1,A",
    "3,1,5,7,2,8,9,4,6",
    "4,8,9,6,5,1,2,3,7",
    "8,5,2,1,4,7,6,9,3",
    "6,7,3,9,8,5,1,2,4",
    "9,4,1,3,6,2,7,5,8",
    "1,9,4,8,3,6,5,7,2",
    "5,6,7,2,1,4,3,8,9",
    "2,3,8,5,7,9,4,6,1"
  )


  val validParsed = Seq(
    Seq(7,2,6,4,9,3,8,1,5),
    Seq(3,1,5,7,2,8,9,4,6),
    Seq(4,8,9,6,5,1,2,3,7),
    Seq(8,5,2,1,4,7,6,9,3),
    Seq(6,7,3,9,8,5,1,2,4),
    Seq(9,4,1,3,6,2,7,5,8),
    Seq(1,9,4,8,3,6,5,7,2),
    Seq(5,6,7,2,1,4,3,8,9),
    Seq(2,3,8,5,7,9,4,6,1)
  )

  "Main.validateInput" should " return true" in{
    val expected = validParsed
    val actual = Main.validateInput(validInput)
    actual shouldBe expected
  }

  "Main.validateInput" should " throw InvalidParameterException when input is of unexpected dimensions" in{
    an [InvalidParameterException] should be thrownBy Main.validateInput(invalidInputLessRows)
  }

  "Main.validateInput" should " throw InvalidParameterException when invalid character found in input" in{
    an [java.lang.NumberFormatException] should be thrownBy Main.validateInput(invalidCharInput)
  }


}
