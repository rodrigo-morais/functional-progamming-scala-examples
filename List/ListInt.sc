package List

object ListInt {
	trait List[T] {
		def head: T
		def tail: List[T]
		def isEmpty: Boolean
	}
	
	class Cons[T](val head: T, val tail: List[T]) extends List[T] {
		def isEmpty = false
	}
	
	class Nil[T] extends List[T] {
		def isEmpty = false
		def head = throw new NoSuchElementException("Nil.head")
		def tail = throw new NoSuchElementException("Nil.tail")
	}
  
}