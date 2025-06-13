# SpringMusic

Una aplicación web moderna de gestión musical construida con Spring Boot y Jakarta EE, que permite a los usuarios descubrir, organizar y gestionar su colección de música.

## 🎵 Características

- **Gestión de Biblioteca Musical**: Organiza tu colección de canciones, álbumes y artistas
- **Búsqueda Avanzada**: Encuentra música por título, artista, género o año
- **Listas de Reproducción**: Crea y gestiona listas de reproducción personalizadas
- **API REST**: Interfaz completa para integración con aplicaciones externas
- **Persistencia de Datos**: Almacenamiento robusto con Spring Data JPA
- **Arquitectura Moderna**: Implementación con Jakarta EE y las últimas tecnologías

## 🛠️ Tecnologías

- **Java 24** - Lenguaje principal
- **Spring Boot 3.x** - Framework principal
- **Spring Data JPA** - Persistencia de datos
- **Jakarta EE** - Especificaciones empresariales
- **Maven** - Gestión de dependencias
- **H2/PostgreSQL** - Base de datos (configurable)

## 📋 Prerequisitos

Antes de ejecutar la aplicación, asegúrate de tener instalado:

- Java 24 o superior
- Maven 3.8+
- Git

## 🚀 Instalación y Ejecución

### Clonar el repositorio
git clone https://github.com/JavissNeg/SpringMusic.git
cd SpringMusic

### Configurar variables de entorno

#### application-prod.properties
spring.datasource.url=jdbc:postgresql://localhost:5432/springmusic
spring.datasource.username=tu_usuario
spring.datasource.password=tu_contraseña
spring.jpa.database-platform=org.hibernate.dialect.PostgreSQLDialect
