package test.problems.scala.twenty

import test.problems.scala.common.CommonUtil._
import test.problems.scala.ten.FirstTen.encode
import scala.annotation.tailrec
import test.problems.scala.ten.FirstTen

object ElevenToTwenty {
  
  /**
   * P11 (*) Modified run-length encoding.
   * Modify the result of problem P10 in such a way that if an element has no duplicates it is 
   * simply copied into the result list. Only elements with duplicates are transferred as (N, E) terms.
   * Example:
   *
   * scala> encodeModified(List('a, 'a, 'a, 'a, 'b, 'c, 'c, 'a, 'a, 'd, 'e, 'e, 'e, 'e))
   * res0: List[Any] = List((4,'a), 'b, (2,'c), (2,'a), 'd, (4,'e))
   */
  def encodeModified[A](list:List[A]):List[Any] = {
    
    def encodeMAux(encList:List[(Int, A)]):List[Any] = encList match {
      case Nil => Nil
      case h::t => {
        (h match {
          case (1, x) => x
          case _ => h
        }) :: encodeMAux(t)
      }
    }
    encodeMAux(encode(list))
  }
  
  
  /**
   * P12 (**) Decode a run-length encoded list.
   *	Given a run-length code list generated as specified in problem P10, construct its uncompressed version.
   * Example:
   * 
   * scala> decode(List((4, 'a), (1, 'b), (2, 'c), (2, 'a), (1, 'd), (4, 'e)))
   * res0: List[Symbol] = List('a, 'a, 'a, 'a, 'b, 'c, 'c, 'a, 'a, 'd, 'e, 'e, 'e, 'e) 
   */
  def decode[A](list: List[(Int, A)]): List[A] = list match {
    case Nil => Nil
    case (1, x)::t => x :: decode(t)
    case (c, x)::t => repeat(x, c) ++ decode(t)
  }
  
  /**
   * P13 (**) Run-length encoding of a list (direct solution).
   * Implement the so-called run-length encoding data compression method directly. 
   * I.e. don't use other methods you've written (like P09's pack); do all the work directly.
   * Example:
   * 
   * scala> encodeDirect(List('a, 'a, 'a, 'a, 'b, 'c, 'c, 'a, 'a, 'd, 'e, 'e, 'e, 'e))
   * res0: List[(Int, Symbol)] = List((4,'a), (1,'b), (2,'c), (2,'a), (1,'d), (4,'e))
   */
  def encodeDirect[A](list: List[A]): List[(Int, A)] = {
    
    def encodeDirectAux(flatList: List[A], value:A, count:Int): List[(Int, A)] =
      flatList match {
        case Nil => 
            (count, value)::Nil
        case h::t => 
          if (h == value)
            encodeDirectAux(t, h, count + 1)
          else 
            (count, value)::encodeDirectAux(t, h, 1)
      }
    
    if (list == Nil)
      Nil
      
    //encodeDirectAux(list, list.head, 0) // Avoided one iteration - matching head with the head himself for first time
    encodeDirectAux(list.tail, list.head, 1)
  }

  /**
   * P14 (*) Duplicate the elements of a list.
   *   Example:
   *   scala> duplicate(List('a, 'b, 'c, 'c, 'd))
   *   res0: List[Symbol] = List('a, 'a, 'b, 'b, 'c, 'c, 'c, 'c, 'd, 'd)
   */
  def duplicate[A](list: List[A]):List[A] = list match {
    case Nil => Nil
    case h::t => h::h::duplicate(t)
  }
   
 /**
  * P15 (**) Duplicate the elements of a list a given number of times.
  *  Example:
  *  scala> duplicateN(3, List('a, 'b, 'c, 'c, 'd))
  *  res0: List[Symbol] = List('a, 'a, 'a, 'b, 'b, 'b, 'c, 'c, 'c, 'c, 'c, 'c, 'd, 'd, 'd)
  **/
  def duplicateN[A](count: Int, list: List[A]):List[A] = list match {
    case Nil => Nil
    case h::t => repeat(h, count)++duplicateN(count, t)
  }

  /**
   * P16 (**) Drop every Nth element from a list.
   *   Example:
   *   scala> drop(3, List('a, 'b, 'c, 'd, 'e, 'f, 'g, 'h, 'i, 'j, 'k))
   *   res0: List[Symbol] = List('a, 'b, 'd, 'e, 'g, 'h, 'j, 'k)
   **/
  def drop[A](c: Int, list: List[A]): List[A] = {
    @tailrec
    def aux(list: List[A], res: List[A], acc: Int): List[A] = list match {
      case Nil => res
      case x :: xs => if (acc % c == 0) aux(xs, res, acc + 1) else aux(xs, x :: res, acc + 1)
    }
    
    FirstTen.reverse(aux(list, Nil, 1))
  }

  /**
   * P17 (*) Split a list into two parts.
   *   The length of the first part is given. Use a Tuple for your result.
   *   Example:
   *   
   *   scala> split(3, List('a, 'b, 'c, 'd, 'e, 'f, 'g, 'h, 'i, 'j, 'k))
   *   res0: (List[Symbol], List[Symbol]) = (List('a, 'b, 'c),List('d, 'e, 'f, 'g, 'h, 'i, 'j, 'k))
   */

  /**
   * P18 (**) Extract a slice from a list.
   *   Given two indices, I and K, the slice is the list containing the elements from and including the Ith element up to but not including the Kth element of the original list. Start counting the elements with 0.
   *   Example:
   *   
   *   scala> slice(3, 7, List('a, 'b, 'c, 'd, 'e, 'f, 'g, 'h, 'i, 'j, 'k))
   *   res0: List[Symbol] = List('d, 'e, 'f, 'g)
   */

  /**
   * P19 (**) Rotate a list N places to the left.
   *   Examples:
   *   scala> rotate(3, List('a, 'b, 'c, 'd, 'e, 'f, 'g, 'h, 'i, 'j, 'k))
   *   res0: List[Symbol] = List('d, 'e, 'f, 'g, 'h, 'i, 'j, 'k, 'a, 'b, 'c)
   *   
   *   scala> rotate(-2, List('a, 'b, 'c, 'd, 'e, 'f, 'g, 'h, 'i, 'j, 'k))
   *   res1: List[Symbol] = List('j, 'k, 'a, 'b, 'c, 'd, 'e, 'f, 'g, 'h, 'i)
   * 
   */
  
  /**
   * P20 (*) Remove the Kth element from a list.
   *   Return the list and the removed element in a Tuple. Elements are numbered from 0.
   *   Example:
   *   
   *   scala> removeAt(1, List('a, 'b, 'c, 'd))
   *   res0: (List[Symbol], Symbol) = (List('a, 'c, 'd),'b)
   */


}  