# TecnoSoporte – Sistema de Cotización de Servicios Técnicos

Aplicación web desarrollada con Spring Boot para registrar solicitudes de servicios técnicos, calcular subtotales y aplicar descuentos según el tipo de cliente mediante el patrón de diseño Strategy.

Proyecto correspondiente a la Práctica Calificada N.° 03 del curso Arquitectura de Software.

---

## Tecnologías utilizadas

- Java 17
- Spring Boot 4.1.2
- Spring MVC
- Thymeleaf
- Bean Validation (Jakarta)
- Maven 3.9.6
- Docker (para despliegue)

---

## Requisitos previos

| Herramienta | Versión mínima |
|---|---|
| Java JDK | 17 |
| Maven | 3.9.x (o usar el `mvnw` incluido) |
| Git | cualquier versión reciente |
| Docker | solo si se despliega con contenedor |

No se requieren variables de entorno ni base de datos. La aplicación no persiste datos.

---

## Estructura de carpetas

```
src/
├── main/
│   ├── java/com/tecnosoporte/cotizacion/
│   │   ├── CotizacionApplication.java       # Punto de entrada
│   │   ├── controller/
│   │   │   └── CotizacionController.java    # Rutas GET y POST
│   │   ├── model/
│   │   │   ├── CotizacionRequest.java       # Datos del formulario + validaciones
│   │   │   └── CotizacionResult.java        # Resultado calculado para la vista
│   │   └── strategy/
│   │       ├── DescuentoStrategy.java       # Interfaz Strategy
│   │       ├── ClienteNuevoStrategy.java    # 0% descuento
│   │       ├── ClienteFrecuenteStrategy.java  # 10% descuento
│   │       ├── ClienteInstitucionalStrategy.java # 15% descuento
│   │       └── DescuentoContext.java        # Contexto que ejecuta la estrategia
│   └── resources/
│       ├── templates/
│       │   ├── formulario.html              # Vista del formulario
│       │   └── resultado.html              # Vista del resumen de cotización
│       └── application.yaml               # Configuración de la aplicación
├── test/
Dockerfile
pom.xml
```

---

## Instalación de dependencias

Con el `mvnw` incluido no es necesario tener Maven instalado globalmente.

```bash
./mvnw dependency:resolve
```

En Windows:

```bash
.\mvnw.cmd dependency:resolve
```

---

## Configuración

El archivo `src/main/resources/application.yaml` contiene la configuración de la aplicación:

```yaml
spring:
  application:
    name: cotizacion
  thymeleaf:
    cache: false
    encoding: UTF-8

server:
  port: 8080
```

No se requiere ninguna variable de entorno adicional.

---

## Compilar y ejecutar localmente

**En Linux/Mac:**

```bash
./mvnw spring-boot:run
```

**En Windows:**

```bash
.\mvnw.cmd spring-boot:run
```

La aplicación estará disponible en `http://localhost:8080`.

Para compilar el JAR sin ejecutar:

```bash
.\mvnw.cmd package -DskipTests
```

El JAR se genera en `target/cotizacion-0.0.1-SNAPSHOT.jar`.

---

## Despliegue en Render (con Docker)

El proyecto incluye un `Dockerfile` listo para despliegue.

### Pasos

1. Subir el repositorio a GitHub.
2. Crear una cuenta en [render.com](https://render.com).
3. Crear un nuevo **Web Service** conectado al repositorio.
4. En la configuración del servicio:
   - **Language:** Docker
   - **Build Command:** *(vacío, Docker lo gestiona)*
   - **Start Command:** *(vacío, Docker lo gestiona)*
   - **Instance Type:** Free
5. Hacer clic en **Deploy Web Service**.

Render detecta el `Dockerfile` automáticamente. El primer build tarda entre 4 y 6 minutos.

---

## URL de la aplicación publicada

> https://tecnosoporte-cotizacion.onrender.com

---

## Verificación de funcionalidades

Una vez que la aplicación esté corriendo (local o en Render), verificar los siguientes casos:

| Caso | Datos de entrada | Resultado esperado |
|---|---|---|
| 01 | Diagnóstico de computadora × 2 · Cliente nuevo | Total: S/ 80.00 |
| 02 | Mantenimiento preventivo × 2 · Cliente frecuente | Total: S/ 126.00 |
| 03 | Instalación de software × 3 · Cliente institucional | Total: S/ 127.50 |
| 04 | Nombre vacío o cantidad fuera de rango (0 o 6) | Mensaje de validación en el formulario |

Para el caso 04, dejar el campo nombre en blanco o ingresar una cantidad menor a 1 o mayor a 5 y hacer clic en **Calcular cotización**. El formulario debe mostrar el mensaje de error sin redirigir a la página de resultado.
