name := "scalaworkshop"

version := "1.0"

scalaVersion := "2.12.2"

libraryDependencies ++= List(
  "org.typelevel" %% "cats" % "0.7.2",
  "org.scalactic" %% "scalactic" % "3.0.1" % "test",
  "org.scalatest" %% "scalatest" % "3.0.1" % "test"
)