package function.data

object rational {
  val t = new RationalNum(1,2)                    //> t  : function.data.RationalNum = 1/2
  val s = new RationalNum(2,3)                    //> s  : function.data.RationalNum = 2/3
  
  t.add(s)                                        //> res0: function.data.RationalNum = 7/6
  
  t.neg                                           //> res1: function.data.RationalNum = 1/-2
  
  t.sub(s)                                        //> res2: function.data.RationalNum = 1/-6
  
  
  val x = new RationalNum(1,3)                    //> x  : function.data.RationalNum = 1/3
  val y = new RationalNum(5,7)                    //> y  : function.data.RationalNum = 5/7
  val z = new RationalNum(3,2)                    //> z  : function.data.RationalNum = 3/2
  
  x.sub(y).sub(z)                                 //> res3: function.data.RationalNum = -79/42
  y.add(y)                                        //> res4: function.data.RationalNum = 10/7
}

class RationalNum(x: Int, y: Int) {
	private def gcd(x: Int, y: Int): Int =
		if(y == 0) x else gcd(y, x % y)
	
	val numer = x / gcd(x, y)
	val denom = y / gcd(x, y)
	
	def add(that: RationalNum) = {
		val _numer = that.numer * denom + numer * that.denom
		val _denom = that.denom * denom
		
		new RationalNum(_numer, _denom)
	}
	
	def sub(that: RationalNum) = add(that.neg)
	
	def neg = new RationalNum(-numer, denom)
	
	override def toString =
		numer + "/" + denom
}