package percents {

  object Implicits {

    class RichPercents(val s: String) {
      def %%%%(x: Int): String = {
        s"$s joined with number $x"
      }
    }

    implicit def toRichPercents(s: String): RichPercents = {
      println("making rich wrapper")
      new RichPercents(s)
    }

    implicit def intToString(x: Int): String = {
      println("converting int to String")
      s"This is a string made from the number $x"
    }

    implicit class PercentWrapper(val s: String) {
      def %%%%(other: String): String = {
        println("Doing implicit conversions")
        s + " joined with " + other
      }
    }

  }

}

object implicitstuff {

  def hasDefault(x: Int = 123, y: Int = 246): Unit = {
    println(s"hasDefault called with x = $x and y = $y")
  }

  def doStuffWithArgs(implicit x: String): Unit = {
    println(x)
  }

  def doStuffWithAString(s: String): Unit = {
    println(s"The string is $s")
  }

  def main(args: Array[String]): Unit = {
    //    import percents.Implicits.PercentWrapper
    val v = new percents.Implicits.PercentWrapper("Fred") %%%% "Jones"
    //    println(v)

    //    import percents.Implicits.intToString
    //    doStuffWithAString(99)

    //    import percents.Implicits.toRichPercents
    //    println("Freddy " %%%% 3)

    implicit val s = "Surprise!"
    doStuffWithArgs
    doStuffWithArgs("freddy")

    hasDefault()
    hasDefault(99)
    hasDefault(y=99)
  }
}
