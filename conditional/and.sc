package conditional

object and {
  def and(x: Boolean, y: Boolean): Boolean =
		if(x) y else false                //> and: (x: Boolean, y: Boolean)Boolean
		
	and(true, true)                           //> res0: Boolean = true
	and(true, false)                          //> res1: Boolean = false
	and(false, true)                          //> res2: Boolean = false
	and(false, false)                         //> res3: Boolean = false
}