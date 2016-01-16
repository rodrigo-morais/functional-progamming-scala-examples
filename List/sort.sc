package List

import scala._

object sort {
  def merge(xs: List[Int], ys: List[Int]): List[Int] = (xs, ys) match {
	  case (List(), ys1) => ys1
	  case (xs1, List()) => xs1
	  case (x :: xs1, y :: ys1) =>
	  	if(x <= y) x :: merge(xs1, ys)
	  	else y :: merge(xs, ys1)
	}                                         //> merge: (xs: List[Int], ys: List[Int])List[Int]
	
	def sort(l: List[Int]): List[Int] = {
		val n = l.length/2
		
		if(n == 0) l
		else {
			val (frst, snd) = l splitAt n
			merge(sort(frst),sort(snd))
		}
	}                                         //> sort: (l: List[Int])List[Int]
	
	val l1 = List(2,-4,1,2,5,3,7,6)           //> l1  : List[Int] = List(2, -4, 1, 2, 5, 3, 7, 6)
	val l2 = List(-4,1,2,2,3,5,6,7)           //> l2  : List[Int] = List(-4, 1, 2, 2, 3, 5, 6, 7)
	
	sort(l1)                                  //> res0: List[Int] = List(-4, 1, 2, 2, 3, 5, 6, 7)
	
	sort(l1) == l2                            //> res1: Boolean = true
}