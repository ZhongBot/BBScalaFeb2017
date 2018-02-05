package hello.hello

object HasAFactory {
  def apply(a: Int *): Array[HasAFactory] = {
    for (x <- a) println(s"got an arg $x")
  }
//  def apply(a: Int, b: Int, c: Int): Array[HasAFactory] =
//    Array[HasAFactory](new HasAFactory(a), new HasAFactory(b), new HasAFactory(c))
}

class HasAFactory(val x: Int) {
  override def toString: String = s"HasAFactory $x"
}

object Many {
  def main(args: Array[String]): Unit = {
    val text : Array[String] = new Array[String](4);
    text(0) = "Hello"
    text(1) = "World"
    println(text)

    val moreText = Array("Un", "Deux")
    println(moreText)

    val haf = new HasAFactory(99)
    println(haf)

    val several = HasAFactory(1, 9, 99)
//    for (h <- several) println(h)

  }
}
