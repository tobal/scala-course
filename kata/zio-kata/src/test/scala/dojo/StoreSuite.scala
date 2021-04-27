package dojo

import dojo.Store.Store
import org.scalatest.Inside
import org.scalatest.freespec.AnyFreeSpecLike
import org.scalatest.matchers.should.Matchers
import zio.ZIO
import zio.Runtime

class StoreSuite extends AnyFreeSpecLike with Matchers with Inside {
  "should return None if key doesn't exist" in {
    val prog: ZIO[Store, Nothing, Option[Int]] = Store.get("notExists")
    val provided: ZIO[Any, Nothing, Option[Int]] = prog.provideLayer(Store.Live)
    val default = Runtime.default
    default.unsafeRun(provided) shouldBe None
  }
}
