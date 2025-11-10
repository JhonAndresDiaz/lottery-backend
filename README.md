# Lottery Backend System - Spring Boot

## Descripción del Proyecto

Sistema backend completo para la gestión de venta de billetes de lotería, desarrollado como prueba técnica para Konex Innovation. Proporciona una API RESTful para administrar sorteos, clientes y transacciones de venta.

### **Características principales:**
- Gestión completa de sorteos con estadísticas en tiempo real
- Registro de clientes con validación de email único
- Control de billetes con estados (DISPONIBLE/VENDIDO)
- Proceso de venta robusto con prevención de duplicados
- API RESTful documentada con Swagger
- Base de datos H2 en memoria con datos de ejemplo
- **Ejecución con Docker en un solo comando**

- - -

## Arquitectura del Sistema

### Arquitectura Hexagonal (Ports & Adapters)

* APPLICATION LAYER                        
* DOMAIN LAYER (Core)                     
* INFRASTRUCTURE LAYER                       

### Ventajas

*   Desacoplamiento total entre lógica de negocio y framework
*   Testabilidad mejorada
*   Mantenibilidad
*   Flexibilidad
*   Escalabilidad

- - -

## 🛠️ Tecnologías y Versiones

| Tecnología | Versión | Propósito |
| --- | --- | --- |
| Java | 17  | Lenguaje |
| Spring Boot | 3.3.5 | Framework |
| Spring Data JPA | 3.3.5 | Acceso a datos |
| H2 Database | 2.2.224 | BD en memoria |
| Maven | 3.9+ | Gestión dependencias |
| JUnit 5 | 5.10+ | Testing |
| Mockito | 5.7+ | Mocking |
| SpringDoc (Swagger) | 2.5.0 | Documentación API |
| Lombok | 1.18.30 | Boilerplate |

- - -

## Estructura del Proyecto (COMPATIBLE CON GITHUB)

- **`domain/`** - Capa de dominio (Arquitectura Hexagonal)
  - **`model/`** - Entidades y objetos de valor
  - **`service/`** - Lógica de negocio
  - **`ports/`** - Interfaces de entrada/salida
    - **`in/`** - Puertos de entrada (casos de uso)
    - **`out/`** - Puertos de salida (repositorios)

- **`application/`** - Capa de aplicación
  - **`rest/`** - Controladores HTTP
  - **`dto/`** - Objetos de transferencia de datos
  - **`mapper/`** - Mapeadores entre entidades y DTOs

- **`infrastructure/`** - Capa de infraestructura
  - **`persistence/`** - Implementación de repositorios (JPA)
  - **`config/`** - Configuraciones de Spring
  - **`exception/`** - Manejo global de excepciones

- **`resources/`** - Recursos de la aplicación
  - **`application.properties`** - Configuración
  - **`data.sql`** - Datos de prueba
 
- - -

Explicación más detallada de las Capas:

* domain/ - Capa de dominio (Arquitectura Hexagonal)

    * model/ - Entidades y objetos de valor (Sorteo, Cliente, Billete)

    * service/ - Lógica de negocio (SorteoService, ClienteService, BilleteService)

    * ports/ - Interfaces de entrada/salida

        * in/ - Puertos de entrada (casos de uso) - Interfaces que el dominio expone para ser usado por la capa de aplicación

        * out/ - Puertos de salida (repositorios) - Interfaces que el dominio define para acceder a datos externos (base de datos, etc.)

* application/ - Capa de aplicación

    * rest/ - Controladores HTTP (SorteoController, ClienteController, BilleteController)

    * dto/ - Objetos de transferencia de datos (Request/Response)

    * mapper/ - Mapeadores entre entidades y DTOs

* infrastructure/ - Capa de infraestructura

    * persistence/ - Implementación de repositorios (JPA) - Adaptadores que implementan los puertos de salida del dominio

    * config/ - Configuraciones de Spring (Swagger, CORS, etc.)

    * exception/ - Manejo global de excepciones

