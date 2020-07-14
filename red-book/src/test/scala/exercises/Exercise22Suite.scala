package exercises

import org.scalatest.freespec.AnyFreeSpecLike
import org.scalatest.matchers.should.Matchers
import org.scalatest.Inside
import Exercise22._


class Exercise22Suite extends AnyFreeSpecLike with Matchers with Inside {
  "isSorted" in {
    isSorted(Array(1, 3, 5, 7), (x: Int, y: Int) => x < y) shouldBe true
    isSorted(Array(7, 5, 1, 3), (x: Int, y: Int) => x > y) shouldBe false
    isSorted(Array("Scala", "Exercises"), (x: String, y: String) => x.length < y.length) shouldBe true
  }
}

