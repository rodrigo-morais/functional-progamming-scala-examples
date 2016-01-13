package List

object ListInt {
	trait List[+T] {
		def head: T
		def tail: List[T]
		def isEmpty: Boolean
	}
	
	class Cons[T](val head: T, val tail: List[T]) extends List[T] {
		def isEmpty = false
	}
	
	class Nil[T] extends List[Nothing] {
		def isEmpty = true
		def head = throw new NoSuchElementException("Nil.head")
		def tail = throw new NoSuchElementException("Nil.tail")
	}
	
	def nth[T](n: Int, list: List[T]): T =
		if(list.isEmpty) throw new IndexOutOfBoundsException
		else if(n == 0) list.head
		else nth(n - 1, list.tail)        //> nth: [T](n: Int, list: List.ListInt.List[T])T
		
		
	val list = new Cons(1, new Cons(2, new Cons(3, new Nil)))
                                                  //> list  : List.ListInt.Cons[Int] = List.ListInt$Cons@6108b2d7
	
	
	nth(0, list)                              //> res0: Int = 1
	nth(2, list)                              //> res1: Int = 3
	nth(-1, list)                             //> java.lang.IndexOutOfBoundsException
                                                  //| 	at List.ListInt$$anonfun$main$1.nth$1(List.ListInt.scala:21)
                                                  //| 	at List.ListInt$$anonfun$main$1.apply$mcV$sp(List.ListInt.scala:31)
                                                  //| 	at org.scalaide.worksheet.runtime.library.WorksheetSupport$$anonfun$$exe
                                                  //| cute$1.apply$mcV$sp(WorksheetSupport.scala:76)
                                                  //| 	at org.scalaide.worksheet.runtime.library.WorksheetSupport$.redirected(W
                                                  //| orksheetSupport.scala:65)
                                                  //| 	at org.scalaide.worksheet.runtime.library.WorksheetSupport$.$execute(Wor
                                                  //| ksheetSupport.scala:75)
                                                  //| 	at List.ListInt$.main(List.ListInt.scala:18)
                                                  //| 	at List.ListInt.main(List.ListInt.scala)
              
  
}