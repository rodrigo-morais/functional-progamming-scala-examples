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
}