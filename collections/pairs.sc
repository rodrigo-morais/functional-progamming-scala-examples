package collections

import scala._

object pairs {
  val n = 7                                       //> n  : Int = 7
  
  def isPrime(n: Int): Boolean = (2 until n) forall (y => n % y != 0)
                                                  //> isPrime: (n: Int)Boolean
  
  (1 until n)
  	.flatMap(i => (1 until i)
  									.map(j => (i,j)
  								)
  ).filter(x => isPrime(x._1 + x._2))             //> res0: scala.collection.immutable.IndexedSeq[(Int, Int)] = Vector((2,1), (3,2
                                                  //| ), (4,1), (4,3), (5,2), (6,1), (6,5))
  	
  for{
  	i <- 1 until n
  	j <- 1 until i
  	if isPrime(i + j)
  }	yield (i, j)                              //> res1: scala.collection.immutable.IndexedSeq[(Int, Int)] = Vector((2,1), (3,2
                                                  //| ), (4,1), (4,3), (5,2), (6,1), (6,5))
 
	def scalarProduct(xs: List[Double], ys: List[Double]) : Double =
		(for( (x, y) <- xs zip ys) yield x * y).sum
                                                  //> scalarProduct: (xs: List[Double], ys: List[Double])Double
 
 	val l1 = List(1.3,2.5,3.6,4.3,5.8)        //> l1  : List[Double] = List(1.3, 2.5, 3.6, 4.3, 5.8)
 	val l2 = List(5.8,6.3,7.4,8.7)            //> l2  : List[Double] = List(5.8, 6.3, 7.4, 8.7)
	
	scalarProduct(l1, l2)                     //> res2: Double = 87.34
}