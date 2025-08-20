### FORO HUB

Es el desafío del programa: vamos a replicar a nivel de back end este proceso, y para eso crearemos una API REST usando Spring.

Nuestra API va a centrarse específicamente en los tópicos, y debe permitir a los usuarios:

Crear un nuevo tópico

Mostrar todos los tópicos creados

Mostrar un tópico específico

Actualizar un tópico

Eliminar un tópico

---

Es lo que conocemos comúnmente como CRUD (CREATE, READ, UPDATE, DELETE) y es muy parecido con lo que desarrollamos en el Hotel Alura, pero ahora usando un framework que va a facilitar mucho nuestro trabajo.

Al final de nuestro desarrollo tendremos una API REST con las siguientes funcionalidades

API con rutas implementadas siguiendo las mejores prácticas del modelo REST;

Validaciones realizadas según reglas de negocio;

Implementación de una base de datos para la persistencia de la información;

Servicio de autenticación/autorización para restringir el acceso a la información.

---

Para crear un tópico necesitan las siguientes informaciones:

id
título
mensaje
fecha de creación
status (estado del tópico)
autor
curso

Registro de un nuevo tópico
La API debe contar con un endpoint (punto final) para el registro de tópicos, y debe aceptar solicitudes del tipo POST para la URI /tópicos.

Los datos del tópico (título, mensaje, autor y curso) deben ser enviados en el cuerpo de la solicitud, en formato JSON.

→ No olvides utilizar la anotación @RequestBody para que tu proyecto Spring reciba correctamente los datos del cuerpo de la solicitud.

→ Además, recuerda que el tópico debe ser guardado en la base de datos construida para el proyecto, así que aquí tienes el recordatorio de utilizar el método save del JpaRepository para realizar la persistencia de los datos del tópico creado.

Sugerencia: para ayudar en la validación de los datos, intenta utilizar la anotación Java integrada en Spring @Valid.

Reglas de negocio
Todos los campos son obligatorios, por lo tanto, es necesario verificar si todos los campos se están ingresando correctamente.

La API no debe permitir el registro de tópicos duplicados (con el mismo título y mensaje).

---

Listado de tópicos
La API debe contar con un punto final para el listado de todos los tópicos, y debe aceptar solicitudes del tipo GET para la URI /tópicos.

Los datos de los tópicos (título, mensaje, fecha de creación, estado, autor y curso) deben ser devueltos en el cuerpo de la respuesta, en formato JSON.

→ Recordando que al tratar con el CRUD es necesario trabajar con JpaRepository asociado al tópico, especialmente en la lista de datos de la base de datos utilizamos el método findAll.

Detalle de tópicos
La API debe contar con un endpoint (punto final) para el listado de todos los tópicos, y debe aceptar solicitudes del tipo GET para la URI /tópicos/{id}.

Los datos de los tópicos (título, mensaje, fecha de creación, estado, autor y curso) deben ser devueltos en el cuerpo de la respuesta, en formato JSON.

→ Recuerda utilizar la anotación @‌PathVariable en tu código para recibir el campo de ID de la solicitud GET.

Reglas de negocio
Solicitar el campo ID para realizar la consulta es una acción obligatoria, ya que tu usuario necesita poder visualizar los detalles de un tópico solicitando una consulta a los datos en la base de datos. En este caso, es necesario verificar si el campo ID se ingresó correctamente.

Actualización de tópico
La API debe contar con un endpoint (punto final) para la actualización de los datos de un determinado tópico, y debe aceptar solicitudes del tipo PUT para la URI /tópicos/{id}.

Observación: las mismas reglas de negocio del registro de un tópico deben aplicarse también en su actualización.

Dado que estamos realizando una consulta en la base de datos para luego actualizar un tópico, es necesario solicitar y verificar el campo ID de su solicitud.

En el código del proyecto, sugerimos, al igual que en la tarjeta de Detalle de Tópicos, el uso de la anotación @PathVariable para obtener el ID de la solicitud PUT.

→ Recuerda verificar si el tópico existe en la base de datos para realizar su actualización. En este caso, sugerimos utilizar el método isPresent() de la clase Java llamada Optional.

Eliminación de tópico
La API debe contar con un endpoint para la eliminación de un tópico específico, el cual debe aceptar solicitudes del tipo DELETE para la URI /tópicos/{id}.

Dado que estamos realizando una consulta en la base de datos para luego actualizar un tópico, es necesario solicitar y verificar el campo ID de su solicitud.

En el código del proyecto, sugerimos, al igual que en la tarjeta de Detalle de Tópicos, el uso de la anotación @PathVariable para obtener el ID de la solicitud PUT.

