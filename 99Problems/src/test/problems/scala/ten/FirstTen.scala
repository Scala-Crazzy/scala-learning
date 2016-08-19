package test.problems.scala.ten

import test.problems.scala.common.CommonUtil._
import scala.annotation.tailrec

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
  
  /**
   * P05 (*) Reverse a list.
   *   Example:
   *   scala> reverse(List(1, 1, 2, 3, 5, 8))
   *   res0: List[Int] = List(8, 5, 3, 2, 1, 1)
   **/
  def reverse[A](list: List[A]):List[A] = list match {
    case Nil => Nil
    case x::Nil => list
    case h::t => reverse(t):+h
  }
  
  /**
   * P06 (*) Find out whether a list is a palindrome.
   *   Example:
   *   scala> isPalindrome(List(1, 2, 3, 2, 1))
   *   res0: Boolean = true
   **/
  def isPalindrome[A](list: List[A]) = list == reverse(list)
  
  /**
   * P07 (**) Flatten a nested list structure.
   *   Example:
   *   scala> flatten(List(List(1, 1), 2, List(3, List(5, 8))))
   *   res0: List[Any] = List(1, 1, 2, 3, 5, 8)
   **/
  def flatten(list: List[Any]) : List[Any] = list match {
    case Nil => Nil
    case x :: xs => x match {
      case Nil => flatten(xs)
      case l: List[_] => flatten(l) ++ flatten(xs)
      case _ => x :: flatten(xs)
    }
  }
  
  /**
	 * P08 (**) Eliminate consecutive duplicates of list elements.
   *   If a list contains repeated elements they should be replaced with a single copy of the element. The order of the elements should not be changed.
   *   Example:
   *   scala> compress(List('a, 'a, 'a, 'a, 'b, 'c, 'c, 'a, 'a, 'd, 'e, 'e, 'e, 'e))
   *   res0: List[Symbol] = List('a, 'b, 'c, 'a, 'd, 'e)
   **/
  def compress[A](list: List[A]): List[A] = list match {
    case Nil => Nil
    case x :: xs => x :: compress(dropWhile(xs, (y: A) => x == y))
  }
  
  /**
	 * P09 (**) Pack consecutive duplicates of list elements into sublists.
   *   If a list contains repeated elements they should be placed in separate sublists.
   *   Example:
   *   scala> pack(List('a, 'a, 'a, 'a, 'b, 'c, 'c, 'a, 'a, 'd, 'e, 'e, 'e, 'e))
   *   res0: List[List[Symbol]] = List(List('a, 'a, 'a, 'a), List('b), List('c, 'c), List('a, 'a), List('d), List('e, 'e, 'e, 'e))
	 **/
  def pack[A](list: List[A]):List[List[A]] = list match {
    case Nil => Nil
    //case h::t => (h::takeWhile(t, (p:A) => h == p))::pack(dropWhile(t, (p:A) => h == p))  
    case h::t => 
      {
        val lists = span(t, (p:A) => h == p)
        (h :: lists._1) :: pack(lists._2)
      }
  }
  
  
  /**
	 * P10 (*) Run-length encoding of a list.
   *   Use the result of problem P09 to implement the so-called run-length encoding data compression method. 
   *   Consecutive duplicates of elements are encoded as tuples (N, E) where N is the number of duplicates 
   *   of the element E.
   *   Example:
   *   scala> encode(List('a, 'a, 'a, 'a, 'b, 'c, 'c, 'a, 'a, 'd, 'e, 'e, 'e, 'e))
   *   res0: List[(Int, Symbol)] = List((4,'a), (1,'b), (2,'c), (2,'a), (1,'d), (4,'e))
   */
  def encode[A](list:List[A]):List[(Int, A)] = {
    def convert(packedList: List[List[A]]):List[(Int, A)] = packedList match {
      case Nil => Nil
      case h::t => (length(h), h.head) :: convert(t)
    }
    
    convert(pack(list))
  }
  
  
}