* resources/ - Recursos de la aplicación

    * application.properties - Configuración de la aplicación

    * data.sql - Datos de prueba (sorteos, clientes, billetes)

- - -

## Funcionalidades Implementadas

### Módulo de Sorteos

*   `GET /api/sorteos`
*   `GET /api/sorteos/{id}`
*   `POST /api/sorteos`

### Módulo de Clientes

*   `GET /api/clientes`
*   `GET /api/clientes/{id}`
*   `POST /api/clientes`

### Módulo de Billetes

*   `GET /api/billetes`
*   `GET /api/billetes/{id}`
*   `GET /api/billetes/sorteo/{sorteoId}`
*   `GET /api/billetes/sorteo/{sorteoId}/disponibles`
*   `GET /api/billetes/cliente/{clienteId}`
*   `POST /api/billetes`
*   `POST /api/billetes/vender` (principal)

- - -

## Ejecución del Proyecto

### Requisitos

*   Java 17+
*   Maven 3.9+
*   Puerto 8080 libre

## Ejecución con Docker 🐳

### **Opción 1: Script Automático** 

El proyecto incluye scripts que hacen TODO automáticamente.

#### **Linux / macOS:**
```bash
# 1. Clonar el repositorio
git clone https://github.com/JhonAndresDiaz/lottery-backend.git
cd lottery-backend

# 2. Dar permisos de ejecución
chmod +x start-docker.sh

# 3. Ejecutar (hace todo automáticamente)
./start-docker.sh
```

#### **Windows:**
```bash
# 1. Clonar el repositorio
git clone https://github.com/JhonAndresDiaz/lottery-backend.git
cd lottery-backend

# 2. Ejecutar (doble click o desde CMD/PowerShell)
start-docker.bat
```

**El script automáticamente:**
1. Verifica que Docker esté instalado y corriendo
2. Limpia contenedores previos
3. Compila el proyecto con Maven
4. Construye la imagen Docker optimizada
5. Ejecuta la aplicación Spring Boot
6. Carga los datos de ejemplo en H2
7. Expone el puerto 8080
   
- - -

### **Opción 2: Ejecución Manual**

Si prefieres ejecutar sin Docker (requiere Java 17 y Maven instalados):

### **Requisitos:**
- Java JDK 17 o superior
- Maven 3.9+
- Puerto 8080 libre

### **Pasos:**

```bash
# 1. Clonar el repositorio
git clone https://github.com/JhonAndresDiaz/lottery-backend.git
cd lottery-backend

# 2. Compilar el proyecto
mvn clean install

# 3. Ejecutar la aplicación
mvn spring-boot:run
```

- - -

## Herramientas de Desarrollo

**Swagger UI:**

http://localhost:8080/api/docs

**H2 Console:**

```bash
http://localhost:8080/h2-console
JDBC URL: jdbc:h2:mem:lotterydb
User: sa
Password: (vacío)
```

- - -

## Reglas de Negocio

#### Sorteos

*   Número fijo de billetes
*   Control de disponibles y vendidos
*   Validación de fechas

#### Clientes

*   Email único
*   Registro automático
*   Historial de compras

#### Billetes

*   Estados: DISPONIBLE / VENDIDO
*   Prevención de ventas duplicadas
*   Registro de fecha/hora

- - -

## Manejo de Errores

```bash
{
  "timestamp": "2025-11-09T14:30:00",
  "status": 409,
  "error": "Conflict",
  "message": "El billete con ID 1 ya ha sido vendido",
  "errors": \[\],
  "path": "/api/billetes/vender"
}
```
- - -

## Datos Precargados

*   4 Sorteos
*   5 Clientes
*   31 Billetes (8 vendidos)

- - -

## Métricas Automáticas

*   Sorteos: vendidos/disponibles
*   Clientes: compras totales
*   Billetes: estado/fechas/historial

- - -

## Contacto

**Desarrollador:** Jhon Andrés Díaz Cano  
**Email:** jhonandresdiazcano@gmail.com  
**Fecha:** Noviembre 2025

- - -

