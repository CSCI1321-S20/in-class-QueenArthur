package networking

import akka.actor.Actor
import akka.actor.Props

class ChatManager extends Actor{
    import ChatManager._
  def receive = {
    case NewUser(name, sock, in, out) =>
        context.actorOf(Props(new User(name, sock, in , out)))
    case CheckAllInputs =>
        for(child<- context.children) child ! User.CheckInput
    case m => println("Unhandled message in ChatManager: " + m)
  }
}