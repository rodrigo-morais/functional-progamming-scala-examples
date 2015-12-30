package currying

object generalize {
  def mapReduce(f: Int => Int, combine: (Int, Int) => Int, zero: Int)(a: Int, b: Int): Int =
  	if(a > b) zero
  	else combine(f(a), mapReduce(f, combine, zero)(a + 1, b))
                                                  //> mapReduce: (f: Int => Int, combine: (Int, Int) => Int, zero: Int)(a: Int, b:
                                                  //|  Int)Int
  	
  def product(f: Int => Int)(a: Int, b:Int): Int = mapReduce(f, (x, y) => x * y, 1)(a, b)
                                                  //> product: (f: Int => Int)(a: Int, b: Int)Int
  	
  product(x => x)(1,5)                            //> res0: Int = 120
  product(x => x)(2,3)                            //> res1: Int = 6
  
  def sum(f: Int => Int)(a: Int, b:Int): Int = mapReduce(f, (x, y) => x + y, 0)(a, b)
                                                  //> sum: (f: Int => Int)(a: Int, b: Int)Int
  
  sum(x => x)(1,5)                                //> res2: Int = 15
  sum(x => x)(2,3)                                //> res3: Int = 5
  
  def factorial(n: Int): Int = product(x => x)(1, n)
                                                  //> factorial: (n: Int)Int
  	
  factorial(3)                                    //> res4: Int = 6
  factorial(4)                                    //> res5: Int = 24
  factorial(5)                                    //> res6: Int = 120
}