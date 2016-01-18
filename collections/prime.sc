package collections

object prime {
  def isPrime(n: Int): Boolean = {
  	def divide(n: Int, y: Int, acc: Int): Boolean = {
  		val division = n % y == 0
  		if(acc > 2) false
  		else if(y > n) acc == 2
  		else if(division) divide(n, y + 1, acc + 1)
  		else divide(n, y + 1, acc)
  	}
  	
  	divide(n, 1, 0)
  }                                               //> isPrime: (n: Int)Boolean
  
  isPrime(1)                                      //> res0: Boolean = false
  isPrime(2)                                      //> res1: Boolean = true
  isPrime(3)                                      //> res2: Boolean = true
  isPrime(4)                                      //> res3: Boolean = false
  isPrime(5)                                      //> res4: Boolean = true
  isPrime(10)                                     //> res5: Boolean = false
  isPrime(11)                                     //> res6: Boolean = true
  isPrime(12)                                     //> res7: Boolean = false
  
  def isPrime2(n: Int): Boolean = (2 until n) forall (y => n % y != 0)
                                                  //> isPrime2: (n: Int)Boolean
  
  isPrime2(1)                                     //> res8: Boolean = true
  isPrime2(2)                                     //> res9: Boolean = true
  isPrime2(3)                                     //> res10: Boolean = true
  isPrime2(4)                                     //> res11: Boolean = false
  isPrime2(5)                                     //> res12: Boolean = true
  isPrime2(10)                                    //> res13: Boolean = false
  isPrime2(11)                                    //> res14: Boolean = true
  isPrime2(12)                                    //> res15: Boolean = false
}