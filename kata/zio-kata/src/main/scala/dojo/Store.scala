package dojo
import zio.{Has, ZIO, ZLayer}

object Store {
  type Store = Has[Service]

  trait Service {
    def get(key: String): ZIO[Any, Nothing, Option[Int]]
  }

  def get(key: String): ZIO[Store, Nothing, Option[Int]] =
    ZIO.accessM[Store](_.get.get(key))

  val Live: ZLayer[Any, Nothing, Store] = ZLayer.succeed(new Service {
    override def get(key: String): ZIO[Any, Nothing, Option[Int]] = ZIO.none
  })
}
