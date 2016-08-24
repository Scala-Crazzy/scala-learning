package test.problems.scala.twenty

import test.problems.scala.common.CommonUtil


object Test {

  val list = 0 until 10 toList

  def main(args: Array[String]): Unit = {

    println("Problem 11: Modified Encoded List: %s".format(ElevenToTwenty
        .encodeModified(List(1, 1, 2, 3, 3, 3, 4, 4, 5, 5, 6, 6, 6, 6, 7))))
    println("Problem 12: Decoded list: %s".format(ElevenToTwenty
        .decode(List((2, 1), (1, 2), (3, 3), (2,4), (2,5), (4,6), (1, 7)))))
    println("Problem 13: Encoded list: %s".format(ElevenToTwenty
        .encodeDirect(List(1, 1, 2, 3, 3, 3, 4, 4, 5, 5, 6, 6, 6, 6, 7))))
    println("Problem 14: Duplicated list: %s".format(ElevenToTwenty
        .duplicate(List(1, 2, 3, 4))))
    println("Problem 15: List duplicated %d times: %s".format(4, ElevenToTwenty
        .duplicateN(4, List(1, 2, 3, 4))))
    /*println("Problem 02: Element before Last Element of the list: %s".format(FirstTwenty.getBeforeLast(list).getOrElse("None")))
    println("Problem 03: K(%d)th Element of the list: %s".format(4, FirstTwenty.kth(list, 4).getOrElse("None")))
    println("Problem 04: Length of the list: %s".format(FirstTwenty.length(list)))
    println("Problem 05: Reverse of the list: %s".format(FirstTwenty.reverse(list)))
    println("Problem 06: Is the list palindrome: %s".format(FirstTwenty.isPalindrome(List(1,2,3,2,1))))
    println("Problem 07: Flatten list: %s".format(FirstTwenty.
        flatten(List(1, 2, List(3, List(10, 11, 12)), 5, List(), List(6, 7, 8), List(9)))))
    println("Problem 08: Compressed List: %s".format(FirstTwenty.
        compress(List(1, 1, 2, 3, 3, 3, 4, 4, 5, 5, 6, 6, 6, 6, 7))))
    println("Problem 09: Packed List: %s".format(FirstTwenty.
        pack(List(1, 1, 2, 3, 3, 3, 4, 4, 5, 5, 6, 6, 6, 6, 7))))
        */
  }

}