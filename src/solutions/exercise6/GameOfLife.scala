package solutions.exercise6

object GameOfLife extends App {

  type Board = Seq[Seq[Int]]

  def tick(board: Board): Board =
    for (i <- board.indices)
      yield for (j <- board(i).indices)
        yield next(i, j, board)

  def next(i: Int, j: Int, board: Board): Int = next(board(i)(j), numLiveNeighbors(i, j, board))

  def next(cell: Int, numAliveNeighbors: Int): Int = (cell, numAliveNeighbors) match {
    case (c, 2) => c
    case (_, 3) => 1
    case _ => 0
  }

  def numLiveNeighbors(i: Int, j: Int, board: Board): Int =
    neighbors(i, j, board).map { case (r, c) => board(r)(c) }.sum

  def neighbors(i: Int, j: Int, board: Board): Seq[(Int, Int)] = for {
    dx <- -1 to 1
    dy <- -1 to 1
    if (dx | dy) != 0 && (board.indices contains i + dy) && (board(i).indices contains j + dx)
  } yield (i + dy, j + dx)

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

