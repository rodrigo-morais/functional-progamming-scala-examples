package patterns.matching


object expressions {
	trait Expr
	case class Number(n: Int) extends Expr
	case class Sum(e1: Expr, e2: Expr) extends Expr

	def eval(e: Expr): Int = e match {
		case Number(n) => n
		case Sum(e1, e2) => eval(e1) + eval(e2)
	}                                         //> eval: (e: patterns.matching.expressions.Expr)Int
	
	def show(e: Expr): String = e match {
		case Number(n) => n.toString
		case Sum(l, r) => show(l) + " + " + show(r)
	}                                         //> show: (e: patterns.matching.expressions.Expr)String

  val n = Number(1)                               //> n  : patterns.matching.expressions.Number = Number(1)
  val s = Sum(Number(1), Number(2))               //> s  : patterns.matching.expressions.Sum = Sum(Number(1),Number(2))
  
  eval(n)                                         //> res0: Int = 1
  eval(s)                                         //> res1: Int = 3
  
  show(n)                                         //> res2: String = 1
  show(s)                                         //> res3: String = 1 + 2
}