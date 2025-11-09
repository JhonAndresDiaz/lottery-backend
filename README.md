LOTTERY BACKEND SYSTEM - SPRING BOOT
Descripción del Proyecto
Sistema backend completo para la gestión de venta de billetes de lotería, desarrollado como prueba técnica para Konex Innovation. Proporciona una API RESTful para administrar sorteos, clientes y transacciones de venta de billetes.

Arquitectura del Sistema
Arquitectura Hexagonal (Ports & Adapters)
El sistema sigue los principios de la Arquitectura Hexagonal, separando claramente la lógica de negocio de los detalles técnicos y de infraestructura.

text
┌─────────────────────────────────────────────────────────────┐
│                    APPLICATION LAYER                        │
├─────────────────────────────────────────────────────────────┤
│                   DOMAIN LAYER (Core)                       │
├─────────────────────────────────────────────────────────────┤
│                  INFRASTRUCTURE LAYER                       │
└─────────────────────────────────────────────────────────────┘

Tecnologías y Versiones
Tecnología	Versión	Propósito
Java	17	Lenguaje de programación
Spring Boot	3.3.5	Framework principal
Spring Data JPA	3.3.5	Acceso a datos
H2 Database	2.2.224	Base de datos en memoria
Maven	3.9+	Gestión de dependencias
JUnit 5	5.10+	Framework de testing
Mockito	5.7+	Mocking para tests
SpringDoc OpenAPI	2.5.0	Documentación API (Swagger)
Lombok	1.18.30	Reducción de código boilerplate

Estructura del Proyecto

src/
├── main/
│   ├── java/
│   │   └── com/
│   │       └── lottery/
│   │           ├── LotteryApplication.java          # Clase principal
│   │           │
│   │           ├── domain/                          CAPA DE DOMINIO
│   │           │   ├── model/                       # Entidades de negocio
│   │           │   │   ├── Sorteo.java
│   │           │   │   ├── Cliente.java
│   │           │   │   └── Billete.java
│   │           │   │
│   │           │   ├── service/                     # Servicios de dominio
│   │           │   │   ├── SorteoService.java
│   │           │   │   ├── ClienteService.java
│   │           │   │   └── BilleteService.java
│   │           │   │
│   │           │   └── ports/                       PORTS (Interfaces)
│   │           │       ├── in/                      # Puertos de entrada
│   │           │       │   ├── SorteoServicePort.java
│   │           │       │   ├── ClienteServicePort.java
│   │           │       │   └── BilleteServicePort.java
│   │           │       │
│   │           │       └── out/                     # Puertos de salida
│   │           │           ├── SorteoRepositoryPort.java
│   │           │           ├── ClienteRepositoryPort.java
│   │           │           └── BilleteRepositoryPort.java
│   │           │
│   │           ├── application/                     CAPA DE APLICACIÓN
│   │           │   ├── rest/                        # Controladores REST
│   │           │   │   ├── SorteoController.java
│   │           │   │   ├── ClienteController.java
│   │           │   │   └── BilleteController.java
│   │           │   │
│   │           │   ├── dto/                         # Objetos de transferencia
│   │           │   │   ├── request/
│   │           │   │   └── response/
│   │           │   │
│   │           │   └── mapper/                      # Mappers DTO<->Entity
│   │           │       ├── SorteoMapper.java
│   │           │       ├── ClienteMapper.java
│   │           │       └── BilleteMapper.java
│   │           │
│   │           └── infrastructure/                  CAPA DE INFRAESTRUCTURA
│   │               ├── persistence/                 # Adaptadores de persistencia
│   │               │   ├── entity/                  # Entidades JPA
│   │               │   ├── repository/              # Repositorios JPA
│   │               │   └── adapter/                 # Adaptadores Repository
│   │               │
│   │               ├── config/                      # Configuraciones
│   │               │   ├── SwaggerConfig.java
│   │               │   └── CorsConfig.java
│   │               │
│   │               └── exception/                   # Manejo de excepciones
│   │                   └── GlobalExceptionHandler.java
│   │
│   └── resources/
│       ├── application.properties                   # Configuración principal
│       └── data.sql                                 # Datos de prueba
│
└── test/                                           # Tests automatizados
    └── java/
        └── com/
            └── lottery/
                ├── domain/                          # Tests de dominio
                └── application/                     # Tests de aplicación

 
Funcionalidades Implementadas
- Módulo de Sorteos (3 Endpoints)
GET /api/sorteos - Listar todos los sorteos

