name := "scala-exercises"
version := "1.0"

val testDependencies = Seq(
    "org.scalatest" %% "scalatest" % "3.1.1" % "test",
    "org.scalacheck" %% "scalacheck" % "1.14.3" % "test"
)

libraryDependencies ++= testDependencies
libraryDependencies += "dev.zio" %% "zio" % "1.0.0-RC18-2"
