package streams

object range {
  def streamRange(lo: Int, hi: Int): Stream[Int] = {
	  print(lo+" ")
	  if (lo >= hi) Stream.empty
	  else Stream.cons(lo, streamRange(lo + 1, hi))
	}                                         //> streamRange: (lo: Int, hi: Int)Stream[Int]
	
	streamRange(1,10)                         //> 1 res0: Stream[Int] = Stream(1, ?)
	streamRange(1, 10).take(3).toList         //> 1 2 3 res1: List[Int] = List(1, 2, 3)
	streamRange(1, 10).take(3)                //> 1 res2: scala.collection.immutable.Stream[Int] = Stream(1, ?)
	streamRange(1, 10).toList                 //> 1 2 3 4 5 6 7 8 9 10 res3: List[Int] = List(1, 2, 3, 4, 5, 6, 7, 8, 9)
}