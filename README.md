# 📦 Proyecto Amaristest - API de Autenticación y Registro de Login

Este proyecto es una API REST que permite autenticar un usuario contra el servicio de DummyJSON usando `Feign Client`, registrar el login en una base de datos PostgreSQL y exponer un endpoint para consultar los datos del usuario autenticado.

---

## 🚀 Instrucciones de Ejecución

1. **Clonar el repositorio**

```bash
git clone https://github.com/tu-usuario/amaristest.git
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
  "username": "kminchelle",
  "password": "0lelplR"
}
```

---

## 🔐 Ejemplo `curl` para Login

```bash
curl -X POST http://localhost:8080/api/login/auth \
  -H "Content-Type: application/json" \
  -d '{"username": "kminchelle", "password": "0lelplR"}'
```

Respuesta esperada:

```json
{
  "id": 1,
  "username": "kminchelle",
  "token": "eyJhbGciOi..."
}
```

---

## 🗃️ ¿Cómo se guarda el registro de login?

Cada vez que un usuario inicia sesión exitosamente:

1. Se envía la solicitud al endpoint `/api/login/auth`.
2. El Feign Client autentica al usuario con DummyJSON.
3. Si las credenciales son válidas, la respuesta se mapea a un modelo de dominio.
4. El login exitoso se **guarda en la base de datos** con la siguiente información:
   - `user_id` del DummyJSON
   - `username`
   - `token` (accessToken)
   - `fecha` y hora del login (`timestamp`)
5. Luego, la respuesta se devuelve al cliente.

### Ejemplo de entidad `LoginEntity`:

```java
@Entity
public class LoginEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long userId;
    private String username;
    private String token;
    private LocalDateTime loginDate;
}
```

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

