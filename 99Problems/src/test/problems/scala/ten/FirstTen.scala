package test.problems.scala.ten

object FirstTen {
  
  //Find the last element of a list.
  def last[A](list: List[A]): Option[A] = list match {
    case Nil => None
    case x :: Nil => Some(x)
    case _ :: xs => last(xs)
  }
  
}