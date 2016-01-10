package palindrome

object palindrome {
  def isPalindrome(word: String): Boolean = {
  	def reverse(word: String): String =
	  	if(word.isEmpty) ""
	  	else reverse(word.tail) + word.head
	  	
	  def hasJustOneDifference(word: String): Boolean = {
	  	val newWord = reverse(word)
	  	def loop(word: String, newWord: String, changes: Int): Boolean = {
	  		if(word.isEmpty) changes <= 1
	  		else if(word.head == newWord.head) loop(word.tail.dropRight(1), newWord.tail.dropRight(1), changes)
	  		else loop(word, newWord.last + newWord.tail.dropRight(1) + newWord.head, changes + 1)
	  	}
	  	
	  	loop(word, newWord, 0)
	  }
	  	
	  	
	  	
  	word == reverse(word) || hasJustOneDifference(word)
  }                                               //> isPalindrome: (word: String)Boolean
  
  isPalindrome("dad")                             //> res0: Boolean = true
  isPalindrome("man")                             //> res1: Boolean = true
  isPalindrome("abccba")                          //> res2: Boolean = true
  isPalindrome("abccbx")                          //> res3: Boolean = true
  isPalindrome("abxcba")                          //> res4: Boolean = true
  isPalindrome("soccer")                          //> res5: Boolean = false
  isPalindrome("airplane")                        //> res6: Boolean = false
  isPalindrome("many")                            //> res7: Boolean = false
  
  
}