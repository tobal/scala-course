package funsets

import org.scalatest.FunSuite


import org.junit.runner.RunWith
import org.scalatest.junit.JUnitRunner

@RunWith(classOf[JUnitRunner])
class FunSetSuite extends FunSuite {

  import FunSets._

  test("contains is implemented") {
    assert(contains(x => true, 100))
  }

  trait TestSets {
    val s1 = singletonSet(1)
    val s2 = singletonSet(2)
    val s3 = singletonSet(3)
  }

  test("singletonSet(1) contains 1") {
    new TestSets {
      assert(contains(s1, 1), "Singleton")
    }
  }

  test("singletonSet(1) doesn't contain 2") {
    new TestSets {
      assert(!contains(s1, 2), "Singleton")
    }
  }

  test("union contains all elements of each set") {
    new TestSets {
      val s = union(s1, s2)
      assert(contains(s, 1), "Union 1")
      assert(contains(s, 2), "Union 2")
      assert(!contains(s, 3), "Union 3")
    }
  }

  test("intersect contains common elements of each set") {
    new TestSets {
      val s12 = union(s1, s2)
      val int_s1 = intersect(s1, s12)
      val int_s2 = intersect(s2, s12)
      assert(contains(int_s1, 1), "Intersect 1")
      assert(!contains(int_s1, 2), "Intersect 2")
      assert(!contains(int_s2, 1), "Intersect 3")
      assert(contains(int_s2, 2), "Intersect 4")
    }
  }

  test("diff contains the difference of two given sets") {
    new TestSets {
      val s12 = union(s1, s2)
      val diff_s = diff(s12, s2)
      assert(contains(diff_s, 1), "Diff 1")
      assert(!contains(diff_s, 2), "Diff 2")
    }
  }

  test("filter can filter by lambda") {
    new TestSets {
      val s12 = union(s1, s2)
      val filtered = filter(s12, (x: Int) => x == 2)
      assert(!contains(filtered, 1), "Diff 1")
      assert(contains(filtered, 2), "Diff 2")
    }
  }


}
