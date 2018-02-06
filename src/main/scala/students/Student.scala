package students

object Student {
  def getSmartnessPredicate(threshold: Double): Student => Boolean = s => s.gpa > threshold

  def not(op: Student => Boolean) : Student => Boolean = s => !op(s)

  def filter(l: List[Student], predicate: Student => Boolean) : List[Student] = l match {
    case List() => List()
    case h :: t => if (predicate(h)) h :: filter(t, predicate) else filter(t, predicate)
  }
}

class Student(val name: String, val gpa: Double) {
  override def toString: String = s"Student $name $gpa"
}

object School {

  def showAll(l:List[Student]): Unit = {
    for (s <- l) println(s)
    println("-----------------------")
  }

  def main(args: Array[String]): Unit = {
    val school = List(
      new Student("Fred", 3.4),
      new Student("Jim", 2.8),
      new Student("Sheila", 3.8)
    )
    showAll(school)
    showAll(Student.filter(school, Student.getSmartnessPredicate(3.5)))
    showAll(Student.filter(school, Student.not(Student.getSmartnessPredicate(3.5))))

  }
}
