package listops

class Car private(val color: String, val fuel: Double, val passengers: List[String]) {
  def this(c: String) {
    this(c, 0, List())
  }

  override def toString: String = s"Car: color=$color, fuel=$fuel, passengers: ${passengers.mkString(", ")}"
}

object Car {
  def apply(color: String, fuel: Double, passengers: String*): Car = {
    new Car(color, fuel, List(passengers: _*))
  }
}

object CarTest {
  def main(args: Array[String]): Unit = {
    val fleet = List(
      new Car("Blue"),
      Car("Red", 3.8, "Fred", "Jim"),
      Car("White", 1.8, "Alan", "Jane"),
      Car("Green", 7.8, "Susan", "Helen", "Sharon", "Felicity"),
      Car("Red", 4.8, "Tina", "Toby", "Trevor")
    )

    println("All: --------------------")
    fleet
      .foreach(println)
    println("Red: --------------------")
    fleet
      .filter(_.color == "Red")
      .foreach(println)
    println("Colors: --------------------")
    fleet
      .map(_.color)
      .foreach(println)
    println("Lots of fuel: --------------------")
    fleet
      .filter(_.fuel > 4)
      .foreach(println)
    println("All passengers: --------------------")
    fleet
      .flatMap(_.passengers)
      .foreach(println)
    println("Passengers in well-fueled cars: --------------------")
    fleet
      .filter(_.fuel > 4)
      .flatMap(_.passengers)
      .foreach(println)
    println("Passengers in colored cars: --------------------")
    fleet
      .flatMap(c => c.passengers.map(s => s"$s is a passenger in a ${c.color} car"))
      .foreach(println)
    println("Again passengers in colored cars: --------------------")
    fleet
      .flatMap(c => c.passengers.map(s => (s, c.color)))
      .map(p => s"${p._1} is a passenger in a ${p._2} car")
      .foreach(println)
  }
}