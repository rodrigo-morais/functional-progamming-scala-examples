package List

import scala._

object merge {
  def merge(xs: List[Int], ys: List[Int]): List[Int] = (xs, ys) match {
	  case (List(), ys1) => ys1
	  case (xs1, List()) => xs1
	  case (x :: xs1, y :: ys1) =>
	  	if(x <= y) x :: merge(xs1, ys)
	  	else y :: merge(xs, ys1)
	}                                         //> merge: (xs: List[Int], ys: List[Int])List[Int]
	
	val l1 = List(1,3,6,8)                    //> l1  : List[Int] = List(1, 3, 6, 8)
	val l2 = List(2,4,5)                      //> l2  : List[Int] = List(2, 4, 5)
	
	merge(l1,l2)                              //> res0: List[Int] = List(1, 2, 3, 4, 5, 6, 8)
    
    
}