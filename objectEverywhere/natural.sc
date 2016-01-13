package objectEverywhere

object natural {
  abstract class Nat {
  	def isZero: Boolean
  	def predecessor: Nat
  	def sucessor: Nat = new Succ(this)
  	def +(that: Nat): Nat
  	def -(that: Nat): Nat
  }
  
  object Zero extends Nat {
  	def isZero: Boolean = true
  	def predecessor: Nat = throw new Error("Doesn't exist")
  	def +(that: Nat): Nat = that
  	def -(that: Nat): Nat = if(that.isZero) this else throw new Error("Doesn't exist")
  }
  
  class Succ(n: Nat) extends Nat {
  	def isZero: Boolean = false
  	def predecessor: Nat = n
  	def +(that: Nat): Nat = new Succ(n + that)
  	def -(that: Nat): Nat = if(that.isZero) this else n - that.predecessor
  }
  
  val v0 = Zero                                   //> v0  : objectEverywhere.natural.Zero.type = objectEverywhere.natural$Zero$@5e
                                                  //| b5c224
  val v1 = v0.sucessor                            //> v1  : objectEverywhere.natural.Nat = objectEverywhere.natural$Succ@1554909b
  v1.predecessor                                  //> res0: objectEverywhere.natural.Nat = objectEverywhere.natural$Zero$@5eb5c224
                                                  //| 
 	val v2 = v1.sucessor                      //> v2  : objectEverywhere.natural.Nat = objectEverywhere.natural$Succ@6bf256fa
 	v2 + v1                                   //> res1: objectEverywhere.natural.Nat = objectEverywhere.natural$Succ@6cd8737
 	v2 - v1                                   //> res2: objectEverywhere.natural.Nat = objectEverywhere.natural$Succ@1554909b
 	v2.isZero                                 //> res3: Boolean = false
 	v0.isZero                                 //> res4: Boolean = true
}