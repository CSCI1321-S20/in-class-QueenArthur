package networking

import akka.actor.Actor
import java.net.Socket
import java.io.BufferedReader
import java.io.PrintStream
import akka.actor.Props

class User(name: String, sock: Socket, in: BufferedReader, out: PrintStream)
    extends Actor {
  def receive = {
case CheckInput =>
    if(in.ready){
        val input = in.readLine()
    }
        case m => println("Unhandled message in User: " + m)
  }

}

object User {
    case object CheckInput
}