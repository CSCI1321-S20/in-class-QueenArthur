package actors

import akka.actor.Actor
import scalafx.scene.image.WritableImage

class CrystalManager(img: WritableImage) extends Actor {
  for (_ <- 1 to 20) {
    context.actorOf(Props[FloatyBit])
  }
  for (child <- context.children) {
    child ! floatyBit.Move(400, 0)
  }

  import CrystalManger._
  def receieve = {
    case TestMove(x, y) =>
        if(x < 0 || x >= img.width.value || y)
    case m => println("Unhandled message in CrystalManager: " + m)
  }
}

object CrystalManager {
    case class TestMove(x: Int, y: Int)
}
