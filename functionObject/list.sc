package functionObject

object list {
	trait List[T] {
		def head: T
		def tail: List[T]
		def isEmpty: Boolean
	}
	
	class Cons[T](val head: T, val tail: List[T]) extends List[T] {
		def isEmpty = false
	}
	
	class Nil[T] extends List[T] {
		def isEmpty = true
		def head = throw new NoSuchElementException("Nil.head")
		def tail = throw new NoSuchElementException("Nil.tail")
	}
	
	object List {
		def apply[T](x: T, y: T): List[T] = new Cons(x, new Cons(y, new Nil))
		def apply[T](x: T): List[T] = new Cons(x, new Nil)
		def apply[T](): List[T] = new Nil
	}
	
	List()                                    //> res0: functionObject.list.List[Nothing] = functionObject.list$Nil@73a8dfcc
	List(1)                                   //> res1: functionObject.list.List[Int] = functionObject.list$Cons@1554909b
	List(2,3)                                 //> res2: functionObject.list.List[Int] = functionObject.list$Cons@6bf256fa
}