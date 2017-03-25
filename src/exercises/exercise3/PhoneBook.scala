package exercises.exercise3

import scala.collection.{Map, mutable}

case class Lecturer(id: Int, name: String)

object PhoneBook extends App {
  val lecturers = List(Lecturer(1, "Avi"), Lecturer(2, "Alina"), Lecturer(3, "David"), Lecturer(4, "John"), Lecturer(5, "Jessica"))

  def aggregateByName(lst: List[Lecturer]): Map[Char, List[String]] = ???

  println(aggregateByName(lecturers)) // Map(D -> List(David), J -> List(Jessica, John), A -> List(Alina, Avi))
}

