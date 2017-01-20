package calculator

sealed abstract class Expr
final case class Literal(v: Double) extends Expr
final case class Ref(name: String) extends Expr
final case class Plus(a: Expr, b: Expr) extends Expr
final case class Minus(a: Expr, b: Expr) extends Expr
final case class Times(a: Expr, b: Expr) extends Expr
final case class Divide(a: Expr, b: Expr) extends Expr

object Calculator {
  def computeValues(
      namedExpressions: Map[String, Signal[Expr]]): Map[String, Signal[Double]] = {
    val result = scala.collection.mutable.Map[String, Signal[Double]]()
    namedExpressions.foreach {case(k, v) => result += k -> Signal(eval(v(), namedExpressions - k))}
    result.toMap
  }

  def eval(expr: Expr, references: Map[String, Signal[Expr]]): Double = expr match {
    case Ref(name) => eval(getReferenceExpr(name, references), references)
    case Plus(a, b) => eval(a, references) + eval(b, references)
    case Minus(a, b) => eval(a, references) - eval(b, references)
    case Times(a, b) => eval(a, references) * eval(b, references)
    case Divide(a, b) => eval(a, references) / eval(b, references)
    case Literal(value) => value
  }

  /** Get the Expr for a referenced variables.
   *  If the variable is not known, returns a literal NaN.
   */
  private def getReferenceExpr(name: String,
      references: Map[String, Signal[Expr]]) = {
    references.get(name).fold[Expr] {   // get returns Option
      Literal(Double.NaN)               // this will be returned for None
    } { exprSignal =>
      exprSignal()                      // this will be returned for Some
    }
  }
}
