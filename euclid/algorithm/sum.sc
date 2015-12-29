package euclid.algorithm

object sum {
	def sumInts(a: Int, b: Int): Int = 
		if(a > b) 0 else a + sumInts(a + 1, b)
		
	sumInts(5, 10)
	sumInts(6,12)
	sumInts(3,12)
}