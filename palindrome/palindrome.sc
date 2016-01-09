package palindrome

object palindrome {
  def reverse(word: String): String =
  	if(word.isEmpty) ""
  	else reverse(word.tail) + word.head       //> reverse: (word: String)String
		
  
  reverse("dad")                                  //> res0: String = dad
  reverse("man")                                  //> res1: String = nam
  
  
}