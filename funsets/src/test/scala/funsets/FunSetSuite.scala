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
    val s12 = union(s1, s2)
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
      val diff_s = diff(s12, s2)
      assert(contains(diff_s, 1), "Diff 1")
      assert(!contains(diff_s, 2), "Diff 2")
    }
  }

  test("filter can filter by lambda") {
    new TestSets {
      val filtered = filter(s12, (x: Int) => x == 2)
      assert(!contains(filtered, 1), "Diff 1")
      assert(contains(filtered, 2), "Diff 2")
    }
  }

  test("forall") {
    new TestSets {
      assert(forall(s12, (x: Int) => x % 1 == 0), "Forall 1")
      assert(!forall(s12, (x: Int) => x % 2 == 0), "Forall 2")
    }
  }

  test("exists") {
    new TestSets {
      assert(exists(s12, (x: Int) => x % 2 == 0), "Exists 1")
      assert(!exists(s12, (x: Int) => x % 3 == 0), "Exists 2")
    }
  }

  test("map") {
    new TestSets {
      val doubled = map(s12, (x: Int) => x * 2)
      assert(contains(doubled, 1), "Map 1")
      assert(!contains(doubled, 2), "Map 2")
      assert(contains(doubled, 4), "Map 3")
    }
  }

}
