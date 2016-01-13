package List

object ListInt {
	trait List[+T] {
		def head: T
		def tail: List[T]
		def isEmpty: Boolean
		def prepend[U >: T](elem: U): List[U] = new Cons(elem, this)
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
		else nth(n - 1, list.tail)
		
		
	val list = new Cons(1, new Cons(2, new Cons(3, new Nil)))
	
	
	nth(0, list)
	nth(2, list)
	nth(-1, list)
 def f(xs: List[NonEmpty], x: Empty) = xs prepend x
              
  
}