GET /api/sorteos/{id} - Obtener sorteo por ID

POST /api/sorteos - Crear nuevo sorteo

- Módulo de Clientes (3 Endpoints)
GET /api/clientes - Listar todos los clientes

GET /api/clientes/{id} - Obtener cliente por ID

POST /api/clientes - Crear nuevo cliente

- Módulo de Billetes (7 Endpoints)
GET /api/billetes - Listar todos los billetes

GET /api/billetes/{id} - Obtener billete por ID

GET /api/billetes/sorteo/{sorteoId} - Billetes de un sorteo

GET /api/billetes/sorteo/{sorteoId}/disponibles - Billetes disponibles

GET /api/billetes/cliente/{clienteId} - Historial de compras

POST /api/billetes - Crear billete

POST /api/billetes/vender - VENDER BILLETE (Endpoint principal)


🚀 Ejecución del Proyecto
Prerrequisitos
Java 17 o superior

Maven 3.9+

Puerto 8080 disponible

1. Clonar y compilar

 $ git clone https://github.com/JhonAndresDiaz/lottery-backend.git
 cd lottery-backend (raíz del proyecto)
 $ mvn clean compile
 
2. Ejecutar la aplicación

  $ mvn spring-boot:run
 
3. Verificar que esté funcionando
   
  -Swagger UI - Documentación Interactiva
  http://localhost:8080/api/docs

  Características:
    Documentación completa de todos los endpoints
    Pruebas interactivas de la API
    Esquemas de request/response
    Códigos de error documentados

  -H2 Database Console
  http://localhost:8080/h2-console
  
  Credenciales de conexión:
    JDBC URL: jdbc:h2:mem:lotterydb
    User Name: sa
    Password: (dejar vacío)

🎯 Reglas de Negocio Implementadas
Gestión de Sorteos
- Cada sorteo tiene un número fijo de billetes
- Control automático de billetes disponibles/vendidos
- Validación de fechas (no crear sorteos en pasado)

Gestión de Clientes
- Email único por cliente
- Control de historial de compras
- Registro automático de fecha de registro

Gestión de Billetes
- Estados: DISPONIBLE / VENDIDO
- Validación de venta: billete debe estar disponible
- Prevención de ventas duplicadas
- Registro de fecha y hora de venta
- Historial completo por cliente

Manejo de Errores
  Códigos HTTP Implementados
    200 OK - Operación exitosa
    201 CREATED - Recurso creado exitosamente
    400 BAD_REQUEST - Validación fallida
    404 NOT_FOUND - Recurso no encontrado
    409 CONFLICT - Billete ya vendido / Email duplicado
    500 INTERNAL_SERVER_ERROR - Error inesperado

Estructura de Error Response
json
{
    "timestamp": "2025-11-09T14:30:00",
    "status": 409,
    "error": "Conflict",
    "message": "El billete con ID 1 ya ha sido vendido",
    "errors": [],
    "path": "/api/billetes/vender"
}

Configuración de CORS
El backend está configurado para aceptar requests desde:
  http://localhost:4200 (Angular default)
  http://localhost:4201 (Angular alternativo)

Datos Precargados
Sorteos (4)
  Lotería Nacional - Diciembre 2025 (12 billetes)
  Baloto - Edición Especial (6 billetes)
  Chance Millonario (8 billetes)
  Lotería de Bogotá (5 billetes)
Clientes (5)
  Juan Pérez García
  María González López
  Carlos Rodríguez Martínez
  Ana Martínez Sánchez
  Luis Hernández García

Billetes (40 total)
  32 DISPONIBLES
  8 VENDIDOS

Métricas y Estadísticas
Cada entidad proporciona métricas automáticas:
  Sorteos: total billetes, disponibles, vendidos
  Clientes: total billetes comprados, fecha registro
  Billetes: estado, fechas de creación/venta, historial

Flujo de Venta Principal
  Validar que el billete esté DISPONIBLE
  Validar que el cliente exista
  Actualizar estado del billete a VENDIDO
  Registrar cliente, fecha y hora de venta
  Actualizar contadores en sorteo y cliente
  Retornar billete con información completa

Soporte y Contacto
Desarrollador: Jhon Andrés Díaz Cano
Email: jhonandresdiazcano@gmail.com
Fecha de Desarrollo: Noviembre 2025

Última actualización: Noviembre 2025

Sistema desarrollado para prueba técnica de Konex Innovation


Última actualización: Noviembre 2025

Sistema desarrollado para prueba técnica de Konex Innovation
