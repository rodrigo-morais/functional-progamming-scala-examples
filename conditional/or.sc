package conditional

object or {
	def or(x: Boolean, y: Boolean): Boolean =
		if(x) x else y                    //> or: (x: Boolean, y: Boolean)Boolean
		
	or(true, true)                            //> res0: Boolean = true
	or(true, false)                           //> res1: Boolean = true
	or(false, false)                          //> res2: Boolean = false
	or(false, true)                           //> res3: Boolean = true
}