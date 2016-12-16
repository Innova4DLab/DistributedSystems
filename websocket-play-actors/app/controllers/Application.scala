package controllers

import scala.Left
import scala.Right
import scala.concurrent.Future
import scala.util.Random
import actors.UserActor
import play.api.Logger
import play.api.Play.current
import play.api.libs.json.JsValue
import play.api.mvc.Action
import play.api.mvc.Controller
import play.api.mvc.WebSocket

object Application extends Controller {
  val UID = "uid"
  var counter = 0

  /*
  * El método index, se ejecuta automáticamente al cargar localhost:9000.
  * <Checar en Routes>
  * GET     /    controllers.Application.index
  */
  def index = Action { implicit request => {
    /*
    *
    * Código de la Práctica
    *
    */
  }
}

/*
* Método WebSocket, el método implementa un websocket que recibe dos valores,
* en caso de que la petición (En algún momento futuro) sea exitosa, se solicita el Id
* único de la sesión del usuario, en caso que no exista un ID, el servicio se prohíbe.
* En caso que el ID exista se llama al método UserActor.props definido dentro de la carpeta
* actores.
*/
def ws = WebSocket.tryAcceptWithActor[JsValue, JsValue] { implicit request =>
  /*
  *
  * Código de la Práctica
  *
  */
}

}
