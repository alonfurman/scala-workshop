package exercises.exercise6

object GameOfLife extends App {

  type Board = Seq[Seq[Int]]

  //Your code starts here
  def tick(board: Board): Board = board



  // Your code ends here

  def draw(board: Board) = board.map(_.mkString(" | ")).mkString("\n" + ("-" * board.size).mkString("-+-") + "\n")

  // Check results
  val board1 = Seq(
    Seq(0, 1, 0),
    Seq(1, 1, 0),
    Seq(0, 0, 0)
  )

  val board2 = Seq(
    Seq(0, 1, 0, 1),
    Seq(1, 1, 1, 1),
    Seq(0, 0, 0, 1),
    Seq(0, 1, 0, 1)
  )

  val expected1 = Seq(
    Seq(1, 1, 0),
    Seq(1, 1, 0),
    Seq(0, 0, 0)
  )

  val expected2 = Seq(
    Seq(1, 1, 0, 1),
    Seq(1, 1, 0, 1),
    Seq(1, 0, 0, 1),
    Seq(0, 0, 1, 0)
  )

  val result1 = tick(board1)
  val result2 = tick(board2)

  println(
    s"""Got:
       |${draw(result1)}
       |""".stripMargin)

  println(
    s"""Expected:
       |${draw(expected1)}
       |""".stripMargin)
  println(result1 == expected1)

  println(
    s"""Got:
        |${draw(result2)}
        |""".stripMargin)

  println(
    s"""Expected:
        |${draw(expected2)}
        |""".stripMargin)
  println(result2 == expected2)

}

