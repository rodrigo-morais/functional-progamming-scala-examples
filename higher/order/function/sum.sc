package higher.order.function

object sum {
	
	def factorial(n: Int): Int =
  	if(n == 0) 1 else n * factorial(n - 1)    //> factorial: (n: Int)Int
 		
 	def sum(f: Int => Int)(a: Int, b: Int): Int =
 		if(a > b) 0 else f(a) + sum(f)(a + 1, b)
                                                  //> sum: (f: Int => Int)(a: Int, b: Int)Int
		
	sum(x => x)(5, 10)                        //> res0: Int = 45
	sum(x => x)(6, 12)                        //> res1: Int = 63
	sum(x => x)(3, 12)                        //> res2: Int = 75
                                                  
  sum(x => x * x * x)(5, 10)                      //> res3: Int = 2925
  sum(x => x * x * x)(6, 12)                      //> res4: Int = 5859
  sum(x => x * x * x)(3, 12)                      //> res5: Int = 6075
 	
 	sum(factorial)(5, 10)                     //> res6: Int = 4037880
  sum(factorial)(6, 12)                           //> res7: Int = 522956160
  sum(factorial)(3, 12)                           //> res8: Int = 522956310
}