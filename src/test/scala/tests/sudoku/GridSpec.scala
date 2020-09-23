package tests.sudoku


import java.security.InvalidParameterException

import org.scalatest.flatspec.AnyFlatSpec
import org.scalatest.matchers.should.Matchers

class GridSpec extends AnyFlatSpec with Matchers{

  val valid = Seq(
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
  //number outside of allowed range
  val invalidNumber = Seq(
    Seq(7,2,6,4,9,3,8,1,5),
    Seq(99,1,5,7,2,8,9,4,6),
    Seq(4,8,9,6,5,1,2,3,7),
    Seq(8,5,2,1,4,7,6,9,3),
    Seq(6,7,3,9,8,5,1,2,4),
    Seq(9,4,1,3,6,2,7,5,8),
    Seq(1,9,4,8,3,6,5,7,2),
    Seq(5,6,7,2,1,4,3,8,9),
    Seq(2,3,8,5,7,9,4,6,1)
  )
  //number is not unique: row 1 and column 8 and square (1,3)
  val nonUnique = Seq(
    Seq(7,2,6,4,9,3,8,8,5),
    Seq(3,1,5,7,2,8,9,4,6),
    Seq(4,8,9,6,5,1,2,3,7),
    Seq(8,5,2,1,4,7,6,9,3),
    Seq(6,7,3,9,8,5,1,2,4),
    Seq(9,4,1,3,6,2,7,5,8),
    Seq(1,9,4,8,3,6,5,7,2),
    Seq(5,6,7,2,1,4,3,8,9),
    Seq(2,3,8,5,7,9,4,6,1)
  )

  val invalidSquare = Seq(
    Seq(7,2,6,4,9,3,8,1,5),
    Seq(7,1,5,7,2,8,9,4,6),
    Seq(4,8,9,6,5,1,2,3,7),
    Seq(8,5,2,1,4,7,6,9,3),
    Seq(6,7,3,9,8,5,1,2,4),
    Seq(9,4,1,3,6,2,7,5,8),
    Seq(1,9,4,8,3,6,5,7,2),
    Seq(5,6,7,2,1,4,3,8,9),
    Seq(2,3,8,5,7,9,4,6,1)
  )


  "Grid method rowsCheck" should " return true" in{
    val expected = true
    val actual = Grid.rowsCheck(valid)
    actual shouldBe expected
  }
  "Grid method columnsCheck" should " return true" in{
    val expected = true
    val actual = Grid.columnsCheck(valid)
    actual shouldBe expected
  }
  "Grid method squaresCheck" should " return true" in{
    val expected = true
    val actual = Grid.squaresCheck(valid)
    actual shouldBe expected
  }
  "Grid method rowsCheck" should " detect invalid number and throw InvalidParameterException" in{
    an [InvalidParameterException] should be thrownBy Grid.rowsCheck(invalidNumber)
  }
  "Grid method columnsCheck" should " detect invalid number and throw InvalidParameterException" in{
    an [InvalidParameterException] should be thrownBy Grid.columnsCheck(invalidNumber)
  }

  "Grid method squaresCheckOptimised" should " detect invalid number and throw InvalidParameterException" in{
    an [InvalidParameterException] should be thrownBy Grid.squaresCheck(invalidNumber)
  }

  "Grid method rowsCheck" should " detect non-unique number in row and throw InvalidParameterException" in{
    an [InvalidParameterException] should be thrownBy Grid.rowsCheck(nonUnique)
  }
  "Grid method columnsCheck" should " detect non-unique number in column and throw InvalidParameterException" in{
    an [InvalidParameterException] should be thrownBy Grid.columnsCheck(nonUnique)
  }

  "Grid method squaresCheck" should " detect non-unique number in square and throw InvalidParameterException" in{
    an [InvalidParameterException] should be thrownBy Grid.squaresCheck(nonUnique)
  }

  "Grid method validate" should " return true" in{
    val expected = true
    val actual = Grid.validate(valid)
    actual shouldBe expected
  }
  "Grid method validate" should " detect invalid number in square and throw InvalidParameterException" in{
    an [InvalidParameterException] should be thrownBy Grid.validate(invalidNumber)
  }

  "Grid method validate" should " detect non-unique number in square and throw InvalidParameterException" in{
    an [InvalidParameterException] should be thrownBy Grid.validate(nonUnique)
  }

}
