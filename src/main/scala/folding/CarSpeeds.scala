package folding

object CarSpeeds {
  def main(args: Array[String]): Unit = {
    val cars = List(70, 85, 72, 68, 71, 60, 100, 120)
    cars.foldLeft(List[(Int, Int)]())
//    { (bucket, item) => { (bucket, item) match
      {
        case ((gs, gc)::otherGroups, nextCarSpeed) if nextCarSpeed > gs => (gs, gc + 1) :: otherGroups
        case (groups, nextCarSpeed) => (nextCarSpeed, 1) :: groups
//    }}
    }.foreach(println)
  }
}
