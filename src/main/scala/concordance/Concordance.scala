package concordance

import java.io.IOException
import java.util.regex.Pattern

import scala.io.Source

object Concordance {
  val WORD_BREAK = Pattern.compile(raw"\W+")

  def main(args: Array[String]): Unit = {
    try {
      val x = Source.fromFile("PrideAndPrejudice.txt")
        .getLines()
        .map(_.toLowerCase)
        .flatMap(WORD_BREAK.split(_))
        .filter(s => s.length > 0)
        .toList
        .groupBy(w => w)
        .mapValues(l => l.size)
        .toList
        .sortBy(p => -p._2)
        .take(200)
        .map(p => f"${p._1}%20s : ${p._2}%5d")
        .foreach(println)

    } catch {
      case ioe: IOException => println(s"Got a problem ${ioe.getMessage}")
    }
  }
}
