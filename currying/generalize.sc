package currying

object generalize {
  def mapReduce(f: Int => Int, combine: (Int, Int) => Int, zero: Int)(a: Int, b: Int): Int =
  	if(a > b) zero
  	else combine(f(a), mapReduce(f, combine, zero)(a + 1, b))
                                                  //> mapReduce: (f: Int => Int, combine: (Int, Int) => Int, zero: Int)(a: Int, b:
                                                  //|  Int)Int
  	
  mapReduce(x => x, (x, y) => x * y, 1)(1,5)      //> res0: Int = 120
  mapReduce(x => x, (x, y) => x * y, 1)(2,3)      //> res1: Int = 6
  
  mapReduce(x => x, (x, y) => x + y, 0)(1,5)      //> res2: Int = 15
  mapReduce(x => x, (x, y) => x + y, 0)(2,3)      //> res3: Int = 5
}