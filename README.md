# centroplus-connect

Aplicación de gestión para un centro académico y deportivo: usuarios, actividades, reservas e incidencias. Proyecto intermodular de 1º DAM.

## Estructura del repositorio

- `backend-api/` → API REST con Spring Boot
- `mobile-app/` → aplicación de escritorio/móvil con JavaFX
- `database/` → script SQL, datos de ejemplo y diagrama ER

## Tecnologías

- Java 17
- Spring Boot (Web + Data JPA)
- SQLite
- JavaFX 21
- Maven

## Backend (API REST)

Para arrancarlo:

```
cd backend-api
./mvnw spring-boot:run
```

Se levanta en `http://localhost:8080` y usa la base de datos `database/centroplus.db`.

### Endpoints

| Método | Ruta | Qué hace |
|--------|------|----------|
| GET | /api/v1/incidencias | Lista todas las incidencias |
| GET | /api/v1/incidencias/{id} | Devuelve una incidencia |
| POST | /api/v1/incidencias | Crea una incidencia |
| DELETE | /api/v1/incidencias/{id} | Borra una incidencia |
| GET | /api/v1/actividades | Lista todas las actividades |
| GET | /api/v1/actividades/{id} | Devuelve una actividad |
| POST | /api/v1/actividades | Crea una actividad |
| DELETE | /api/v1/actividades/{id} | Borra una actividad |

Los GET se pueden probar desde el navegador y el resto con Postman. Ejemplo de cuerpo para crear una incidencia:

```json
{
    "usuario": { "id": 1 },
    "asunto": "Falta material en la sala",
    "descripcion": "El proyector de la sala 3 no funciona",
    "fecha": "2026-06-11",
    "estado": "ABIERTA"
}
```

Usuarios y reservas están en la base de datos y como entidades del backend, pero no les hice endpoints por falta de tiempo.

## App móvil (JavaFX)

Para arrancarla:

```
cd mobile-app
./mvnw javafx:run
```

Es una aplicación independiente del backend, cada parte funciona por separado. Tiene dos pantallas con una barra de navegación abajo:

- **Actividades**: lista las actividades con sus plazas libres y permite reservar plaza. Valida que haya una actividad seleccionada y que queden plazas.
- **Incidencias**: formulario para crear incidencias (asunto y descripción) y lista de las creadas. Valida que los campos no estén vacíos.

Los datos de la app van en memoria.

## Base de datos

En `database/` están:

- `schema.sql` → crea las 4 tablas (usuarios, actividades, reservas, incidencias)
- `seed.sql` → datos de ejemplo
- `centroplus.db` → la base SQLite ya creada
- `diagrama-er.png` y `diagrama-er.drawio` → el diagrama entidad-relación

Para regenerar la base desde cero:

```
cd database
sqlite3 centroplus.db < schema.sql
sqlite3 centroplus.db < seed.sql
```

## Decisiones

- Usé **SQLite** en el backend porque es la base de datos que trabajamos en clase y así los datos persisten entre arranques.
- La app móvil **no se conecta al backend por HTTP**: cada parte funciona de manera independiente.
- La API sigue una estructura por capas básica: controller → service → repository, con rutas versionadas tipo `/api/v1`.
- La interfaz de la app está hecha en código, sin FXML.
