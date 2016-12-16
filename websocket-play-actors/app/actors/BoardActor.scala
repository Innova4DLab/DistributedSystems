package actors

import akka.actor.Actor
import akka.actor.ActorLogging
import akka.event.LoggingReceive
import akka.actor.ActorRef
import akka.actor.Terminated
import play.libs.Akka
import akka.actor.Props

class BoardActor extends Actor with ActorLogging {
  /* Variable que contiene un Set con todas las referencias a los usuarios */
  var users = Set[ActorRef]()

  /*
   *
   * Código de la Práctica
   *
   */
}

object BoardActor {
  /*
   *
   * Código de la Práctica
   *
   */
}

case class Message(uuid: String, s: String)
object Subscribe
