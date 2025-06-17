# 📦 Proyecto Amaristest - API de Autenticación y Registro de Login

Este proyecto es una API REST que permite autenticar un usuario contra el servicio de DummyJSON usando `Feign Client`, registrar el login en una base de datos PostgreSQL y exponer un endpoint para consultar los datos del usuario autenticado.

---

## 🚀 Instrucciones de Ejecución

1. **Clonar el repositorio**

```bash
git clone https://github.com/Estebanvg120/amaristest.git
cd amaristest
```

2. **Configurar base de datos PostgreSQL**

Asegúrate de tener una instancia de PostgreSQL corriendo y crea una base de datos:

```sql
CREATE DATABASE amaristest;
```

3. \*\*Editar archivo \*\*`** o **`

Configura tus credenciales de base de datos:

```yaml
spring:
  datasource:
    url: jdbc:postgresql://localhost:5432/amaristest
    username: tu_usuario
    password: tu_contraseña
```

4. **Construir el proyecto**

```bash
./gradlew clean build
```

5. **Ejecutar el proyecto**

```bash
./gradlew bootRun
```

La API se levantará en: `http://localhost:8080`

---

## 👤 Usuario y Contraseña de Prueba

Puedes usar las siguientes credenciales de prueba (DummyJSON):

```json
{
   "username":"emilys",
   "password":"emilyspass"
}
```

---

## 🔐 Ejemplo `curl` para Login

```bash
curl -X POST http://localhost:8080/api/login/auth \
  -H "Content-Type: application/json" \
  -d '{"username": "emilys", "password": "emilyspass"}'
```

Respuesta esperada:

```json
{
   "accessToken": "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJpZCI6MSwidXNlcm5hbWUiOiJlbWlseXMiLCJlbWFpbCI6ImVtaWx5LmpvaG5zb25AeC5kdW1teWpzb24uY29tIiwiZmlyc3ROYW1lIjoiRW1pbHkiLCJsYXN0TmFtZSI6IkpvaG5zb24iLCJnZW5kZXIiOiJmZW1hbGUiLCJpbWFnZSI6Imh0dHBzOi8vZHVtbXlqc29uLmNvbS9pY29uL2VtaWx5cy8xMjgiLCJpYXQiOjE3NTAxMzc2NDcsImV4cCI6MTc1MDE0MTI0N30.OYfo7-LsTu7PlI2gZFaIUN0rFSTmECVt7ajIJaHxPsE",
   "refreshToken": "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJpZCI6MSwidXNlcm5hbWUiOiJlbWlseXMiLCJlbWFpbCI6ImVtaWx5LmpvaG5zb25AeC5kdW1teWpzb24uY29tIiwiZmlyc3ROYW1lIjoiRW1pbHkiLCJsYXN0TmFtZSI6IkpvaG5zb24iLCJnZW5kZXIiOiJmZW1hbGUiLCJpbWFnZSI6Imh0dHBzOi8vZHVtbXlqc29uLmNvbS9pY29uL2VtaWx5cy8xMjgiLCJpYXQiOjE3NTAxMzc2NDcsImV4cCI6MTc1MjcyOTY0N30.xPkZh2CzqEj_-8lRUjMuONlB8gqrZX4FnL3NBJIxTCI",
   "id": 1,
   "username": "emilys",
   "email": "emily.johnson@x.dummyjson.com",
   "firstName": "Emily",
   "lastName": "Johnson",
   "gender": "female",
   "image": "https://dummyjson.com/icon/emilys/128"
}
```

---

## 🗃️ ¿Cómo se guarda el registro de login?

Cada vez que un usuario inicia sesión exitosamente:

1. Se envía la solicitud al endpoint `/api/login/auth`.
2. El Feign Client autentica al usuario con DummyJSON.
3. Si las credenciales son válidas, la respuesta se mapea a un modelo de dominio y se guarda el accessToken en la cookie.
4. El login exitoso se **guarda en la base de datos** con la siguiente información:
   - `id`
   - `username`
   - `access_token` (accessToken)
   - `refresh_token` (refreshToken)
   - `login_time` y hora del login (`timestamp`)
5. Luego, la respuesta se devuelve al cliente.

---

## 🥪 Pruebas

Para ejecutar las pruebas unitarias:

```bash
./gradlew test
```

---

## 🛠 Tecnologías Usadas

- Java 21
- Spring Boot 3
- Spring Data JPA
- Feign Client
- PostgreSQL
- MapStruct
- JUnit 5

