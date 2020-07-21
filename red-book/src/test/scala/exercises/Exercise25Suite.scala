package exercises

import org.scalatest.freespec.AnyFreeSpecLike
import org.scalatest.matchers.should.Matchers
import org.scalatest.Inside
import Exercise25._


class Exercise25Suite extends AnyFreeSpecLike with Matchers with Inside {
  "compose" in {
    def f(b: Int): Int = b / 2
    def g(a: Int): Int = a + 2

    compose(f, g)(0) == compose(g, f)(0) shouldBe false
    compose(f, g)(2) shouldBe 2
    compose(g, f)(2) shouldBe 3
  }
}

