package higher.order.function

object foldFactorial {
  (0 to 9).foldLeft(0)((acc, actual) => acc)      //> res0: Int = 0
  
  def factorial(n: Int): Int =
  	(1 to n).foldLeft(1)((acc, actual) => acc * actual)
                                                  //> factorial: (n: Int)Int
  	
  factorial(1)                                    //> res1: Int = 1
  factorial(2)                                    //> res2: Int = 2
  factorial(3)                                    //> res3: Int = 6
  factorial(4)                                    //> res4: Int = 24
  factorial(5)                                    //> res5: Int = 120
  factorial(6)                                    //> res6: Int = 720
  
}