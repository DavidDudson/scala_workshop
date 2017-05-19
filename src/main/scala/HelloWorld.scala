
object HelloWorld {
  def main(args: Array[String]): Unit = {
    println("Hello, world!")
  }
}

object HelloWorldApp extends App {
  println("Hello, world!")
}

object HelloWordStringExamples extends App {
  val hello: String = "Hello"

  println(hello + ", world")

  println(s"$hello, world")

  println("""
      | Hello,
      | world!""".stripMargin)

  println(s"""
      | $hello,
      | world!""".stripMargin)

  println(raw"""This entire "string" is escaped \n!""")
}