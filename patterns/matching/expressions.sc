package patterns.matching


object expressions {
	trait Expr
	case class Number(n: Int) extends Expr
	case class Sum(e1: Expr, e2: Expr) extends Expr
	case class Var(x: Char) extends Expr
	case class Prod(p1: Expr, p2: Expr) extends Expr

	def eval(e: Expr): Int = e match {
		case Number(n) => n
		case Sum(e1, e2) => eval(e1) + eval(e2)
	}                                         //> eval: (e: patterns.matching.expressions.Expr)Int
	
	def show(e: Expr): String = e match {
		case Number(n) => n.toString
		case Var(x) => x.toString
		case Sum(l, r) => show(l) + " + " + show(r)
		case Prod(e1, e2) => "%s * %s".format(
		  e1 match {
		    case Sum(_, _) => "(%s)".format(show(e1))
		    case _ => show(e1)
		  },
		  e2 match {
		    case Sum(_, _) => "(%s)".format(show(e2))
		    case _ => show(e2)
		  }
	  )
	}                                         //> show: (e: patterns.matching.expressions.Expr)String

  val n = Number(1)                               //> n  : patterns.matching.expressions.Number = Number(1)
  val s = Sum(Number(1), Number(2))               //> s  : patterns.matching.expressions.Sum = Sum(Number(1),Number(2))
  
  eval(n)                                         //> res0: Int = 1
  eval(s)                                         //> res1: Int = 3
  
  show(n)                                         //> res2: String = 1
  show(s)                                         //> res3: String = 1 + 2
  
  val v = Var('x')                                //> v  : patterns.matching.expressions.Var = Var(x)
  val vs = Var('y')                               //> vs  : patterns.matching.expressions.Var = Var(y)
  
  show(v)                                         //> res4: String = x
  show(vs)                                        //> res5: String = y
  
  val p1 = Prod(Number(3), Number(4))             //> p1  : patterns.matching.expressions.Prod = Prod(Number(3),Number(4))
  val p2 = Prod(Sum(Number(3), Number(4)), Number(7))
                                                  //> p2  : patterns.matching.expressions.Prod = Prod(Sum(Number(3),Number(4)),Num
                                                  //| ber(7))
  val p3 = Sum(Prod(Number(2), Var('x')), Var('y'))
                                                  //> p3  : patterns.matching.expressions.Sum = Sum(Prod(Number(2),Var(x)),Var(y)
                                                  //| )
  val p4 = Prod(Sum(Number(2), Var('x')), Var('y'))
                                                  //> p4  : patterns.matching.expressions.Prod = Prod(Sum(Number(2),Var(x)),Var(y
                                                  //| ))
  val p5 = Prod(Sum(Number(2), Var('x')), Sum(Var('y'), Number(5)))
                                                  //> p5  : patterns.matching.expressions.Prod = Prod(Sum(Number(2),Var(x)),Sum(V
                                                  //| ar(y),Number(5)))
  
  show(p1)                                        //> res6: String = 3 * 4
  show(p2)                                        //> res7: String = (3 + 4) * 7
  show(p3)                                        //> res8: String = 2 * x + y
  show(p4)                                        //> res9: String = (2 + x) * y
  show(p5)                                        //> res10: String = (2 + x) * (y + 5)
}