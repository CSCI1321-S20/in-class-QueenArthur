package actors

import akka.actor.Actor
import scalafx.scene.image.WritableImage
import akka.actor.Props

class FloatyBit extends Actor {
  import FloatyBit._
  def receieve = {
    case Move(x, y) =>
      var dx = util.Random.nextInt(3) - 1
      var dy = util.Random.nextInt(2)
      while (dx == 0 && dy == 0) {
        dx = util.Random.nextInt(3) - 1
        dy = util.Random.nextInt(2)

      }
      sender ! CrystalManager.TestMove(x + dx, y + dy)
    case m => println("Unhandled message in FloatyBit: " + m)

  }
}

object FloatyBit {
  case class Move(x: Int, y: Int)
}
