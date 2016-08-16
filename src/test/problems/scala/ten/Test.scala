package test.problems.scala.ten

object Test {
  
  val list = 0 until 10 toList
  
  def main(args: Array[String]): Unit = {
    println("Test List: %s".format(list))
    println("Problem 01: Last Element of the list: %s".format(FirstTen.last(list)))
  }
  
}