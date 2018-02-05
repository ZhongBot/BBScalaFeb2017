package dates

import scala.annotation.tailrec

object Date {
  def dayOfWeek(d:Int, m:Int, y:Int): String = {
    val modifiedMonth = if (m < 3) m + 12 else m
    val modifiedYear= if (m < 3) y - 1 else y
    val dow = (d
      + (13 * (modifiedMonth + 1)/ 5)
      + modifiedYear
      + (modifiedYear / 4)
      - (modifiedYear / 100)
      + (modifiedYear / 400)) % 7
    if (dow == 0) "Saturday"
    else if (dow == 1) "Sunday"
    else if (dow == 2) "Monday"
    else if (dow == 3) "Tuesday"
    else if (dow == 4) "Wednesday"
    else if (dow == 5) "Thursday"
    else  "Friday"
  }

  def isLeap(y: Int): Boolean =
    (y % 4 == 0 && !(y % 100 == 0) || (y % 400 == 0))

  def daysInMonth(m: Int, y: Int): Int =
    if (m == 9 || m == 4 || m == 6 || m == 11) 30
    else if (m == 2) {if (isLeap(y)) 29 else 28}
    else 31

  def main(args: Array[String]): Unit = {
    println(s"5 Feb 2018 is a ${dayOfWeek(5, 2, 2018)}")
    println(s"1 Mar 2016 is a ${dayOfWeek(1, 3, 2016)}")
    println(new Date(5, 2, 2018))

    println(s"isLeap(2016) ? ${isLeap(2016)}")
    println(s"daysInMonth(2, 2016) ${daysInMonth(2, 2016)}")
    println(s"1 Jan 2016 + 31 is ${new Date(1, 2, 2016) + 31}")
    println(s"1 Feb 2016 + 29 is ${new Date(1, 2, 2016) + 29}")
    println(s"1 Mar 2016 + 31 is ${new Date(1, 3, 2016) + 31}")
    println(s"1 Apr 2016 + 30 is ${new Date(1, 4, 2016) + 30}")
    println(s"1 May 2016 + 31 is ${new Date(1, 5, 2016) + 31}")
    println(s"1 June 2016 + 30 is ${new Date(1, 6, 2016) + 30}")
    println(s"1 July 2016 + 31 is ${new Date(1, 7, 2016) + 30}")
    println(s"1 August 2016 + 31 is ${new Date(1, 8, 2016) + 31}")
    println(s"1 September 2016 + 30 is ${new Date(1, 9, 2016) + 30}")
    println(s"1 October 2016 + 31 is ${new Date(1, 10, 2016) + 31}")
    println(s"1 November 2016 + 30 is ${new Date(1, 11, 2016) + 30}")
    println(s"1 December 2016 + 31 is ${new Date(1, 12, 2016) + 31}")
    println(s"10 Feb 2016 + 366 is ${new Date(10, 2, 2016) + 366}")
    println(s"10 Feb 2017 + 365 is ${new Date(10, 2, 2017) + 365}")
    println(s"10 Feb 1900 + 365 is ${new Date(10, 2, 1900) + 365}")
    println(s"10 Feb 2000 + 366 is ${new Date(10, 2, 2000) + 366}")
  }
}

class Date(val day: Int, month: Int, year: Int) {
  @tailrec
  final def + (days: Int): Date = {
    val newDayTentative = this.day + days
    val daysThisMonth = Date.daysInMonth(this.month, this.year)
    if (newDayTentative <= daysThisMonth) new Date(newDayTentative, this.month, this.year)
    else {
      val offsetToNextMonth = daysThisMonth - this.day
      val remainingOffset = days - offsetToNextMonth
      val offsetMonth = if (this.month == 12) 1 else this.month + 1
      val offsetYear = if (this.month == 12) this.year + 1 else this.year
      new Date(1, offsetMonth, offsetYear) + (remainingOffset - 1)
    }
  }
  override def toString: String = s"${Date.dayOfWeek(day,month,year)} d: ${day} m: ${month} y: ${year}"
}
