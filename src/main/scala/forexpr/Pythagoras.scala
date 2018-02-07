package forexpr

object Pythagoras {
  def main(args: Array[String]): Unit = {
    (for {
      o <- 1 to 30
      a <- 1 to o
      h <- 1 to 40
      if o * o + a * a == h * h
    } yield (o, a, h)) foreach println

  }
}

object BigNumbers {
  def main(args: Array[String]): Unit = {
    val start = System.nanoTime

    val values = for {
      twoCols <- 0 to 99 by 2
      colThree <- 0 to 900 by 100
      threeCols = twoCols + colThree
      if threeCols % 3 == 0

      colFour <- 0 to 9000 by 1000
      fourCols = threeCols + colFour
      if fourCols % 4 == 0

      colFive <- 0 to 90000 by 10000
      fiveCols = fourCols + colFive
      if fiveCols % 5 == 0

      colSix <- 0 to 900000 by 100000
      sixCols = fiveCols + colSix
      if sixCols % 6 == 0

      colSeven <- 0 to 9000000 by 1000000
      sevenCols = sixCols + colSeven
      if sevenCols % 7 == 0

      colEight <- 0 to 90000000 by 10000000
      eightCols = sevenCols + colEight
      if eightCols % 8 == 0

      colNine <- 0 to 900000000 by 100000000
      nineCols = eightCols + colNine
      if nineCols % 9 == 0
    } yield nineCols
    val time = System.nanoTime - start
    values.sorted(Ordering.Int)
      .foreach(println)
    println(f"number of values is ${values.size}, compute time ${time / 1000000000.0}%6.3f seconds")
  }
}