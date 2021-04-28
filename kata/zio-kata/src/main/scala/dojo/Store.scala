package dojo
import zio.{Has, Ref, ZIO, ZLayer}

object Store {
  type Store = Has[Service]

  trait Service {
    def get(key: String): ZIO[Any, Nothing, Option[Int]]
    def set(key: String, value: Int): ZIO[Any, Nothing, Unit]
  }

  def get(key: String): ZIO[Store, Nothing, Option[Int]] =
    ZIO.accessM[Store](_.get.get(key))

  def set(key: String, value: Int): ZIO[Store, Nothing, Unit] =
    ZIO.accessM[Store](_.get.set(key, value))

  val live: ZLayer[Any, Nothing, Store] = ZLayer.fromEffect(for {
    ref <- Ref.make[Option[Int]](None)
  } yield new Service {
    override def get(key: String): ZIO[Any, Nothing, Option[Int]] = ref.get
    override def set(key: String, value: Int): ZIO[Any, Nothing, Unit] = ref.set(Some(value))
  })
}
