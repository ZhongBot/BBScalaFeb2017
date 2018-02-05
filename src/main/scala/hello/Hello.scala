package hello

object Hello {
  def main(args: Array[String]): Unit = {
    println("Hello Scala world!")
    val car1 = new Car("Red", "Fred", 3)
    println(car1)

    val x:Int = 12
    val l = 123456789012L
    val f:Float = 1.23F

    val s = "\u1234Hello"

    val ml =
      """
         |Hello, this
         |is a multi line String
         |""".stripMargin
    println("--------------------")
    println(ml)
    println("--------------------")

    val form = f"The float value is ${f}%7.3f"
    println(form)
    val r = raw"hello, this is not an escape \n so should be on the same lne"
    println(r)

    val onetoten = 1 to 100 by 10
    val onetonine = 1 until 10
    println(onetoten)
    println(onetonine)
    println("-------------------------------")

    for ( x <- onetonine ) println(x)

    val bval = {
      val one = 1
      val two = 2
      one + two
    }

    println(bval)

    val somenum = if (bval > 2) 7 else 44
    println(if (bval > 2) 7 else 44)

    println(s"Car1 is $car1")

//    val car1plus = car1.addPassenger(3)
//    val car1plus = car1 addPassenger 3
    val car1plus = car1.addPassenger{3}
    Console println s"Car1 is $car1"
    println(s"Car1plus is $car1plus")

  }
}

class Car(val color: String, val driver: String, val passengerCount: Int) {
//  val myColor = color
//  val myDriver = driver
//  val myPassengerCount = passengerCount

  def addPassenger(num: Int):Car =
    new Car(color, driver, passengerCount + num)

  override def toString =
    s"Car of color $color driven by ${driver} with $passengerCount passenger"
}




//package hello {
//
//  class Hello {
//
//    import scala.io.StdIn
//  }
//
//}
//
//package goodbye {
//
//  class Goodbye {
//
//  }
//
//}