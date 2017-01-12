package calculator

import Math.sqrt

object Polynomial {
  def computeDelta(a: Signal[Double], b: Signal[Double],
      c: Signal[Double]): Signal[Double] = {
    val _b = b()
    Signal(_b * _b - 4 * a() * c())
  }

  def computeSolutions(a: Signal[Double], b: Signal[Double],
      c: Signal[Double], delta: Signal[Double]): Signal[Set[Double]] = {
    val square = sqrt(computeDelta(a, b, c)())
    val _a = a()
    val _b = b()
    val first = (-_b + square) / (2 * _a)
    val second = (-_b - square) / (2 * _a)
    Signal(Set(first, second))
  }
}
