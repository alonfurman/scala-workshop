package exercises.exercise5

case class Department(courses: List[Course])

case class Course(participants: List[Student])

case class Student(id: Int = scala.util.Random.nextInt(), name: String, age: Option[Int])

object StudentList extends App {

  def studentAgesList(dept: Department): List[Int] = ???

  val department = Department(List(Course(List(Student(name = "Moshe", age = Some(20)),
                                               Student(name = "Dani", age = None),
                                               Student(name = "Tali", age = Some(22))))))
  println(studentAgesList(department))  //List(20, 22)
}
