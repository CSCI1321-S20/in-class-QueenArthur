package mud

class Player(private var loc: Room, private var items: List[Item]) {
  def processCommand(command: String): Unit = {
    val com = command.toLowerCase().split(" ")
    com(1) match {
      case "north" | "n" | "south" | "s" | "east" | "e" | "west" | "w" | "up" | "u" | "down" | "d" =>
        move(command)
      case "look" => println(loc.description())
      case "inventory" | "inv" => println(inventoryListing())
      case "get" => addToInventory(loc.getItem(com(2)))
      case "drop" => loc.dropItem(getFromInventory(com(2)))
      case "exit" | "quit" => Main.run = false
      case "help" => help()
    }
  }

  def getFromInventory(itemName: String): Option[Item] = {
    items.find(_.name.toLowerCase == itemName.toLowerCase) match {
      case Some(item) =>
        items = items.filter(_ != item)
        Some(item)
      case None => None
    }
  }

  def addToInventory(item: Item): Unit = items ::= item

  def inventoryListing(): String = items.mkString(", ")

  def move(dir: String): Unit = {
    dir.toLowerCase match {
      case "up" | "u" => loc =???
    }
  }

  def help():Unit=println("""north, south, east, west, up, down - move in the desired direction.
look - reprints the description of the current room
inv/inventory - list the contents of your inventory
get item - get an item from the room and add it to your inventory
drop item - drop an item from your inventory into the room.
exit, quit - leave the game
help - print the available commands and what they do""")
}
