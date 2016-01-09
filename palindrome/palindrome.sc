package palindrome

object palindrome {
  def isPalindrome(word: String): Boolean = {
  	def reverse(word: String): String =
	  	if(word.isEmpty) ""
	  	else reverse(word.tail) + word.head
	  	
  	word == reverse(word)
  }                                               //> isPalindrome: (word: String)Boolean
  
  isPalindrome("dad")                             //> res0: Boolean = true
  isPalindrome("man")                             //> res1: Boolean = false
  isPalindrome("abccba")                          //> res2: Boolean = true
  isPalindrome("abccbx")                          //> res3: Boolean = false
  
  
}