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
}