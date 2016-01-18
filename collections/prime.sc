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
}