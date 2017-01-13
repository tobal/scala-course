package calculator

object Polynomial {
  def computeDelta(a: Signal[Double], b: Signal[Double],
      c: Signal[Double]): Signal[Double] = {
    val _b = b()
    Signal(_b * _b - 4 * a() * c())
  }

  def computeSolutions(a: Signal[Double], b: Signal[Double],
      c: Signal[Double], delta: Signal[Double]): Signal[Set[Double]] = {
    Signal {
      var result = Set[Double]()

      if (delta() > 0) {
        result += (-b() + math.sqrt(delta())) / (2 * a())
        result += (-b() - math.sqrt(delta())) / (2 * a())
      }
      else if (delta() == 0)
        result += (-b()) / (2 * a())

      result
    }
  }
}
