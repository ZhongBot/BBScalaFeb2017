package students

object Student {
  def getSmartnessPredicate(threshold: Double): Student => Boolean = s => s.gpa > threshold

  def not(op: Student => Boolean) : Student => Boolean = s => !op(s)

  def and(op1: Student => Boolean, op2: Student => Boolean) : Student => Boolean = s => op1(s) && op2(s)

  def or(op1: Student => Boolean, op2: Student => Boolean) : Student => Boolean = s => op1(s) || op2(s)

  def filter[T](l: List[T], predicate: T => Boolean) : List[T] = l match {
    case List() => List()
    case h :: t => if (predicate(h)) h :: filter(t, predicate) else filter(t, predicate)
  }

  def map[T,U](l: List[T], op: T => U): List[U] = l match {
    case List() => List()
    case h :: t => op(h) :: map(t, op)
  }

  def foreach[T](l: List[T], op: T => Unit): Unit = l match {
    case List() =>
    case h :: t => op(h) ; foreach(t, op)
  }

  def flatMap[T,U](l: List[T], op: T => List[U]): List[U] = l match {
    case List() => List()
    case h :: t => op(h) ::: flatMap(t, op)
  }
}

class Student(val name: String, val gpa: Double) {
  override def toString: String = s"Student $name $gpa"
}

object School {

  def showAll(l:List[Student]): Unit = {
    Student.foreach(l, (s: Student) => println(s))
    println("-----------------------")
  }

  def marketing(s : Student): List[Student] = s.name match {
    case "Fred" => List(new Student("Fred", 3.4), new Student("Jill", 0.0))
    case "Jim" => List(new Student("Jim", 3.4), new Student("Tony", 0.0), new Student("William", 0.0))
    case "Sheila" => List()
  }

  def main(args: Array[String]): Unit = {
    val school = List(
      new Student("Fred", 3.4),
      new Student("Jim", 2.8),
      new Student("Sheila", 3.8)
    )
    school.foreach(println)
    println("---------------------")
    school.filter(Student.getSmartnessPredicate(3.5)).foreach(println)
    println("---------------------")
    school.filter(Student.not(Student.getSmartnessPredicate(3.5))).foreach(println)
    println("---------------------")
//    showAll(school)
//    showAll(Student.filter(school, Student.getSmartnessPredicate(3.5)))
//    showAll(Student.filter(school, Student.not(Student.getSmartnessPredicate(3.5))))

    val smartish = Student.getSmartnessPredicate(3)
    val verySmart = Student.getSmartnessPredicate((3.7))
    val notOverSmart = Student.not(verySmart)
    val midRangeSmart = Student.and(smartish, notOverSmart)
    school.filter(midRangeSmart).foreach(println)
    println("---------------------")
//    showAll(Student.filter(school, midRangeSmart))

    school.flatMap(marketing).foreach(println)
    println("---------------------")
    school.map(_.gpa).foreach(println)
//    school.map(s => s.gpa).foreach(println)
    println("---------------------")
//    showAll(Student.flatMap(school, marketing))
//    Student.foreach(Student.map(school, (s:Student) => s.gpa), println)
  }
}
