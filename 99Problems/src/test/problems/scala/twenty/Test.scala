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
    println("Problem 16: List with skipped kth(%d) Value: %s".format(3, ElevenToTwenty.drop(3, list)))
  }

}