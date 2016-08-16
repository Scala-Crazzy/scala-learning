package test.problems.scala.ten

object Test {
  
  val list = 0 until 10 toList
  
  def main(args: Array[String]): Unit = {
    println("Test List: %s".format(list))
    println("Problem 01: Last Element of the list: %s".format(FirstTen.last(list).getOrElse("None")))
    println("Problem 02: Element before Last Element of the list: %s".format(FirstTen.getBeforeLast(list).getOrElse("None")))
    println("Problem 03: K(%d)th Element of the list: %s".format(4, FirstTen.kth(list, 4).getOrElse("None")))
    println("Problem 04: Length of the list: %s".format(FirstTen.length(list)))
  }
  
  
}