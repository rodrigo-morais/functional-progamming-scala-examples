package List

import scala._

object init {
  val i1 = List(1,2,3,4,5,6,7,8)                  //> i1  : List[Int] = List(1, 2, 3, 4, 5, 6, 7, 8)
  val i2 = List(1)                                //> i2  : List[Int] = List(1)
  
  i1.init                                         //> res0: List[Int] = List(1, 2, 3, 4, 5, 6, 7)
  i2.init                                         //> res1: List[Int] = List()

	def init[T](xs: List[T]): List[T] = xs match {
		case List() => throw new Error("init of empty list")
		case List(x) => List()
		case y :: ys => y :: ys.reverse.tail.reverse
	}                                         //> init: [T](xs: List[T])List[T]
	
	def init2[T](xs: List[T]): List[T] = xs match {
		case List() => throw new Error("init of empty list")
		case List(x) => List()
		case y :: ys => y :: init(ys)
	}                                         //> init2: [T](xs: List[T])List[T]
	
	init(i1)                                  //> res2: List[Int] = List(1, 2, 3, 4, 5, 6, 7)
	init(i2)                                  //> res3: List[Int] = List()
	
	init2(i1)                                 //> res4: List[Int] = List(1, 2, 3, 4, 5, 6, 7)
	init2(i2)                                 //> res5: List[Int] = List()
  
}