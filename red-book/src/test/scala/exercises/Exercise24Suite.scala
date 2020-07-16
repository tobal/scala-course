package exercises

import org.scalatest.freespec.AnyFreeSpecLike
import org.scalatest.matchers.should.Matchers
import org.scalatest.Inside
import Exercise24._


class Exercise24Suite extends AnyFreeSpecLike with Matchers with Inside {
  "uncurry" in {
    def f(a: Int, b: Int): Int = a + b
    def g(a: Int)(b: Int): Int = a + b

    uncurry(g)(1, 1) == g(1)(1) shouldBe true
    uncurry(g)(1, 1) == f(1, 1) shouldBe true
  }
}

