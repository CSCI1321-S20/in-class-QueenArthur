package mud

class Player(private loc: Room, private items: Array[Items]) {
  def processCommand(command: String): Unit = {
    command.head.toLowerCase match {
      case north | n | south | s | east | e | west | w | up | u | down | d =>
        move(command)
      case look => println(loc.description())
      case inventory | inv => println(inventoryListing())
      case get => addToInventory(room.getItem(command.tail.toLowerCase))
      case drop => room.dropItem(getFromInventory(comand.tail.toLowerCase  ))
      case exit | quit => ???
      case help => help()
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

  def help():Unit=println(""north, south, east, west, up, down - move in the desired direction.
look - reprints the description of the current room
inv/inventory - list the contents of your inventory
get item - get an item from the room and add it to your inventory
drop item - drop an item from your inventory into the room.
exit, quit - leave the game
help - print the available commands and what they do"")
  }
}
