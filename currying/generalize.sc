package currying

object generalize {
  def generalize(f: Int => Int)(a: Int, b: Int, minor: Int): Int =
  	if(a > b) minor
  	else if(minor == 0) f(a) + generalize(f)(a + 1, b, minor)
  	else f(a) * generalize(f)(a + 1, b, minor)//> generalize: (f: Int => Int)(a: Int, b: Int, minor: Int)Int
  	
  generalize(x => x)(1,5,0)                       //> res0: Int = 15
  generalize(x => x)(2,3,0)                       //> res1: Int = 5
  
  generalize(x => x)(1,5,1)                       //> res2: Int = 120
  generalize(x => x)(2,3,1)                       //> res3: Int = 6
}