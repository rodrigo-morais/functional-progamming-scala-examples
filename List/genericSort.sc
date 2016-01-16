package List

import scala._

object genericSort {
  def merge[T](xs: List[T], ys: List[T])(lt: (T,T) => Boolean): List[T] = (xs, ys) match {
	  case (List(), ys1) => ys1
	  case (xs1, List()) => xs1
	  case (x :: xs1, y :: ys1) =>
	  	if(lt(x, y)) x :: merge(xs1, ys)(lt)
	  	else y :: merge(xs, ys1)(lt)
	}                                         //> merge: [T](xs: List[T], ys: List[T])(lt: (T, T) => Boolean)List[T]
	
	def sort[T](l: List[T])(lt: (T,T) => Boolean): List[T] = {
		val n = l.length/2
		
		if(n == 0) l
		else {
			val (frst, snd) = l splitAt n
			merge(sort(frst)(lt),sort(snd)(lt))(lt)
		}
	}                                         //> sort: [T](l: List[T])(lt: (T, T) => Boolean)List[T]
	
	val l1 = List(2,-4,1,2,5,3,7,6)           //> l1  : List[Int] = List(2, -4, 1, 2, 5, 3, 7, 6)
	val l2 = List(-4,1,2,2,3,5,6,7)           //> l2  : List[Int] = List(-4, 1, 2, 2, 3, 5, 6, 7)
	
	sort(l1)((x, y) => x < y)                 //> res0: List[Int] = List(-4, 1, 2, 2, 3, 5, 6, 7)
	
	sort(l1)((x, y) => x < y) == l2           //> res1: Boolean = true
	
	val fruits = List("apple", "lemon", "pineapple", "orange", "banana", "pear")
                                                  //> fruits  : List[String] = List(apple, lemon, pineapple, orange, banana, pear)
                                                  //| 
	sort(fruits)((x, y) => x < y)             //> res2: List[String] = List(apple, banana, lemon, orange, pear, pineapple)
	sort(fruits)((x: String, y: String) => x.compareTo(y) < 0)
                                                  //> res3: List[String] = List(apple, banana, lemon, orange, pear, pineapple)
	sort(fruits)((x, y) => x.length < y.length)
                                                  //> res4: List[String] = List(pear, lemon, apple, banana, orange, pineapple)
}