package List

import scala._

object reduction {
  def concat[T](xs: List[T], ys: List[T]): List[T] =
    (xs foldRight ys) (_ :: _)                    //> concat: [T](xs: List[T], ys: List[T])List[T]
    
  def concatReverse[T](xs: List[T], ys: List[T]): List[T] =
    (xs foldLeft ys) (_ :+ _)                     //> concatReverse: [T](xs: List[T], ys: List[T])List[T]
    
  val l1 = List(1,3,5,7,9)                        //> l1  : List[Int] = List(1, 3, 5, 7, 9)
  val l2 = List(2,4,6,8)                          //> l2  : List[Int] = List(2, 4, 6, 8)
  
  concat(l1, l2)                                  //> res0: List[Int] = List(1, 3, 5, 7, 9, 2, 4, 6, 8)
  concatReverse(l1, l2)                           //> res1: List[Int] = List(2, 4, 6, 8, 1, 3, 5, 7, 9)
}