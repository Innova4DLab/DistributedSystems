# meteor-tutorial

**Meteor** es una plataforma muy completa para desarrollar aplicaciones móviles y Web únicamente utilizando Javascript. Algunas características de **Meteor**:

- **Interfaz de usuario moderna**
  - Contruye aplicaciones de alta calidad, como Facebook ó Twitter.
- **Mucho menos código**
  - Gracias a su modelo reactivo, desarolla en pocas líneas lo que tomaría mucho más tiempo.
- **Un lenguaje en todas partes**
  - El mismo lenguaje se utiliza para el **cliente** como para el **servidor**.
- **Actualizaciones en tiempo real**
  - Los usuarios pueden observar como cambian los datos instantánemente y colaborar sin interrupciones.
- **Altamente responsivo**
  - El código en JavaScript se adapta a cualquier plataforma.

En esta actividad desarrollarás una pequeña lista reactiva de "cosas por hacer", en **Meteor** y **MongoDB**.

<img src="https://lh5.ggpht.com/le2ArsDkxTHo1-Do6hnohzlZbvJHuQ3m_K4PbIFpyM3mHps8Ypil2vXKEON-Xqg6Mw=w520" width="50%" height="50%"/>

# Contenido
- **[Antes de comenzar](#antesde)**
- [Herramientas sugeridas](#herramientas)
- [Instalación](#instalacion)
- **[Actividad 1 - Tutorial](#tutorial)**
- **[Actividad 2 - Preguntas](#preguntas)**

# Antes de comenzar

### <a name="herramientas"></a>Herramientas sugeridas:
- **Eclipse**, **IntelliJ** u otro editor como <a href="https://atom.io/">(Atom)</a>.
- Conocimientos de **Javascript**.

### <a name="instalacion"></a>Instalación:

Meteor soporta OS X, Linux y Windows, para instalar Meteor sigue las siguientes instrucciones.

 - **Windows**: Descarga el instalador oficial [aquí](https://install.meteor.com/windows).

 - **OS X** or **Linux**: Instalar desde la terminal:

```bash
curl https://install.meteor.com/ | sh
```

Ahora que has instalado **Meteor**, el siguiente tutorial te enseñará a elaborar una simple aplicación colaborativa, utilizando las caráctisticas reactivas de **Meteor**

# <a name="tutorial"></a>Actividad 1 - Tutorial

En **Meteor** es muy fácil crear un proyecto nuevo, basta con ir a la terminal y escribir:

```bash
meteor create simple-todos
```

Esto creará una nueva carpeta llamada simple-todos con todos los archivos que la aplicación de **Meteor** necesita para una básica ejecución:

```bash
simple-todos.js       # Un archivo javascript donde escribiremos código del cliente y servidor
simple-todos.html     # Un documento HTML donde se definen templates.
simple-todos.css      # Un archivo CSS para editar el estilo.
.meteor               # Archivos internos de meteor.
```

Para ejecutar la aplicación simplemente escribe en la terminal:

```bash
cd simple-todos
meteor
```

Abre el navegador de tu preferencia y ve a la siguiente dirección: **http://localhost:3000**

### Creando vistas como templates:

Para comenzar a trabajar con la lista de tareas ahora deberás cambiar el código generado automáticamente por el siguiente:

```html
<!-- todo-list.html -->
<head>
  <title>Lista de tareas</title>
</head>

<body>
  <div class="container">
    <header>
      <h1>Lista de tareas</h1>
    </header>

    <ul>
      {{#each tasks}}
        {{> task}}
      {{/each}}
    </ul>
  </div>
</body>

<template name="task">
  <li>{{text}}</li>
</template>
```

**Meteor** define vistas a través de **templates**, como puedes observar el template reproduce cada línea para cada tarea.

```javascript
// todo-list.js
if (Meteor.isClient) {
  // Este código se ejecuta únicamente en el cliente
  Template.body.helpers({
    tasks: [
      { text: "Tarea 1" },
      { text: "Tarea 2" },
      { text: "Tarea 3" }
    ]
  });
}
```
El código **javascript** se ejecuta en el **cliente**, por ahora únicamente agregaremos manualmente un par de tareas.

### Conectando con la base de datos

**Meteor** utiliza colecciones de **MongoDB** para almacenar un conjunto de datos. **MongoDB** un sistema de base de datos NoSQL orientado a documentos. **MongoDB** guarda estructuras de datos en documentos tipo **JSON** con un esquema dinámico, por lo que es muy amigable con aplicaciones **javascript**.

Ahora modifiquemos el código javascript para crear una colección en MongoDB y agregar tareas a nuestra lista, por ahora esto no funcionará, debemos trabajar con la base de datos.

```javascript
// simple-todos.js
Tasks = new Mongo.Collection("tasks");

if (Meteor.isClient) {
  // Este código se ejecuta únicamente en el cliente
  Template.body.helpers({
    tasks: function () {
      return Tasks.find({});
    }
  });
}
```

En **Mongo DB** los elementos dentro de una colección se llaman documentos. Abre una nueva terminal para comenzar a utilizar la base de datos y crear algunos documentos que podremos visualizar en la lista.

```bash
meteor mongo
```

```bash
db.tasks.insert({ text: "Hello world!", createdAt: new Date() });
```
Abre tu navegador en **localhost:3000** y podrás observar como se ha creado una nueva entrada en la lista de manera automática.

### Agregando elementos mediante un formulario

```javascript
<header>
  <h1>Lista de tareas</h1>

  <!-- Agregar un formulario después de H1 -->
  <form class="new-task">
    <input type="text" name="text" placeholder="Escribir para agregar nuevas tareas" />
  </form>
</header>
```

```javascript
// Dentro de el bloque if (Meteor.isClient) después de Template.body.helpers:
Template.body.events({
  "submit .new-task": function (event) {
    // Esta función será llamada despues de agregar un nuevo elemento

    var text = event.target.text.value;

    Tasks.insert({
      text: text,
      createdAt: new Date() // current time
    });

    // Clear form
    event.target.text.value = "";

    // Prevenir que se envíe por default
    return false;
  }
});
```
Listo, la aplicación con **Meteor** está casi terminada, ahora deberás editar el código CSS para que la aplicación se vea de la siguiente manera:

<img src="http://cl.ly/image/2F3i2g1d0R0y/screen.png" width="60%" height="60%"/>

#### Seleccionando y quitando tareas

Hasta ahora nuestra aplicación agrega tareas, ahora vamos a aprender a eliminarlas, para esto en el template deberás agregar algunos nuevos elementos:

```javascript
<!-- reemplazar el template actual por el siguiente -->
<template name="task">
  <li class="{{#if checked}}checked{{/if}}">
    <button class="delete">&times;</button>

    <input type="checkbox" checked="{{checked}}" class="toggle-checked" />

    <span class="text">{{text}}</span>
  </li>
</template>
```
El código ahora es visible en la interfaz pero no hace nada, para esto deberás agregar el comportamiento correspondiente dentro del archivo javascript.

```javascript
// En el código del cliente, debajo de todo lo demás.
Template.task.events({
  "click .toggle-checked": function () {
    Tasks.update(this._id, {$set: {checked: ! this.checked}});
  },
  "click .delete": function () {
    Tasks.remove(this._id);
  }
});
```
Ahora tienes una **aplicación Web** completa, la aplicación terminada debería verse de la siguiente manera:

<img src="http://cl.ly/image/030r010Q3x3C/appfinished.png" width="60%" height="60%" />

# <a name="preguntas"></a>Actividad 2 - Preguntas

Responder ampliamente a las siguientes preguntas en el reporte, tomando en cuenta todas las actividades realizadas en este repositorio:

 - ¿Qué es un aplicación reactiva?
 - ¿Qué es **MongoDB**?
 - Explica el uso de los templates.
 - Describe ampliamente la conexión "automática" entre **Meteor** y **MongoDB**.
 - ¿Qué tendrías que hacer para desarrollar la aplicación en **Play Framework**?
 - Explica cómo se realiza el registro de nuevas tareas en **MongoDB**.
 - Explica cómo se realiza la eliminación de tareas en **Meteor** con **MongoDB**.
 - ¿En qué otras aplicaciones podrías utilizar **Meteor**?

**Notas:** Explica ampliamente y justifica tus respuestas.

**Cualquier comentario o duda, discutir en la sección de [issues](https://github.com/Innova4DLab/meteor-tutorial/issues).**
