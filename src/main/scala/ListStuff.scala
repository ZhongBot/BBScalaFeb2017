import scala.annotation.tailrec

object ListStuff {
  @tailrec
  def showNames(l: List[String]): Unit = {
    if (!l.isEmpty) {
      val h = l.head
      val t = l.tail
      println(s"> $h")
      showNames(t)
    }
  }

  // NOT tail recursive :(
  def addUpBad(l: List[Int]): Int = {
    if (!l.isEmpty) {
      l.head + addUpBad(l.tail)
    } else 0
  }

  def addUp(l: List[Int]): Int = {
    @tailrec
    def addWithAccumulator(l: List[Int], soFar: Int): Int = {
      if (!l.isEmpty) {
        val h = l.head
        val t = l.tail
        addWithAccumulator(t, h + soFar)
      } else soFar
    }
    addWithAccumulator(l, 0)
  }

  def maxOf(l: List[Int]): Int = {
    if (!l.isEmpty) {
      val h = l.head
      val t = l.tail
      math.max(h, maxOf(t))
    } else 0
  }

  def main(args: Array[String]): Unit = {
    val names = List("Fred", "Jim", "Sheila")
    showNames(names)
    val nums = (1 to 10).toList
    println(s"Sum of 1 to 10 is ${addUp(nums)}")
    println(s"max of 1 to 10 is ${maxOf(nums)}")
    val moreNums = List(9, 2, 44, 18, 16, 3, 19)
    println(s"max of 1 to 10 is ${maxOf(moreNums)}")
  }
}
