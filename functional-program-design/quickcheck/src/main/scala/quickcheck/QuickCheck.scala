package quickcheck

import common._

import org.scalacheck._
import Arbitrary._
import Gen._
import Prop._
import Math.{min, max}

abstract class QuickCheckHeap extends Properties("Heap") with IntHeap {

  lazy val genHeap: Gen[H] = for {
    i <- arbitrary[A]
    h <- frequency((1, Gen.const(empty)), (9, genHeap))
  } yield insert(i, h)

  implicit lazy val arbHeap: Arbitrary[H] = Arbitrary(genHeap)

  property("gen1") = forAll { (h: H) =>
    val m = if (isEmpty(h)) 0 else findMin(h)
    findMin(insert(m, h)) == m
  }

  property("min1") = forAll { a: Int =>
    val h = insert(a, empty)
    findMin(h) == a
  }

  property("min2") = forAll { (a: Int, b: Int) =>
    val h = insert(a, insert(b, empty))
    findMin(h) == min(a, b)
  }

  property("del1") = forAll { a: Int =>
    val h = insert(a, empty)
    deleteMin(h) == empty
  }

  property("del2") = forAll { (a: Int, b: Int) =>
    val h = deleteMin(insert(a, insert(b, empty)))
    findMin(h) == max(a, b)
  }

  property("sort1") = forAll { h: H =>
    def sorted(h: H): Boolean =
      if (isEmpty(h)) true
      else {
        val m = findMin(h)
        val h2 = deleteMin(h)
        isEmpty(h2) || (m <= findMin(h2) && sorted(h2))
      }

    sorted(h)
  }

  property("meld1") = forAll { (h1: H, h2: H) =>
    findMin(meld(h1, h2)) == min(findMin(h1), findMin(h2))
  }

  property("equal") = forAll { (h1: H, h2: H) =>
    def equal(h1: H, h2: H): Boolean =
      if (isEmpty(h1) && isEmpty(h2)) true
      else {
        val m1 = findMin(h1)
        val m2 = findMin(h2)
        m1 == m2 && equal(deleteMin(h1), deleteMin(h2))
      }

    equal(meld(h1, h2), meld(deleteMin(h1), insert(findMin(h1), h2)))
  }
}
