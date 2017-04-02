package exercises.exercise7

object TicTacToe extends App {

  sealed trait Move

  case object O extends Move

  case object X extends Move

  case class Position(x: Int, y: Int)

  type Board = Seq[Seq[Option[Move]]]

  //Your code here

}