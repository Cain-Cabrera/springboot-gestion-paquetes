## ⚙️ Tecnologías utilizadas
- Java 21
- Spring Boot
- Spring Data
- MySQL (administrado con DBeaver)
- Maven (gestión de dependencias)
- JUnit 5 & Mockito (testing unitario)
- Docker & Docker Compose
- Postman
- Git & GitHub (control de versiones)
- IDE: NetBeans / IntelliJ IDEA
  
---

## 📐 Arquitectura del proyecto
El sistema está organizado siguiendo arquitectura en capas, garantizando una clara separación de responsabilidades y facilidad de mantenimiento:
```
src/
 ├── controller/        → Exposición de endpoints REST
 ├── dto/               → DTOs de request y response
 ├── exception/         → Excepciones personalizadas y manejo de errores
 ├── mapper/            → Conversión entre DTOs y entidades
 ├── model/             → Entidades del dominio
 ├── repository/        → Acceso a datos (JPA)
 ├── service/           → Lógica de negocio
 ├── validation/        → Validaciones de reglas de negocio
 └── test/
      ├── service/      → Tests unitarios de la capa Service
      └── testdata/     → Builders y datos de prueba

```
---

## 🧱 Principios y patrones aplicados
- Principios SOLID
- Arquitectura en capas
- Patrón Repository / DAO
- DTO + Mapper
- Separación de responsabilidades
- Inyección de dependencias
- Manejo centralizado de excepciones
- Logs estructurados
  
---

## 🧪 Testing
-El proyecto cuenta con tests unitarios bien estructurados, enfocados en lógica de negocio y comportamiento:
- Tests de Service
- Uso de JUnit 5
- Mocking con Mockito
- Patrón Builder para creación de objetos de prueba
- Casos felices y casos de error
- Validación de excepciones y flujos alternativos
  
---

## 🐳 Dockerización
- La aplicación está preparada para ejecutarse en entornos contenerizados:
- Dockerfile para la aplicación Spring Boot
- Docker Compose para levantar Aplicacion y bases de datos MySQL
- Configuración de conexión mediante variables de entorno
- Entornos reproducibles
- Fácil despliegue
- Uso de la base de datos desde la app local o desde el contenedor

---

## 🧩 Funcionalidades principales
- Gestión de clientes
- Gestión de pedidos
- Creación, actualización, eliminación y consulta
- Validaciones de reglas de negocio
- Manejo de errores con respuestas claras
- Persistencia en base de datos relacional
- API REST estructurada

---

## 🎯 Objetivo del proyecto
- Este proyecto fue desarrollado como parte de mi formación como Desarrollador Backend, con foco en:
- Construcción de backends reales y escalables
- Aplicación de buenas prácticas profesionales
- Diseño de código limpio y mantenible
- Testing orientado a empleabilidad
- Preparación para entornos productivos

---
## 🚀 Próximas mejoras

- El proyecto a recibir mejoras en tanto a la calidad del codigo y se implementara seguridad con Spring Security.
- Se implementaras mejores practicas a lo largo de que se vaya adquiriendo mas conocimientos.
  
---
## 👨‍💻 Autor

Cain Cabrera
Backend Developer en formación | Java & Spring Ecosystem
📍 Buenos Aires, Argentina
