package List

import scala._

object highOrderFunction {
  def squareList(xs: List[Int]): List[Int] = xs match {
    case Nil     => xs
    case y :: ys => (y * y) :: squareList(ys)
  }                                               //> squareList: (xs: List[Int])List[Int]
  
  def squareList2(xs: List[Int]): List[Int] =
    xs map (x => x * x)                           //> squareList2: (xs: List[Int])List[Int]
    
  val l = List(1,2,3,4,5)                         //> l  : List[Int] = List(1, 2, 3, 4, 5)
  squareList(l)                                   //> res0: List[Int] = List(1, 4, 9, 16, 25)
  squareList2(l)                                  //> res1: List[Int] = List(1, 4, 9, 16, 25)
  
  def pack[T](xs: List[T]): List[List[T]] = xs match {
    case Nil      => Nil
    case x :: xs1 =>
    	val (first, rest) = xs span (y => y == x)
			first :: pack(rest)
  }                                               //> pack: [T](xs: List[T])List[List[T]]
  
  val origin = List("a", "a", "a", "b", "c", "c", "a")
                                                  //> origin  : List[String] = List(a, a, a, b, c, c, a)
  val result = List(List("a", "a", "a"), List("b"), List("c", "c"), List("a"))
                                                  //> result  : List[List[String]] = List(List(a, a, a), List(b), List(c, c), List
                                                  //| (a))
  
  pack(origin) == result                          //> res2: Boolean = true
  
  def encode[T](xs: List[T]): List[(T, Int)] = xs match {
    case Nil      => Nil
    case x :: xs1 =>
    	val (first, rest) = xs span (y => y == x)
			(first.head, first.length) :: encode(rest)
  }                                               //> encode: [T](xs: List[T])List[(T, Int)]
  
  def encode2[T](xs: List[T]): List[(T, Int)] =
  	pack(xs) map (ys => (ys.head, ys.length)) //> encode2: [T](xs: List[T])List[(T, Int)]
  
  val eOrigin = List("a", "a", "a", "b", "c", "c", "a")
                                                  //> eOrigin  : List[String] = List(a, a, a, b, c, c, a)
  val eResult = List(("a", 3), ("b", 1), ("c", 2), ("a", 1))
                                                  //> eResult  : List[(String, Int)] = List((a,3), (b,1), (c,2), (a,1))
  encode(eOrigin)                                 //> res3: List[(String, Int)] = List((a,3), (b,1), (c,2), (a,1))
  encode(eOrigin) == eResult                      //> res4: Boolean = true
  
  encode2(eOrigin)                                //> res5: List[(String, Int)] = List((a,3), (b,1), (c,2), (a,1))
  encode2(eOrigin) == eResult                     //> res6: Boolean = true
}