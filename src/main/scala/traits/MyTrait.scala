package traits

trait MyTrait {
  def doStuff:Unit = println("hello, I'm a trait method")
  def anAbstractMethod:String
}

trait MyOtherTrait {
  val v = 99;
  def doMore:Unit = println(s"v is $v")
}

class T1 extends MyTrait with MyOtherTrait {
  def doOtherStuff:Unit = println("Hello, I'm a class member")

  override def anAbstractMethod: String = "This is the concrete implementation"

  override def doStuff: Unit = {
    println("class dostuff")
    super.doStuff
  }
}

object TryIt {
  def main(args: Array[String]): Unit = {
    val x = new T1
    x.doOtherStuff
    x.doStuff
    println(x.anAbstractMethod)
    x.doMore
    val y = new MyTrait {
      override def anAbstractMethod: String = "Anonymous trait implementation"
    }
    println(y.anAbstractMethod)
    y.doStuff
  }
}