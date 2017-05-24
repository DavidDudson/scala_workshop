name := "scalaworkshop"

version := "1.0"

scalaVersion := "2.12.2"

val circeVersion = "0.8.0"
val scalatestVersion = "3.0.1"

libraryDependencies ++= List(
  "org.typelevel" %% "cats" % "0.9.0",
  "org.scalactic" %% "scalactic" % scalatestVersion % "test",
  "org.scalatest" %% "scalatest" % scalatestVersion % "test",
  "io.circe" %% "circe-core" % circeVersion,
  "io.circe" %% "circe-generic" % circeVersion,
  "io.circe" %% "circe-parser" % circeVersion,
  "io.circe" %% "circe-optics" % circeVersion
)

addCompilerPlugin(
  "org.scalamacros" % "paradise" % "2.1.0" cross CrossVersion.full
)