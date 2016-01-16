package List

import scala._

object flatten {
  def flatten(xs: List[Any]): List[Any] = xs match {
  	case List() => xs
  	case (y:List[Any]) :: ys => flatten(y) ::: flatten(ys)
  	case y :: ys => y :: flatten(ys)
  }                                               //> flatten: (xs: List[Any])List[Any]
  
  val l1 = List(List(1, 1), 2, List(3, List(5, 8)))
                                                  //> l1  : List[Any] = List(List(1, 1), 2, List(3, List(5, 8)))
  val l2 = List(1,1,2,3,5,8)                      //> l2  : List[Int] = List(1, 1, 2, 3, 5, 8)
  
  flatten(l1)                                     //> res0: List[Any] = List(1, 1, 2, 3, 5, 8)
  
  flatten(l1) == l2                               //> res1: Boolean = true
}