# Spring Boot Microservices Demo

## Overview

**Spring Boot Microservices Demo** is a demonstration project designed to showcase a microservices architecture using Spring Boot. The project illustrates the integration of various microservices with modern tools and frameworks, providing a robust example of how to build and manage microservices using Java and Spring technologies.

## Technologies Used

- **Java 17**
- **Spring Boot 3.1.x**
- **Maven**
- **Swagger UI (OpenAPI)**
- **MySQL**
- **Spring Cloud**
- **Spring Cloud OpenFeign**
- **Spring Boot Admin**
- **Spring Cloud Netflix - Eureka Server**
- **Spring Cloud Circuit Breaker**
- **Spring Data JPA**
- **MapStruct**

## Microservices

This project consists of the following Spring Boot microservices:

1. **Eureka Server**
   - **Application Name**: `EUREKA-SERVER`
   - **Port**: `8761`
   - **URL**: [http://localhost:8761/](http://localhost:8761/)

2. **API Gateway**
   - **Application Name**: `API-GATEWAY`
   - **Port**: `7777`

3. **Spring Boot Admin Server**
   - **Application Name**: `ADMIN-SERVER`
   - **Port**: `8888`
   - **URL**: [http://localhost:8888/wallboard](http://localhost:8888/wallboard)

4. **Doctor Service**
   - **Application Name**: `DOCTOR-SERVER`
   - **Port**: `8000`
   - **Context Path**: `/doctor`
   - **Swagger UI**: [http://localhost:8000/doctor/swagger-ui/index.html#/](http://localhost:8000/doctor/swagger-ui/index.html#/)

5. **Patient Service**
   - **Application Name**: `PATIENT-SERVER`
   - **Port**: `9001`
   - **Context Path**: `/patient`
   - **Swagger UI**: [http://localhost:9001/patient/swagger-ui/index.html#/](http://localhost:9001/patient/swagger-ui/index.html#/)

6. **Payment Service**
   - **Application Name**: `PAYMENT-SERVER`
   - **Port**: `3000`
   - **Context Path**: `/payment`
   - **Swagger UI**: [http://localhost:3000/payment/swagger-ui/index.html#/](http://localhost:3000/payment/swagger-ui/index.html#/)

## API Access

All APIs for the **Doctor**, **Patient**, and **Payment** services should be accessed through the **API Gateway** on port `7777`.

## Setup and Run

### Prerequisites

Before you start, ensure you have the following installed:

- **Java 17**
- **Maven**
- **MySQL** (or another database you prefer, ensure it's configured correctly)

### Clone the Repository

```bash
git clone https://github.com/mohammednasro/springboot-microservices-demo.git
cd springboot-microservices-demo
```

### Configure the Database

Update the `application.properties` or `application.yml` files in each microservice with your database configuration.

### Build the Project

To build the entire project, run:

```bash
mvn clean install
```

### Run the Microservices

You can run each microservice individually. Start the microservices in the following order to ensure dependencies are correctly resolved:

1. **Eureka Server**
   ```bash
   mvn spring-boot:run -pl eureka
   ```

2. **Spring Boot Admin Server**
   ```bash
   mvn spring-boot:run -pl adminserver
   ```

3. **API Gateway**
   ```bash
   mvn spring-boot:run -pl api-gateway
   ```

4. **Doctor Service**
   ```bash
   mvn spring-boot:run -pl doctor
   ```

5. **Patient Service**
   ```bash
   mvn spring-boot:run -pl patient
   ```

6. **Payment Service**
   ```bash
   mvn spring-boot:run -pl payment
   ```

### Docker Support

A Dockerfile will be provided in a separate branch for containerized deployment. Please check the `docker` branch for details.

## Usage

- **Eureka Server**: [http://localhost:8761/](http://localhost:8761/)
- **Spring Boot Admin Server**: [http://localhost:8888/wallboard](http://localhost:8888/wallboard)
- **API Gateway**:
  - **Doctor Service**: [http://localhost:7777/doctor/](http://localhost:7777/doctor/)
  - **Patient Service**: [http://localhost:7777/patient/](http://localhost:7777/patient/)
  - **Payment Service**: [http://localhost:7777/payment/](http://localhost:7777/payment/)

## Notes

- Swagger UI for the **Doctor**, **Patient**, and **Payment** services can be accessed through the API Gateway.
- Ensure all microservices are running before making API calls through the gateway.

## Contributing

Contributions are welcome! Please submit pull requests or open issues for discussion.

## Contact

For further information, please contact **Mohammed Nasro**.

