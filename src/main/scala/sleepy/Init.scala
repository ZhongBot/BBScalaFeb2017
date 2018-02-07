package sleepy

object Init {
  def timeConsuming = {
    Thread.sleep(1000)
    println("... thinking...")
    Thread.sleep(1000)
    println("... you're not going to like this ...")
    "42"
  }

  lazy val answer = timeConsuming

  def main(args: Array[String]): Unit = {
    if (math.random() > 0.5) {
      println(s"Answer is $answer")
    } else {
      println("not interested")
    }
  }
}

object Infinite {
  def evens(start: Int): Stream[Int] = {
    start #:: evens(start + 2)
  }

  def main(args: Array[String]): Unit = {
    evens(0)
      .take(100)
      .foreach(println)
  }
}

object Primes {
  def sieve(in: Stream[Long]): Stream[Long] = {
    val h = in.head
    h #:: sieve(in.tail.filter(x => x % h != 0))
  }

  val primes = sieve(Stream.iterate(2L)(_ + 1))

  def main(args: Array[String]): Unit = {
    val start = System.nanoTime
    primes take 100 foreach println
    println("-------------------")
    primes drop 4999 take 1 foreach println
    val time = System.nanoTime - start
    println(f"time for 5000 prime computation is ${time / 1000000000.0}%6.3f")

//    val start2 = System.nanoTime
//    primes(5000);
//    val time2 = System.nanoTime - start
//    println(f"time to get to prime#5000 second time through is ${time2 / 1000000000.0}%6.3f")

  }
}

object ByName {
  def doStuff(x : => Long) : Unit = {
    println(s"x is $x")
    Thread.sleep(10)
    println(s"x is $x")
  }

  def main(args: Array[String]): Unit = {
    doStuff( System.nanoTime() )
  }
}

object ByName2 {
  def repeat(x: Int)(y: => Unit): Unit = {
    if (x > 0) {
      y
      repeat(x - 1)(y)
    }
  }

  def main(args: Array[String]): Unit = {
    var x = 0;
    repeat(3){
      println(s"Hello! $x")
      x = x + 1
    }
  }
}








