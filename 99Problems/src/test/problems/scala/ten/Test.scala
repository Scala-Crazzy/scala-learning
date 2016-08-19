package test.problems.scala.ten

object Test {
  
  val list = 0 until 10 toList
  
  def main(args: Array[String]): Unit = {
    println("Test List: %s".format(list))
    println("Problem 01: Last Element of the list: %s".format(FirstTen.last(list).getOrElse("None")))
    println("Problem 02: Element before Last Element of the list: %s".format(FirstTen.getBeforeLast(list).getOrElse("None")))
    println("Problem 03: K(%d)th Element of the list: %s".format(4, FirstTen.kth(list, 4).getOrElse("None")))
    println("Problem 04: Length of the list: %s".format(FirstTen.length(list)))
    println("Problem 05: Reverse of the list: %s".format(FirstTen.reverse(list)))
    println("Problem 06: Is the list palindrome: %s".format(FirstTen.isPalindrome(List(1,2,3,2,1))))
    println("Problem 07: Flatten list: %s".format(FirstTen.
        flatten(List(1, 2, List(3, List(10, 11, 12)), 5, List(), List(6, 7, 8), List(9)))))
    println("Problem 08: Compressed List: %s".format(FirstTen.
        compress(List(1, 1, 2, 3, 3, 3, 4, 4, 5, 5, 6, 6, 6, 6, 7))))
    println("Problem 09: Packed List: %s".format(FirstTen.
        pack(List(1, 1, 2, 3, 3, 3, 4, 4, 5, 5, 6, 6, 6, 6, 7))))
    println("Problem 10: Encoded List: %s".format(FirstTen.
        encode(List(1, 1, 2, 3, 3, 3, 4, 4, 5, 5, 6, 6, 6, 6, 7))))    
  }
  
  
}