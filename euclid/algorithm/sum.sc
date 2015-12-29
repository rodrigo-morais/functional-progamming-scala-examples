package euclid.algorithm

object sum {
	def sumInts(a: Int, b: Int): Int =
		if(a > b) 0 else a + sumInts(a + 1, b)
                                                  //> sumInts: (a: Int, b: Int)Int
		
	sumInts(5, 10)                            //> res0: Int = 45
	sumInts(6, 12)                            //> res1: Int = 63
	sumInts(3, 12)                            //> res2: Int = 75
	
	def cube(x: Int) = x * x * x              //> cube: (x: Int)Int
	
	def sumCubes(a: Int, b: Int): Int =
		if(a > b) 0 else cube(a) + sumCubes(a + 1, b)
                                                  //> sumCubes: (a: Int, b: Int)Int
                                                  
  sumCubes(5, 10)                                 //> res3: Int = 2925
  sumCubes(6, 12)                                 //> res4: Int = 5859
  sumCubes(3, 12)                                 //> res5: Int = 6075
  
  def factorial(n: Int): Int =
  	if(n == 0) 1 else n * factorial(n - 1)    //> factorial: (n: Int)Int
  	
  factorial(4)                                    //> res6: Int = 24
 	factorial(5)                              //> res7: Int = 120
 	
 	def sumFactorial(a: Int, b: Int): Int =
 		if(a > b) 0 else factorial(a) + sumFactorial(a + 1, b)
                                                  //> sumFactorial: (a: Int, b: Int)Int
 		
 	sumFactorial(5, 10)                       //> res8: Int = 4037880
  sumFactorial(6, 12)                             //> res9: Int = 522956160
  sumFactorial(3, 12)                             //> res10: Int = 522956310
}