package actors

import akka.actor.Actor
import akka.actor.ActorLogging
import akka.event.LoggingReceive
import play.api.libs.json.JsValue
import play.api.libs.json.Json
import akka.actor.ActorRef
import akka.actor.Props
import scala.xml.Utility
import java.util.Calendar
import java.text.SimpleDateFormat

/*
* Esta clase define un actor.
* UserActor funciona como una puerta de enlace entre los actores conectados al "board" y el websocket.
* Este actor envía mensajes a BoardActor.scala
*/
class UserActor(uid: String, board: ActorRef, out: ActorRef) extends Actor with ActorLogging {

  /*
  * Antes que otra cosa pase el actor se suscribe a BoardActor
  */
  override def preStart() = {
    /*
    *
    * Código de la Práctica
    *
    */
  }

  /*
  * Los actores reciben mensajes
  * Cuando este actor recibe un mensaje, se crea un JSON.
  */
  def receive = LoggingReceive {
    /*
    *
    * Código de la Práctica
    *
    */
  }
}
/*
* Definición del objeto UserActor
* Recibe el id y envía a BoardActor
*/
object UserActor {
  /*
  *
  * Código de la Práctica
  *
  */
}
