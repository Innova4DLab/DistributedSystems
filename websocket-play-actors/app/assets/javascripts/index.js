/*
 * Aquí se escribirá código JavaScript puro, para conectarse al WebSocket
 */

/*
 * Iniciamos la conexión con websocket hacia el servidor
 * Cuando un mensaje es recibido se hace un parsing del JSON
 * Se obtiene el mensaje y se agrega a la vista.
 */
$(function() {
  var ws;
  ws = new WebSocket($("body").data("ws-url")); //Se toma La URL del Tag en Body "ws://localhost:9000/ws"
  ws.onmessage = function(event) {
    var message;
    message = JSON.parse(event.data);
    console.log(message);
    switch (message.type) {
      case "message":
        return $("#board tbody").append("<tr><td class='user'>Usuario#"+ message.uid +" dice:</td><td>"+ message.msg + "</td><td class='timestamp'></td></tr>");
      default:
        return console.log(message);
    }
  };
  /*
   * Cuando se envía un mensaje desde el Cliente al servidor,
   * Se envía el mensaje por WebSocket.
   */
  $("#msgform").submit(function(event) {
    event.preventDefault();
    console.log($("#msgtext").val());
      ws.send(JSON.stringify({
        msg: $("#msgtext").val()
      }));
    return $("#msgtext").val("");
  });

});
