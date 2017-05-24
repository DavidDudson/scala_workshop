
import io.circe._
import io.circe.generic.auto._
import io.circe.parser._
import io.circe.syntax._
import io.circe.optics.JsonPath._
import cats._
import cats.implicits._

import scala.io.{BufferedSource, Source}

object JsonParser {

  def toNameData(data: Vector[Json]): Option[NameData] = {
    val strOption = root.string.getOption _
    (strOption(data(8)), strOption(data(9)), strOption(data(10)), strOption(data(11)), strOption(data(12)))
      .map5((year, gender, name, ethnicity, count) =>
        NameData(name, year, ethnicity, count, gender == "MALE"))
  }

  def main(args: Array[String]): Unit = {
    val source: BufferedSource = Source.fromFile("new_york_names.json")
    val lines: String = try source.mkString finally source.close()
    val jsonDocument: Either[ParsingFailure, Json] = parse(lines)

    if (jsonDocument.isLeft) {
      println(jsonDocument.left.get)
      return
    }

    // Prints first person
    jsonDocument.toOption
      .flatMap(d => root.data.index(0).arr.getOption(d))
      .map(toNameData)
      .foreach(println)
  }
}

case class NameData(name: String, birthYear: String, ethnicity: String, count: String, isMale: Boolean)
