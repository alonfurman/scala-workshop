package solutions.exercise3

import scala.collection.{Map, mutable}

case class Lecturer(id: Int, name: String)

object PhoneBook extends App {
  val lecturers = List(Lecturer(1, "Avi"), Lecturer(2, "Alina"), Lecturer(3, "David"), Lecturer(4, "John"), Lecturer(5, "Jessica"))

  def aggregateByName(lst: List[Lecturer]): Map[Char, List[String]] = {
    val lecturersNames = lecturers.map(_.name)
    lecturersNames.sorted.groupBy(_.head)
  }






  def aggregateByName2(lst: List[Lecturer]): Map[Char, List[String]] = {
    val lecturersNames = lecturers.map(_.name)
    val map: mutable.Map[Char, List[String]] = scala.collection.mutable.HashMap.empty[Char, List[String]].withDefaultValue(List.empty[String])
    lecturersNames.foreach(name => map += (name.head -> (map(name.head) ::: List(name))))
    map.mapValues(_.sorted)
  }




  println(aggregateByName(lecturers)) // Map(D -> List(David), J -> List(Jessica, John), A -> List(Alina, Avi))
  println(aggregateByName2(lecturers)) // Map(D -> List(David), J -> List(Jessica, John), A -> List(Alina, Avi))
}

