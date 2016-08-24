package test.problems.scala.common

import scala.annotation.tailrec

object CommonUtil {
  
  /**
   * 
   */
  @tailrec
  def dropWhile[A](list: List[A], f: A => Boolean): List[A] = if (list.isEmpty || !f(list.head)) list else dropWhile(list.tail, f)
  
  /**
   * 
   */
  def takeWhile[A](list: List[A], f: A => Boolean): List[A] = if (!list.isEmpty && f(list.head)) list.head :: takeWhile(list.tail, f) else Nil 
  
  /**
   * 
   */
  def span[A](list : List[A], f:A=>Boolean):(List[A], List[A]) = {
    def spanAux(list: List[A], listPve: List[A]): (List[A], List[A]) = 
      if (list.isEmpty) (Nil, Nil) 
      else if (f(list.head)) spanAux(list.tail, list.head::listPve)
      else (listPve, list)
      
    spanAux(list, Nil)
  }
  
  /**
   * Determines the length of a list
   */
  def length[A](list: List[A]): Int = {
    def lengthAux(list : List[A], count : Int) : Int = list match {
      case Nil => count
      case _:: t => lengthAux(t, count + 1)
    }
    
    lengthAux(list, 0)
  }
  
  /**
   * Repeats an element count number of times
   */
  def repeat[A](element:A, count:Int):List[A] = {
    @tailrec
    def repeatAux(eleList:List[A], cnt: Int): List[A] =
      if (cnt <= 0) eleList else repeatAux(element::eleList, cnt - 1);
    
    repeatAux(Nil, count)
  }
}