→ Recuerda verificar si el tópico existe en la base de datos antes de realizar su actualización. En este caso, sugerimos el uso del método isPresent() de la clase Java llamada Optional.

Por último, al tratarse de la eliminación de un elemento específico de la base de datos, es importante destacar la importancia del uso del método deleteById del JpaRepository.

Autenticación
A partir de ahora, solo los usuarios autenticados pueden interactuar con la API.

Implementa un mecanismo de autenticación en la API para que los usuarios puedan autenticarse y enviar solicitudes a ella.

→ Recuerda agregar la dependencia "Spring Security" en tu archivo pom.xml (si aún no lo has hecho en la etapa de configuración del entorno Java y Spring).

Configuración de seguridad
Para configurar la autenticación en tu proyecto, es necesario definir tu clase SecurityConfigurations con información para el acceso a través de solicitudes http, utilizando anotaciones como @Configuration y @EnableWebSecurity, así como la clase spring HttpSecurity.

Autenticación en el código Java
El proceso de autenticación en la API se realiza con la implementación de un controller responsable de recibir las solicitudes de inicio de sesión. Asegúrate de utilizar las anotaciones @RestController y @RequestMapping para definir la URL del controller.

Además, utilizamos una clase DTO (en el curso implementada como instancia Record en Java) para recibir los datos de inicio de sesión y contraseña, y luego autenticar al usuario en el método AuthenticationManager presente en la clase SecurityConfigurations.

Base de datos
Para implementar el mecanismo de autenticación en la API, deberás modificar su estructura de base de datos, incluyendo una nueva tabla para almacenar los datos de autenticación de los usuarios.

En este caso, necesitarás crear o modificar la migración referente a los datos de los usuarios. Esta modificación es importante para gestionar los datos de inicio de sesión y contraseña de cada usuario.

→ Recuerda siempre pausar/detener la ejecución del proyecto Spring para modificar las migraciones.

Token JWT
Para agregar mayor seguridad a tu aplicación, una opción muy ventajosa es requerir tokens para autenticación. 
El JWT (JSON Web Token) es un estándar utilizado para compartir información entre cliente y servidor que será muy útil en esta tarea.

→ Para poder utilizar el JWT es necesario agregar su biblioteca en nuestro pom.xml como dependencia. Accede al sitio para obtener la biblioteca en Java de Auth0: JWT.IO

Esta biblioteca es importante precisamente para poder generar el token en el estándar JWT y así agregarlo en la configuración de seguridad de nuestro proyecto, creando una clase DTO UsernamePasswordAuthenticationToken para recibir el nombre de usuario y contraseña.

Generar y validar token
Además, es necesaria la construcción de una clase de servicio, TokenService, para aislar la generación y validación del token.

En la clase, se ha implementado el método "generarToken()", utilizando la biblioteca JWT para crear un token con el algoritmo HMAC256 y una contraseña. También se ha añadido la funcionalidad de configurar la fecha de expiración del token.

Dentro de esta clase, se debe implementar el método "generarToken()" que utiliza la biblioteca JWT para generar el token con el algoritmo HMAC256 y una contraseña secreta. Además, también es importante definir la fecha de expiración del token.

Por último, es necesario inyectar esta clase en tu controlador de autenticación, y así obtener el token retornado en la respuesta de la solicitud de inicio de sesión.

---

Control de acceso
Después de la generación del token JWT, este debe ser utilizado para autenticar la gestión de registros de los tópicos, incluyendo acciones como creación, consulta, actualización o eliminación. La API debe ser configurada para responder con el resultado de cada solicitud, siempre y cuando el token proporcionado sea válido.

Antes de configurar más detalles del control de acceso, es válido agregar una nueva solicitud con una URL y un archivo JSON que contenga el nombre de usuario y contraseña para la generación del token. ¿Qué te parece si la URL es "http://localhost:8080/login"?

→ Destacamos la importancia de almacenar y enviar el token junto con las próximas solicitudes.

En principio, debemos mapear las URLs y validar los tokens en nuestro controlador. Recomendamos crear una clase separada para validar los tokens y llamarla antes de las solicitudes en el controlador para evitar la repetición de código.

→ Reforzamos la necesidad de crear un filter o interceptor en el proyecto para validar el token en cada solicitud.

Ahora, manos a la obra y continúa con esta etapa crucial del proceso de autenticación de nuestro FórumHub. No olvides manejar los errores y los estados de las solicitudes de la API utilizando las excepciones de nuestro querido Java.

---
