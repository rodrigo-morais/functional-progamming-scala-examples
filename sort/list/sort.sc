package sort.list

import scala._

object sort {
	def insert(x: Int, xs: List[Int]): List[Int] = xs match {
		case List() => List(x)
		case y :: ys => {
			if(x < y) x :: xs
			else y :: insert(x,ys)
		}
	}                                         //> insert: (x: Int, xs: List[Int])List[Int]

  def descending(e: List[Int]): List[Int] = e match {
  	case List() => List()
  	case y :: ys => insert(y, descending(ys))
  }                                               //> descending: (e: List[Int])List[Int]
  
  val l = List(3,5,7,2,4)                         //> l  : List[Int] = List(3, 5, 7, 2, 4)
  
  descending(l)                                   //> res0: List[Int] = List(2, 3, 4, 5, 7)
}