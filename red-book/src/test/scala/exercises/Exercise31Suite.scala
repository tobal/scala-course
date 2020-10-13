//package exercises
//
//import org.scalatest.freespec.AnyFreeSpecLike
//import org.scalatest.matchers.should.Matchers
//import org.scalatest.Inside
//
//
//class Exercise31Suite extends AnyFreeSpecLike with Matchers with Inside {
//  "Cons Nil pattern match" in {
//    val x = ExcList(1, 2, 3, 4, 5) match {
//      case ExcCons(x, ExcCons(2, ExcCons(4, _))) => x
//      case ExcNil => 42
//      case ExcCons(x, ExcCons(y, ExcCons(3, ExcCons(4, _)))) => x + y
//      case ExcCons(h, t) => h + sum(t)
//      case _ => 101
//    }
//    x shouldBe 3
//  }
//}

