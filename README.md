<div align="center">

# 🎵 SpringMusic

[![Java](https://img.shields.io/badge/Java-24-orange.svg)](https://www.oracle.com/java/)
[![Spring Boot](https://img.shields.io/badge/Spring%20Boot-3.x-brightgreen.svg)](https://spring.io/projects/spring-boot)
[![Jakarta EE](https://img.shields.io/badge/Jakarta%20EE-Latest-blue.svg)](https://jakarta.ee/)

**Proyecto introductorio de integración entre una base de datos musical con JPA y una biblioteca de IA a través de una interfaz de consola interactiva**


[Tecnologías](#%EF%B8%8F-tecnologías) • 
[Prerequisitos](#-prerequisitos) • 
[Instalación](#-instalación) • 
[Estructura del proyecto](#-estructura-del-proyecto) • 
[Ejecución](#ejecución)

</div>

---

## 🛠️ Tecnologías

### Backend
- ![Java](https://img.shields.io/badge/Java-24-orange.svg) **Java 24** - Lenguaje principal con las últimas características
- ![Spring](https://img.shields.io/badge/Spring%20Boot-3.x-brightgreen.svg) **Spring Boot 3.x** - Framework principal
- ![JPA](https://img.shields.io/badge/Spring%20Data-JPA-green.svg) **Spring Data JPA** - Persistencia de datos
- ![Jakarta](https://img.shields.io/badge/Jakarta-EE-blue.svg) **Jakarta EE** - Especificaciones empresariales

### Base de Datos
- ![PostgreSQL](https://img.shields.io/badge/PostgreSQL-Primary-blue.svg) **PostgreSQL** - Base de datos principal
- ![H2](https://img.shields.io/badge/H2-Testing-lightblue.svg) **H2** - Base de datos para testing (opcional)

### Herramientas
- ![Maven](https://img.shields.io/badge/Maven-3.8+-red.svg) **Maven** - Gestión de dependencias y construcción
- ![Gemini](https://img.shields.io/badge/Google-Gemini%20AI-yellow.svg) **Google Gemini AI** - Inteligencia artificial para recomendaciones

## 📋 Prerequisitos

Antes de ejecutar la aplicación, asegúrate de tener instalado:

- ☕ **Java 24** o superior - [Descargar Java SDK](https://www.oracle.com/java/technologies/downloads/)
- 🔧 **Maven 3.8+** - [Descargar Maven](https://maven.apache.org/download.cgi)
- 🐘 **PostgreSQL** - [Descargar PostgreSQL](https://www.postgresql.org/download/)
- 🔄 **Git** - [Descargar Git](https://git-scm.com/downloads)
- 🤖 **Clave API de Google Gemini** 

## 🚀 Instalación

### 1. Clonar el repositorio

```bash
git clone https://github.com/JavissNeg/SpringMusic.git
cd SpringMusic
```

## 📂 Estructura del Proyecto

```
SpringMusic/
├── src/
│   ├── main/
│   │   ├── java/com/negrete/music/
│   │   │   ├── model/                      # Entidades JPA
│   │   │   ├── principal/                  # Interfaz de usuario
│   │   │   ├── repository/                 # Repositorios Spring Data
│   │   │   ├── service/                    # Lógica de negocio
│   │   │   └── MusicApplication.java       # Punto de entrada
│   │   └── resources/
│   │       └── application.properties      # Configuración
│   └── test/                               # Tests unitarios e integración
└── pom.xml                                 # Dependencias Maven
```

## 🎵 Ejecución

### 1. Configurar la base de datos

```sql
-- Ejecutar en PostgreSQL
CREATE DATABASE music;
```

### 2. Configurar variables de entorno

Configura las siguientes variables de entorno:

```bash
# Configuración de Base de Datos
DB_HOST=localhost:5432              # Host y puerto de PostgreSQL
DB_USERNAME=tu_usuario_postgresql   # Usuario de PostgreSQL  
DB_PASSWORD=tu_password_postgresql  # Contraseña de PostgreSQL

# Integración con IA
GEMINI_IA_API_KEY=tu_clave_gemini_api  # Clave API de Google Gemini
```

### 3. Verificar application.properties

El archivo ya está configurado en `./src/main/resources/application.properties`:

```properties
# App
spring.application.name=music

# Database
spring.datasource.url=jdbc:postgresql://${DB_HOST}/music
spring.datasource.username=${DB_USERNAME}
spring.datasource.password=${DB_PASSWORD}
spring.datasource.driver-class-name=org.postgresql.Driver

# Hibernate
spring.jpa.database-platform=org.hibernate.dialect.PostgreSQLDialect
spring.jpa.hibernate.ddl-auto=update
```


