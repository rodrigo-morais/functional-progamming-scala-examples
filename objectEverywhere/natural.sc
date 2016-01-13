package objectEverywhere

object natural {
  abstract class Nat {
  	def isZero: Boolean
  	def predecessor: Nat
  	def sucessor: Nat = new Succ(this)
  	def +(that: Nat): Nat
  	def -(that: Nat): Nat
  	override def toString: String
  }
  
  object Zero extends Nat {
  	def isZero: Boolean = true
  	def predecessor: Nat = throw new Error("Doesn't exist")
  	def +(that: Nat): Nat = that
  	def -(that: Nat): Nat = if(that.isZero) this else throw new Error("Doesn't exist")
  	override def toString: String = "0"
  }
  
  class Succ(n: Nat) extends Nat {
  	def isZero: Boolean = false
  	def predecessor: Nat = n
  	def +(that: Nat): Nat = new Succ(n + that)
  	def -(that: Nat): Nat = if(that.isZero) this else n - that.predecessor
  	override def toString: String = {
  		def loop(n: Nat, acc: Int): Int = {
  			if(n.isZero) acc
  			else loop(n.predecessor, acc + 1)
  		}
  		
  		loop(this, 0).toString
  	}
  }
  
  val v0 = Zero                                   //> v0  : objectEverywhere.natural.Zero.type = 0
  val v1 = v0.sucessor                            //> v1  : objectEverywhere.natural.Nat = 1
  v1.predecessor                                  //> res0: objectEverywhere.natural.Nat = 0
 	val v2 = v1.sucessor                      //> v2  : objectEverywhere.natural.Nat = 2
 	v2 + v1                                   //> res1: objectEverywhere.natural.Nat = 3
 	v2 - v1                                   //> res2: objectEverywhere.natural.Nat = 1
 	v2.isZero                                 //> res3: Boolean = false
 	v0.isZero                                 //> res4: Boolean = true
}