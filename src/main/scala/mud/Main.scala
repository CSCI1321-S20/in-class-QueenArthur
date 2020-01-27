package mud

object Main {
  def main(args: Array[String]): Unit = {
    //launch readRooms
    val play = new Player(Library, Nil)
    var run = true
    while(run){
      play.processCommand(readLine("command: "))
    }
  }
}
