package exercises

import org.scalatest.freespec.AnyFreeSpecLike
import org.scalatest.matchers.should.Matchers
import org.scalatest.Inside
import Exercise21._


class Exercise21Suite extends AnyFreeSpecLike with Matchers with Inside {
  "fib" in {
    fib(5) shouldBe 5
  }
}

