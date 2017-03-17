# Java RMI Sesión 2 (serialización y acceso múltiple al servidor)
>Java RMI (Remote Method Invocation), es una tecnología desarrollada por Java para invocar métodos remotos. Proporciona un mecanismo simple para la comunicación de servidores y clientes en aplicaciones distribuidas basadas en Java.
>La construcción de una aplicación distribuída con RMI incluye:  
- 1. Serialización (**Marshalling**) de parámetros y objetos en Java en el cliente para enviar al servidor.
- 2. Invocación desde el cliente, del **Método Remoto**  (RMI)  a ejecutar en el servidor.
- 3. Serialización (**Marshalling**) en el servidor para enviar respuesta al **Cliente**.
- 4. Recepción de la respuesta por parte del **Cliente** y ejecución local.  

La segunda sesión de RMI consiste en:
 - comprender mejor el Marshalling (Serialización de objetos) con RMI, y
 - probar el acceso al servidor desde múltiples clientes 
 **es muy importante** haber concluído la primera actividad antes de continuar.

# Contenido
- **[Antes de comenzar](#antesde)**
- [Herramientas sugeridas](#herramientas)
- [Instalación en IntelliJ IDEA](#instalacion)
- **[Actividad 1 - Análisis](#analisis)**
- **[Actividad 2 - Desarrollo](#desarrollo)**
- **[Actividad 3 - Prueba del servidor con múltiples clientes](#pruebas)**
- **[Actividad 4 - Limpieza](#limpieza)**
- **[Actividad 5 - Preguntas](#preguntas)**

#### <a name="herramientas"></a>Herramientas sugeridas:
- IntelliJ IDEA
- Java 1.6 ó superior.
- Conocimientos intermedios de Programación Orientada a Objetos.

#### <a name="instalacion"></a>Instalación en IntelliJ IDEA:
1. Clonar el repositorio.
2. Crear en Intellij Idea un nuevo proyecto (File>New>Project from existing Sources) a partir de la carpeta RMI-2.

# <a name="analisis"></a>Actividad 1 - Análisis  

El presente repositorio contiene un proyecto que **simula la administración de la pista aérea de un Aeropuerto por una torre de control**. Los aviones, ó autos de servicio (**Clientes**) se suscriben a la torre de control (**Servidor**) que contiene un mapa de pista **[Matríz 4x8 Objetos]** en donde los vehículos se desplazan cada "x" segundos; cada vehículo (aéreo o terrestre) informa a la torre de control hacia a dónde se ha desplazado, la torre de control actualiza su **mapa de pista**, el **cliente interfaz de usuario** imprime cada segundo el **mapa aéreo** en la consola.

- Ejecutar **Server**: Click derecho sobre el proyecto, "**Run As** > **Java Application**".
- Ejecutar **Client**: Click derecho sobre el proyecto, "**Run As** > **Java Application**".
- Analizar el diagrama que muestra la arquitectura de la aplicación distribuída:
<img src="rmi2.png" width="75%" height="75%"/>

- Observar el comportamiento de la aplicación.
- Analizar la clase **RemoteInterface.java** y **ControlTower.java**.
- Analizar las clases **Avion.java** y **Auto.java**
- Explicar en el **reporte** la funcionalidad de la interfaz y cómo se implementa en el servidor.
- Explicar en el **reporte** el método **moverAvion(Avion a, int c)** que se encuentra en **ControlTower.java**
- Analizar el Cliente **ClientLauncher.java**.
- Explicar la funcionalidad del método **main**.
- Explicar los métodos **guiClient()** y **avionClient()**.

Nota: Inicialmente en la consola debería imprimirse un resultado de la siguiente forma:
<img src="t1.png" width="50%" height="50%"/>


# <a name="desarrollo"></a>Actividad 2 - Desarrollo

En ésta actividad deberás modificar el **Proyecto** de Java que se te ha entregado. Como habrás analizado las clases **Avion** y **Auto** son objetos que se agregan a una **matríz 4x8** que repesenta una pista aérea, los métodos en el **servidor** permiten informar el desplazamiento de estos vehículos en la **matríz**. Los objetos son creados en el **cliente** y envíados al **servidor** en donde se actualiza su ubicación. El objetivo de ésta actividad es **definir** e **implementar** la lógica de dos nuevos objetos en el **servidor**, que se crearán, enviarán y controlarán desde el **Cliente**.


- Implementar 2 nuevas clases de vehículos (e.g, UFO, Boeing), para agregarlos a la pista (Matríz 4x8).
- Implementar los **2 nuevos objetos** en los **2 últimos carriles** disponibles de la matríz.
- Implementar en el servidor la lógica necesaria para las nuevas clases.
- Implementar en el cliente los vehículos, deben ejecutarse en su propio hilo cada "x" segundos.
- Documentar las nuevas clases agregadas y los nuevos métodos implementados.
- Utilizar las guías de JavaDocs.
- Es importante analizar el código, revisar atentamente el diagrama de clases, podría ser útil.

Nota: La consola debería imprimir algo así:

<img src="t2.png" width="50%" height="50%"/>

# <a name="pruebas"></a>Actividad 3 - Prueba del servidor con múltiples clientes

A fin de simular un entorno real deberás ejecutar el servidor (Torre de control) y 4 clientes (Auto, Avión, UFO, Boeing) en máquinas independientes. Para lograr que la conexión entre cada cliente y el servidor sea exitosa deberas conectar todas las máquinas en una misma red (LAN).

1. Ejecutar la clase ServerLauncher en una máquina.

2. Obtener la dirección IP de la máquina que ejecute el servidor.
	- Mac OSX y Linux
		- 1.- Abrir una terminal de comandos presionando (CMD + Espacio), escribir "terminal" y presionar enter.
		- 2.- Escribir el comando ifconfig.
		<img src="Macosx-ifconfig.png" width="75%" height="75%"/>
		
	- Windows
		- 1.- Abrir una consola de comandos presionando (Windows + R), escribir "cmd" y presionar enter.
		- 2.- Escribir el comando ipconfig.
		<img src="Windows-ipconfig.png" width="75%" height="75%"/>
		
3. Agregar los dos casos (case) faltantes correspondientes a los dos nuevos vehículos (UFO, Boeing) dentro de la estructura "Switch" que esta en la clase ClientLauncher.java (Línea 23). 

4. Ejecutar ClientLauncher en 4 máquinas distintas con los siguientes parámetros.
   - Máquina 1: \<Ip Servidor> 1
   - Máquina 2: \<Ip Servidor> 2
   - Máquina 3: \<Ip Servidor> 3
   - Máquina 4: \<Ip Servidor> 4
   
Nota: En Intellij Idea se pueden agregar parámetros de ejecución de la siguiente manera:
- Menu Run > Edit Configuration
<img src="IDE-EditConfig.png" width="75%" height="75%"/>

- Escribir los argumentos en "Program arguments"
<img src="IDE-Param-Ejecution.png" width="75%" height="75%"/> 

Al iniciar la ejecución de todos los clientes podrás ver que en el cliente 3 (Interfaz Gráfica) se actualiza cada vehículo hasta acabar con su recorrido. 

#### Solucionar problemas de conectividad

Para evitar problemas de conectividad hacia el servidor, en el momento de hacer la prueba con múltiples clientes,  es necesario primero desactivar el Firewall del sistema. Para ello puedes seguir los siguientes pasos:

- Escribir "firewall" en el menu inicio y elegir la opción "Comprobar estado del firewall"

<img src="SFirewall.png" width="50%" height="50%"/> 

- Presionar sobre "Activar o desactivar Firewall de Windows"

<img src="SFirewall2.png" width="50%" height="50%"/> 

- Desactivar el firewall para redes privadas

<img src="DisableFirewall.png" width="50%" height="50%"/> 

#### Crear un punto de acceso Inalámbrico en Android

Para realizar la prueba con múltiples clientes en una red local, es posible habilitar un punto de acceso inalámbrico (AP-Access Point) en nuestro dispositivo Android, para lo cual debemos abrir el menú de ajustes y fijarnos en el apartado de “conexiones inalámbricas y redes”.

<img src="images/AndroidAP1.png" width="50%" height="50%"/> 

Pulsaremos sobre el botón “Más…” para acceder a otra lista de opciones y veremos en nuestra pantalla el siguiente menú:

<img src="images/AndroidAP2.png" width="50%" height="50%"/> 

Aquí debemos pulsar sobre “Anclaje a red y zona Wi-Fi para acceder a la pantalla de configuración del punto de acceso inalámbrico.

<img src="images/AndroidAP3.png" width="50%" height="50%"/> 

Lo primero que vamos a hacer es configurar una contraseña para nuestra nueva red inalámbrica, para ello pulsaremos sobre la entrada “Configurar zona Wi-Fi”.

En el apartado del SSID pondremos el nombre con el que queremos identificar nuestra red, por ejemplo, "AndroidAP". En seguridad configuramos el tipo de seguridad que vamos a establecer, por ejemplo, WPA2_PSK (la más segura) y para finalizar en el apartado de contraseña escribiremos la clave de acceso con la que protegeremos nuestro punto de acceso. Una vez configurado el AP, la pantalla quedará similar a la siguiente:

<img src="images/AndroidAP4.png" width="50%" height="50%"/> 

Pulsaremos sobre “Guardar” y los cambios se guardarán en nuestro dispositivo. Ya tenemos el punto de acceso configurado, lo único que nos falta es habilitar la entrada “Zona Wi-Fi portátil” y esperar unos segundos a que la conexión se habilite. Una vez listo nos aparecerá una notificación como la siguiente y podremos ver la red Wi-Fi desde cualquier otro dispositivo que soporte red inalámbrica.

<img src="images/AndroidAP5.png" width="50%" height="50%"/> 

#### Crear un punto de acceso Inalámbrico en IOS

Para habilitar un punto de acceso inalámbrico en nuestro dispositivo IOS debemos ir a la pantalla de ajustes.

<img src="images/IOSAP1.png" width="40%" height="40%"/>

Elegir compartir internet:

<img src="images/IOSAP2.png" width="40%" height="40%"/>

Activar compartir internet:

<img src="images/IOSAP3.png" width="40%" height="40%"/>

Si aparece esta pantalla, elegir Activar WI-FI y Bluetooth. 
Si no aparece esta pantalla, ir al paso siguiente.

<img src="images/IOSAP4.png" width="40%" height="40%"/>

Presionar sobre "Contraseña Wi-Fi".

<img src="images/IOSAP5.png" width="40%" height="40%"/>

Establecer la contraseña del nuevo punto de acceso inalámbrico.
Elegir OK.

<img src="images/IOSAP6.png" width="40%" height="40%"/>

Al finalizar todos los pasos habrá una nueva red inalámbrica disponible para ser accedida desde cualquier dispositivo que tenga soporte de redes inalámbricas. 

# <a name="limpieza"></a>Actividad 4 - Limpieza

Ahora deberás limpiar el código, permitirá comprender de mejor manera la estructura del RMI.

- Identifica las clases **Client** y **Server**.
- Agrega la documentación a las clases con tu **nombre**, **correo** y **ID**.
- Agrega la documentación a las **variables** y **métodos** de cada **Interfaz/Clase**.
Nota:  La documentación debe ser siguiendo las guías de [Javadocs](http://en.wikipedia.org/wiki/Javadoc)

# <a name="preguntas"></a>Actividad 5 - Preguntas

En el reporte de ésta práctica, además de mostrar y explicar el desarrollo de las activiadaes deberás responder a las siguientes preguntas:

- ¿Cómo se definen nuevas clases para usarlas con **Server**?
- ¿Cuáles son los pasos necesarios para crear una nueva clase y utilizar el objeto en el Servidor?
- ¿Cuál es la utilidad de **Interface**?
- ¿Cuál es la utilidad de **Constant.java**?
- ¿Cuáles objeto(s) son Remotos? (Un objeto remoto es aquel cuyos métodos pueden ser invocados desde otra máquina virtual)
- ¿Cuáles objeto(s) son no-Remotos? (Un objeto no-remoto es aquel que es copiado via serialización o instanciado en la máquina virtual en la que va a ser utilizado)
- ¿Cómo se manejan los errores en el Servidor?
- ¿Cuál es la utilidad de la clase **RemoteException**?
- ¿Por qué es necesario utilizar **Serializable** en las nuevas clases?
- Dada la comunicación entre **Client** y **Server**
  - ¿Por qué es necesario que el método avionClient() y los objetos **RemoteInterface** y **Avion** sean de tipo **final**?
- ¿Por qué es necesario un método **getAvion(String id, int c)**?
- ¿Cómo se manejan los errores en el Cliente?
- ¿Qué significa y cuál es la utilidad de **NotBoundException**?

Notas:
- Explica ampliamente y justifica tus respuestas.
- La documentación debe ser siguiendo las guías de [Javadocs](http://en.wikipedia.org/wiki/Javadoc)


**Cualquier comentario o duda, discutir en la sección de [issues](https://github.com/Innova4DLab/RMI-2/issues).**
