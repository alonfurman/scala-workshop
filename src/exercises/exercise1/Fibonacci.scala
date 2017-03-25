package exercises.exercise1

object Fibonacci extends App {
  def fib(index: Int) = {
    var prev1 = 0
    var prev2 = 1

    for (i <- 0 until index) {
      val current = prev1 + prev2
      prev1 = prev2
      prev2 = current
    }
    prev2
  }

  def rfib(index: Int): Int = ???

  println(fib(5) == rfib(5))
}

