package validation

trait Entity {
  def age: Int
  def name: String
}

trait Human extends Entity {
  def firstName: String

  def lastName: String

  def name: String =
    s"$firstName $lastName"

  def pets: Set[Pet]
}

case class Person(
    age: Int,
    firstName: String,
    lastName: String,
    pets: Set[Pet])
  extends Human

trait Pet extends Entity {
  def sound: String
}

case class Dog(age: Int, name: String) extends Pet {
  val sound: String = "Woof!"
}

case class Werewolf(
    age: Int,
    firstName: String,
    lastName: String,
    pets: Set[Pet])
  extends Human
  with Pet {

  def sound: String = "Woof!"
}

case class Family(humans: Set[Human], pets: Set[Pet]) {
  def members: Set[Entity] = humans ++ pets
}

object Main {
  def main(args: Array[String]): Unit = {

  }
}