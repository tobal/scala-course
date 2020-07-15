package exercises

import org.scalatest.freespec.AnyFreeSpecLike
import org.scalatest.matchers.should.Matchers
import org.scalatest.Inside
import Exercise23._


class Exercise23Suite extends AnyFreeSpecLike with Matchers with Inside {
  "curry" in {
    def f(a: Int, b: Int): Int = a + b
    def g(a: Int)(b: Int): Int = a + b

    curry(f)(1)(1) == f(1, 1) shouldBe true
    curry(f)(1)(1) == g(1)(1) shouldBe true
  }
}

