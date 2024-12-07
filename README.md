# Thanksgiving API 🦃

Esta es una API RESTful básica, construida con **Spring Boot** para organizar una cena compartida de Acción de Gracias. Los usuarios pueden registrar los platillos que llevarán, ver lo que otros están llevando y gestionar sus aportaciones (crear, actualizar y eliminar).

## Tabla de Contenidos
- [Características](#características)
- [Requisitos Previos](#requisitos-previos)
- [Instalación y Ejecución](#instalación-y-ejecución)
- [Estructura del Proyecto](#estructura-del-proyecto)
- [Uso de la API](#uso-de-la-api)
    - [Endpoints](#endpoints)
    - [Ejemplos de Uso](#ejemplos-de-uso)
- [Base de Datos](#base-de-datos)
- [Documentación](#documentación)
- [Tecnologías Utilizadas](#tecnologías-utilizadas)

---

## Características

- **Registrar platillos**: Añade un nuevo platillo para la cena compartida.
- **Consultar platillos**: Obtén una lista de todos los platillos registrados.
- **Actualizar platillos**: Modifica los detalles de un platillo existente.
- **Eliminar platillos**: Borra un platillo de la lista.
- **Tipos de platillos predefinidos**: Los tipos de plato son:
    - Aperitivo
    - Primer Plato
    - Entremés
    - Segundo Plato
    - Postre

---

## Requisitos Previos

- **Java 17 o superior**
- **Maven**
- **IDE** compatible con Java (IntelliJ IDEA, Eclipse, VS Code, etc.)
- **Postman** para probar la API (Opcional)

---

## Instalación y Ejecución

1. Clona este repositorio:
   ```bash
   git clone https://github.com/MandoDsg/thanksgiving-api
   cd thanksgiving-api
   ```
2. Compila el proyecto con Maven:
   ```bash
   mvn clean install
   ```
3. Ejecuta la aplicación:
    ```bash
    mvn spring-boot:run
4.  La API estará disponible en http://localhost:8080.

---
## Estructura del Proyecto
```bash
📁 thanksgiving-api/
├── 📁 src/main/java/com/example/thanksgivingapi
│   ├── 📁 model         # Clases de modelo (Dish, DishType)
│   ├── 📁 repository    # Repositorios (DishRepository)
│   ├── 📁 service       # Servicios (DishService)
│   ├── 📁 controller    # Controladores (DishController)
├── 📁 src/main/resources
│   ├── 📄 application.properties  # Configuración del proyecto
├── 📄 pom.xml           # Dependencias y configuración del proyecto
└── 📄 README.md         # Documentación del proyecto
```
---
## Uso de la API

### Endpoints

| Método | Endpoint                | Descripción                      |
|--------|-------------------------|----------------------------------|
| GET    | `/api/dishes`           | Obtiene la lista de todos los platillos registrados. |
| POST   | `/api/dishes`           | Crea un nuevo platillo.          |
| PUT    | `/api/dishes/{id}`      | Actualiza un platillo existente. |
| DELETE | `/api/dishes/{id}`      | Elimina un platillo por su ID.   |

---

### Ejemplos de Uso

#### Crear un Nuevo Platillo

- **Método:** `POST`
- **URL:** `http://localhost:8080/api/dishes`
- **Cuerpo de la Solicitud:**
```json
{
"dishName": "Enchiladas verdes",
"dishType": "PRIMER_PLATO",
"cookName": "Angel"
}
```
- **Respuesta:**
```json
{
  "id": 1,
  "dishName": "Enchiladas verdes",
  "dishType": "PRIMER_PLATO",
  "cookName": "Angel"
}
```
### Obtener Todos los Platillos

- **Método:** `GET`
- **URL:** `http://localhost:8080/api/dishes`
- **Respuesta:**
```json
[
  {
    "id": 1,
    "dishName": "Enchiladas verdes",
    "dishType": "PRIMER_PLATO",
    "cookName": "Angel"
  },
  {
    "id": 2,
    "dishName": "Pay de limón",
    "dishType": "POSTRE",
    "cookName": "Ale"
  }
]
```
### Actualizar un Platillo

- **Método:** `PUT`
- **URL:** `http://localhost:8080/api/dishes/1`
- **Cuerpo de la Solicitud:**
```json
{
  "dishName": "Pechuga empanizada",
  "dishType": "PRIMER_PLATO",
  "cookName": "Angel"
}
```
- **Respuesta:**
```json
{
  "id": 1,
  "dishName": "Pechuga empanizada",
  "dishType": "PRIMER_PLATO",
  "cookName": "Angel"
}
```
### Eliminar un Platillo

- **Método:** `DELETE`
- **URL:** `http://localhost:8080/api/dishes/1`
- **Respuesta:** Código de estado 204 No Content.

---

## Base de Datos
La API utiliza una base de datos en memoria H2 para almacenar los platillos.
### Consola H2
- **URL:** `http://localhost:8080/h2-console`
- **Credenciales:**
  - *JDBC URL:* `jdbc:h2:mem:thanksgiving`
  - *Usuario:* `sa`
  - *Contraseña:* `password`

---

## Documentación
La API está documentada automáticamente usando Swagger/OpenAPI. Puedes acceder a la documentación interactiva en:
- **Swagger UI:** `http://localhost:8080/swagger-ui.html`

## Tecnologías Utilizadas

- Java 17
- Spring Boot
- Spring Data JPA
- H2 Database
- Springdoc OpenAPI
- Maven