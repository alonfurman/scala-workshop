package solutions.exercise4

sealed trait Expression

case class Const(value: Int) extends Expression
case class Sum(exp1: Expression, expr2: Expression) extends Expression
case class MyClass(a: Int) extends Expression

object Evaluator extends App {

  def evaluate(expr: Expression): Int = expr match {
    case Const(v) => v
    case Sum(l, r) => evaluate(l) + evaluate(r)
    case _ => 0
  }

  val expr: Expression = Sum(Const(5), Sum(Const(1), Sum(Const(3), Const(2))))
  println(evaluate(expr)) // 11
}