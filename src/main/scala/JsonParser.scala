
import io.circe._
import io.circe.generic.auto._
import io.circe.parser._
import io.circe.syntax._
import io.circe.optics.JsonPath._
import cats._
import cats.implicits._

import scala.io.{BufferedSource, Source}

import java.io.File
import java.io.PrintWriter

object JsonParser {

  def writeToFile(p: String, s: String): Unit = {
    val pw = new PrintWriter(new File(p))
    try pw.write(s) finally pw.close()
  }

  def main(args: Array[String]): Unit = {
    val source: BufferedSource = Source.fromFile("new_york_names.json")
    val text: String = try source.mkString finally source.close()
    val jsonDocument: Either[ParsingFailure, Json] = parse(text)

    if (jsonDocument.isLeft) {
      println(jsonDocument.left.get)
      return
    }

    // Prints first person
    val allPeople = jsonDocument.toOption
      .flatMap(d => root.data.arr.getOption(d))
      .map(a => a.flatMap(root.arr.getOption(_).toVector))
      .map(a => a.flatMap(NameData(_).toVector))

    writeToFile("new_york_modified.json", allPeople.asJson.toString)
  }
}

case class NameData(name: String, birthYear: String, ethnicity: String, count: String, isMale: Boolean)

object NameData {
  def apply(data: Vector[Json]): Option[NameData] = {
    val strOption = root.string.getOption _
    (strOption(data(8)), strOption(data(9)), strOption(data(10)), strOption(data(11)), strOption(data(12)))
        .map5((year, gender, name, ethnicity, count) =>
          NameData(name, year, ethnicity, count, gender == "MALE"))
  }
}
