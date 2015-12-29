package higher.order.function

object sum {
	def cube(x: Int) = x * x * x              //> cube: (x: Int)Int
	
	def factorial(n: Int): Int =
  	if(n == 0) 1 else n * factorial(n - 1)    //> factorial: (n: Int)Int
  	
 	def id(x: Int) = x                        //> id: (x: Int)Int
 	
 	def sum(f: Int => Int, a: Int, b: Int): Int =
 		if(a > b) 0 else f(a) + sum(f, a + 1, b)
                                                  //> sum: (f: Int => Int, a: Int, b: Int)Int
 		
	def sumInts(a: Int, b: Int): Int = sum(id, a, b)
                                                  //> sumInts: (a: Int, b: Int)Int
	def sumCubes(a: Int, b: Int): Int = sum(cube, a, b)
                                                  //> sumCubes: (a: Int, b: Int)Int
	def sumFactorial(a: Int, b: Int): Int = sum(factorial, a, b)
                                                  //> sumFactorial: (a: Int, b: Int)Int
		
	sumInts(5, 10)                            //> res0: Int = 45
	sumInts(6, 12)                            //> res1: Int = 63
	sumInts(3, 12)                            //> res2: Int = 75
                                                  
  sumCubes(5, 10)                                 //> res3: Int = 2925
  sumCubes(6, 12)                                 //> res4: Int = 5859
  sumCubes(3, 12)                                 //> res5: Int = 6075
 	
 	sumFactorial(5, 10)                       //> res6: Int = 4037880
  sumFactorial(6, 12)                             //> res7: Int = 522956160
  sumFactorial(3, 12)                             //> res8: Int = 522956310
}