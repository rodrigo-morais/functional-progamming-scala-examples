package sort.list

import scala._

object sort {
	def insertD(x: Int, xs: List[Int]): List[Int] = xs match {
		case List() => List(x)
		case y :: ys => {
			if(x < y) x :: xs
			else y :: insertD(x,ys)
		}
	}                                         //> insertD: (x: Int, xs: List[Int])List[Int]
	
	def insertA(x: Int, xs: List[Int]): List[Int] = xs match {
		case List() => List(x)
		case y :: ys => {
			if(x > y) x :: xs
			else y :: insertA(x,ys)
		}
	}                                         //> insertA: (x: Int, xs: List[Int])List[Int]

  def descending(e: List[Int]): List[Int] = e match {
  	case List() => List()
  	case y :: ys => insertD(y, descending(ys))
  }                                               //> descending: (e: List[Int])List[Int]
  
  def ascending(e: List[Int]): List[Int] = e match {
  	case List() => List()
  	case y :: ys => insertA(y, ascending(ys))
  }                                               //> ascending: (e: List[Int])List[Int]
  
  val l = List(3,5,7,2,4)                         //> l  : List[Int] = List(3, 5, 7, 2, 4)
  
  descending(l)                                   //> res0: List[Int] = List(2, 3, 4, 5, 7)
  ascending(l)                                    //> res1: List[Int] = List(7, 5, 4, 3, 2)
}