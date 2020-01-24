package mud

class Room(
    val name: String,
    val desc: String,
    private var items: List[Item],
    private val exits: Array[Int]
) {

  def description(): String = desc;
  def getExit(dir: Int): Option[Room] = rooms(exits(dir))
  def getItem(itemName: String): Option[Item] = {
    items.find(_.name.toLowerCase == itemName.toLowerCase) match {
      case Some(item) =>
        items = items.filter(_ != item) //deletes all coppies of that item
        Some(item)
      case None => None
    }
  }
  def dropItem(item: Item): Unit = items ::= item //items= item::items

}

object Room {
  val rooms = readRooms()
  def readRooms(): Array[Room] = {
    val source = scala.io.Source.fromFile("world.txt")
    val lines = source.getLines()
    val r = Array.fill(lines.next.toInt)(readRoom(lines))
    source.close()
    r
  }

  def readRoom(lines: Iterator[String]): Room = {
    var l = lines.next()
    var text = ""
    while (l != "%" && lines.hasNext) {
      text += l
      l = lines.next()
    }
    try {
      val arr = text.split("@")
      val name = arr(0)
      val desc = arr(1)
      val exits = arr(2).split(", ")
      val items = arr(3).split(", ")
    } catch { throw new Exception("Invalid spacing in room file") }
  }
}
