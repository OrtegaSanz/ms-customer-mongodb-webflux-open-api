# API de Customers con MongoDB

Aplicación Spring Boot reactiva para consultar y administrar customers mediante una API REST.

## Requisitos

- Java 17.
- IntelliJ IDEA.
- MongoDB en ejecución y accesible en `mongodb://localhost:27017`.
- Apache Maven **3.6.3 o superior**. Este proyecto usa Spring Boot 3.2.11, por lo que Maven 3.1.0 no es compatible.

## Configuración de MongoDB

La aplicación usa por defecto la base de datos `bootcampbd`. La conexión y el puerto están definidos en `src/main/resources/application.properties`:

```properties
server.port=8085
spring.data.mongodb.uri=mongodb://localhost:27017
spring.data.mongodb.database=bootcampbd
```

Inicia MongoDB antes de ejecutar la aplicación. La base de datos y la colección se crearán al guardar el primer customer. Si quieres cargar los datos de ejemplo incluidos en `bootcampbd.customer.json`, puedes importarlos desde la raíz del proyecto con MongoDB Database Tools:

```bash
mongoimport --uri="mongodb://localhost:27017/bootcampbd" --collection=customer --jsonArray --file=bootcampbd.customer.json
```

## Ejecutar desde IntelliJ IDEA

1. Abre IntelliJ IDEA y selecciona **File > Open**. Elige el archivo `pom.xml` de este proyecto y ábrelo como proyecto.
2. Cuando IDEA pregunte, selecciona **Open as Project** y espera a que Maven descargue las dependencias.
3. En **File > Project Structure**, configura el **Project SDK** como Java 17.
4. En **Settings > Build, Execution, Deployment > Build Tools > Maven**, selecciona una instalación de Maven 3.6.3 o superior (o el Maven incluido en IDEA si cumple esa versión).
5. Comprueba que MongoDB está iniciado y escucha en `localhost:27017`.
6. Abre `src/main/java/com/demo/example/mscustomerdummy/MsCustomerDummyApplication.java` y pulsa el icono **Run** junto al método `main` (o haz clic derecho en el archivo y selecciona **Run 'MsCustomerDummyApplication'**).
7. La aplicación estará disponible en `http://localhost:8085`.

## API

La interfaz interactiva de Swagger está disponible en:

- `http://localhost:8085/swagger-ui/index.html`

Endpoints principales:

| Método | Ruta | Operación |
|---|---|---|
| `GET` | `/api/customers` | Lista los customers |
| `GET` | `/api/customers/{id}` | Busca un customer por ID |
| `POST` | `/api/customers` | Crea un customer |
| `PUT` | `/api/customers/{id}` | Actualiza un customer |
| `DELETE` | `/api/customers/{id}` | Elimina un customer |

Los datos de creación y actualización usan los campos `nombre`, `apellido`, `correo` y `dni`.
