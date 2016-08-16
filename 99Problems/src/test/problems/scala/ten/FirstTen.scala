package test.problems.scala.ten

object FirstTen {
  
   /**
   * P01 (*) Find the last element of a list.
	 * Example:
	 * scala> last(List(1, 1, 2, 3, 5, 8))
	 * res0: Int = 8
   */
  def last[A](list: List[A]): Option[A] = list match {
    case Nil => None
    case x :: Nil => Some(x)
    case _ :: xs => last(xs)
  }
  
  /**
   * P02 (*) Find the last but one element of a list.
   *   Example:
   *   scala> penultimate(List(1, 1, 2, 3, 5, 8))
   *   res0: Int = 5
   */
  def getBeforeLast[A](l : List[A]) : Option[A] = l match {
    case Nil => None
    case x::Nil => None
    case x::y::Nil => Some(x)
    case _::t => getBeforeLast(t)
  }
  
  /**
   * P03 (*) Find the Kth element of a list.
   **   By convention, the first element in the list is element 0.
   *   Example:
   *   
   *   scala> nth(2, List(1, 1, 2, 3, 5, 8))
   *   res0: Int = 2
   **/
  def kth[A](list : List[A], k : Int) : Option[A] = list match {
    case Nil => None
    case h::t => 
      if (k < 0 ) throw new Exception("Invalid index") 
      else if (k == 0) Some(h) 
      else kth(t, k - 1)
  }
  
  /**
   * P04 (*) Find the number of elements of a list.
   *   Example:
   *   scala> length(List(1, 1, 2, 3, 5, 8))
   *   res0: Int = 6
   **/
  def length[A](list: List[A]): Int = {
    def lengthAux(list : List[A], count : Int) : Int = list match {
      case Nil => count
      case _:: t => lengthAux(t, count + 1)
    }
    
    lengthAux(list, 0)
  }
  
}