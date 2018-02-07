package folding

object FoldAverage {
  def main(args: Array[String]): Unit = {
    val nums = (1 to 100).toList
//    val (sum, count) = nums.foldRight((0, 0))((item: Int, bucket: (Int, Int)) => (bucket._1 + item, bucket._2 + 1))
    val (sum, count) = nums.foldRight((0, 0))((item, bucket) => (bucket._1 + item, bucket._2 + 1))
    println(s"Average is ${sum/count}")
  }

}

object MatchGuard {
  def main(args: Array[String]): Unit = {
    val l = List("fred", "Jim", 99)
    l.foreach({
      case x: Int => println(s"value of x is $x")
      case x: String if x.length > 3 => println(s"It's a long string!")
      case x: String => println(s"It's a string of length ${x.length}")
     })
//    l.foreach(v => v match {
//      case x: Int => println(s"value of x is $x")
//     })
  }
}