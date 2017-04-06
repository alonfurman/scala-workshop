package solutions.exercise2

object Sorted extends App {

  def isSorted(lst: List[Int], compare: (Int, Int) => Boolean): Boolean = {
    var sorted = true
    for(i <- 0 until lst.length - 1) {
      if (!compare(lst(i), lst(i+1))) sorted = false
    }
    sorted
  }

  def isSorted2(lst: List[Int], compare: (Int, Int) => Boolean): Boolean = {
    def iter(i: Int): Boolean = {
      if (i >= lst.length - 1) true
      else compare(lst(i), lst(i + 1)) && iter(i + 1)
    }
    iter(0)
  }

  println(isSorted(List(1,2,3,4), (x,y) => x < y)) //true
  println(isSorted(List(1,2,3,4), (x,y) => x > y)) //false

  println(isSorted2(List(1,2,3,4), (x,y) => x < y)) //true
}
