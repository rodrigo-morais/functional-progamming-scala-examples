package currying

object product {
	def product(f: Int => Int)(a: Int, b:Int): Int =
  	if(a> b) 1 else f(a) * product(f)(a + 1, b)
                                                  //> product: (f: Int => Int)(a: Int, b: Int)Int
  	
  product(x => x)(5,10)                           //> res0: Int = 151200
  product(x => x)(2,3)                            //> res1: Int = 6
  product(x => x)(1, 5)                           //> res2: Int = 120
  
  product(x => x * x * x)(5,10)                   //> res3: Int = -81362944
  product(x => x * x * x)(2,3)                    //> res4: Int = 216
  product(x => x * x * x)(1,5)                    //> res5: Int = 1728000
  
  def factorial(n: Int): Int = product(x => x)(1, n)
                                                  //> factorial: (n: Int)Int
  	
  factorial(3)                                    //> res6: Int = 6
  factorial(4)                                    //> res7: Int = 24
  factorial(5)                                    //> res8: Int = 120
}