
# Book AI Analyst - Backend API

El backend de Book AI Analyst es una API RESTful construida con Spring Boot y Java 21. Su propósito es servir como puente de comunicación (Backend for Frontend) para buscar libros gratuitos a través de la API pública de Open Library, y gestionar el análisis semántico de palabras mediante la integración con un webhook de n8n impulsado por agentes de Inteligencia Artificial.

## Getting Started

Estas instrucciones te proporcionarán una copia del proyecto backend funcionando en tu máquina local para propósitos de desarrollo y pruebas. Consulta la sección de despliegue para obtener notas sobre cómo implementar el proyecto en un sistema en vivo.

### Prerequisites

¿Qué cosas necesitas para instalar el software y cómo instalarlas?

- **Java Development Kit (JDK) 21**: Necesario para compilar y ejecutar la aplicación. Descargar JDK 21
- **Apache Maven 3.8+**: Gestor de dependencias y empaquetado. Descargar Maven
- **n8n (Cloud o Local)**: Una instancia activa con el webhook de análisis literario configurado.

### Installing

Una serie de ejemplos paso a paso que te indican cómo obtener un entorno de desarrollo en ejecución.

1. **Clonar el repositorio y navegar al directorio del backend:**
   Abre tu terminal y ubícate en la carpeta del backend.
   ```bash
   cd book-ai-app/backend
   ```

2. **Configurar las variables de entorno:**
   Abre el archivo `src/main/resources/application.yml` y actualiza la URL del webhook de n8n con tu instancia de producción:
   ```yaml
   n8n:
     webhook:
       url: https://tu-instancia.app.n8n.cloud/webhook/analyze-word
   ```

3. **Compilar el proyecto e instalar dependencias:**
   Ejecuta el ciclo de limpieza e instalación de Maven.
   ```bash
   mvn clean install
   ```

4. **Ejecutar la aplicación Spring Boot:**
   Inicia el servidor Tomcat embebido.
   ```bash
   mvn spring-boot:run
   ```

La aplicación debería iniciarse en `http://localhost:8080`.

### Ejemplo de uso del sistema (Demo):

Para extraer datos del sistema y comprobar que funciona, puedes realizar una petición GET a la búsqueda de libros:
```bash
curl -X GET "http://localhost:8080/api/books/search?q=cien+años"
```

Respuesta esperada: Una lista en formato JSON con los metadatos de los libros encontrados en Open Library.

## Running the tests

Explica cómo ejecutar las pruebas automatizadas para este sistema. Para ejecutar la suite completa de pruebas:
```bash
mvn test
```

### Break down into end-to-end tests

Estas pruebas verifican que los endpoints expuestos (Controladores) respondan correctamente a las peticiones HTTP y realicen las validaciones requeridas de los DTOs.

Por ejemplo, probar que una petición de análisis sin el campo "palabra" devuelve un error de validación 400 Bad Request:
```java
// Ejemplo conceptual de prueba
mockMvc.perform(post("/api/analysis/word-context")
       .contentType(MediaType.APPLICATION_JSON)
       .content("{\"libro\":\"Moby Dick\", \"parrafo\":\"...\"}"))
       .andExpect(status().isBadRequest());
```

### And coding style tests

Para mantener la consistencia del código y asegurar un estándar de calidad, puedes agregar plugins como Checkstyle o SonarLint al ciclo de vida de Maven.
```bash
mvn checkstyle:check
```

## Deployment

Agrega notas adicionales sobre cómo implementar esto en un sistema en vivo.

**Despliegue en Azure App Service:**

1. En el portal de Azure, crea un nuevo recurso Web App (App Service).
2. Selecciona Java 21 como el Runtime Stack y Java SE (Embedded Web Server).
3. En la sección Environment variables (Configuración), añade la variable requerida por tu código:
   `N8N_WEBHOOK_URL = https://tu-instancia.app.n8n.cloud/webhook/analyze-word`
4. Despliega el archivo `.jar` generado en la carpeta `target/` usando Azure CLI:
   ```bash
   mvn clean package
   az webapp deploy --resource-group TuGrupo --name TuApp --src-path target/backend-0.0.1-SNAPSHOT.jar
   ```

## Built With

- **Spring Boot 3.2.x** - El framework web utilizado
- **Maven** - Gestión de dependencias
- **Spring Cloud OpenFeign** - Cliente REST declarativo para conexión con Open Library y n8n
- **Java 21** - Lenguaje de programación

## Contributing

Por favor, lee `CONTRIBUTING.md` para obtener detalles sobre nuestro código de conducta y el proceso para enviarnos solicitudes de extracción (pull requests).

## Versioning

Usamos SemVer para el versionado. Para las versiones disponibles, mira las etiquetas en este repositorio.

## Authors

- **Arquitecto / Tech Lead** - *Trabajo inicial* - Book AI Analyst

Mira también la lista de contribuyentes que participaron en este proyecto.

## License

Este proyecto está licenciado bajo la Licencia MIT - mira el archivo `LICENSE.md` para detalles.

## Acknowledgments

- A la API de Open Library por proveer un extenso catálogo literario de código abierto.
- A n8n por su excelente plataforma de automatización de flujos de trabajo basada en nodos.
- Inspiración tomada de las nuevas formas de aplicar la IA generativa al aprendizaje y comprensión de lectura.
