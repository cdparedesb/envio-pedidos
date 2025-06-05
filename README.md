# Envío de Pedidos - API REST (Spring Boot + XML SOAP)

Este proyecto expone un endpoint REST que recibe un JSON con los datos de un pedido, lo transforma a XML formato SOAP, lo envía a un servicio externo simulado, y devuelve la respuesta transformada nuevamente a JSON.

---

## Tecnologías usadas

- Java 17
- Spring Boot 3.5
- Maven Wrapper
- Docker
- Mocky.io (para simular endpoint SOAP externo)

---

## Cómo ejecutar el proyecto

### Requisitos previos

- Java 17
- Docker (opcional)
- Maven o usar el wrapper incluido (`./mvnw`)

---

## Ejecución local (sin Docker)

```bash
./mvnw spring-boot:run
```

La aplicación quedará disponible en:

```
http://localhost:8080
```

---

## Prueba del endpoint

### Endpoint:

```
POST http://localhost:8080/api/pedidos
```

### Headers:

```
Content-Type: application/json
```

### Body de ejemplo:

```json
{
  "numPedido": "75630275",
  "cantidadPedido": 1,
  "codigoEAN": "00110000765191002104587",
  "nombreProducto": "Armario INVAL",
  "numDocumento": "1113987400",
  "direccion": "CR 72B 45 12 APT 301"
}
```

### Respuesta esperada:

```json
{
  "enviarPedidoRespuesta": {
    "codigoEnvio": "80375472",
    "estado": "Entregado exitosamente al cliente"
  }
}
```

> ℹ️ **Nota**: El endpoint original proporcionado en el enunciado no estaba disponible, por lo que se utilizó uno simulado con Mocky:

```
https://run.mocky.io/v3/5347e0c0-155f-4961-8a7a-4293a6cabd13
```

---

## Ejecutar con Docker

### Construir imagen:

```bash
docker build -t acme/envio-pedidos .
```

### Ejecutar contenedor:

```bash
docker run -p 8080:8080 acme/envio-pedidos
```

---

## Estructura del proyecto

- `/controller`: lógica REST
- `/model`: clases para serializar/deserializar JSON y XML
- `/soap`: lógica para transformar JSON ↔ XML SOAP
- `Dockerfile`: definición para empaquetar la app
- `README.md`: esta guía

---

## Autor

Cristian D. Paredes  
Repositorio: [github.com/cdparedesb/envio-pedidos](https://github.com/cdparedesb/envio-pedidos)
