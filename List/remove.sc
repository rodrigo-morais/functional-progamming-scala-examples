package List

import scala._

object remove {
  def removeAt[T](n: Int, xs: List[T]) = (xs take n) ::: (xs drop n + 1)
                                                  //> removeAt: [T](n: Int, xs: List[T])List[T]
  
  val l = List('a', 'b', 'c', 'd')                //> l  : List[Char] = List(a, b, c, d)
  l take 1                                        //> res0: List[Char] = List(a)
  l drop 2                                        //> res1: List[Char] = List(c, d)
  removeAt(1, l)                                  //> res2: List[Char] = List(a, c, d)
  removeAt(10, l)                                 //> res3: List[Char] = List(a, b, c, d)
  
  val l2 = List()                                 //> l2  : List[Nothing] = List()
  removeAt(1, l2)                                 //> res4: List[Nothing] = List()
  
  removeAt(1, List('a', 'b', 'c', 'd')) == List('a', 'c', 'd')
                                                  //> res5: Boolean = true
}