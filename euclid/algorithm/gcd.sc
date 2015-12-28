package euclid.algorithm

object gcd {
	def gcd(x: Double, y: Double): Double =
		if(y == 0) x else gcd(y, x % y)   //> gcd: (x: Double, y: Double)Double
		
	gcd(21, 14)                               //> res0: Double = 7.0
	gcd(14, 21)                               //> res1: Double = 7.0
	gcd(5, 10)                                //> res2: Double = 5.0
	gcd(18, 81)                               //> res3: Double = 9.0
}