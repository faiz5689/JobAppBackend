# Job Application Microservices Platform

A modern, scalable job application platform built with Spring Boot microservices architecture. This project demonstrates the implementation of a distributed system using contemporary cloud-native technologies and best practices.

## 🌟 Features

- Microservices-based architecture
- Job posting and application management
- Company profiles and management
- Review system for companies
- Service discovery with Eureka
- API Gateway using Spring Cloud Gateway
- Distributed tracing with Zipkin
- Message queuing with RabbitMQ
- Centralized configuration with Spring Cloud Config
- Circuit breaking and fault tolerance with Resilience4J
- Containerization with Docker
- Container orchestration with Kubernetes
- PostgreSQL database integration

## 🏗️ Architecture

The application is divided into the following microservices:

- **Job Service**: Manages job postings and applications
- **Company Service**: Handles company profiles and information
- **Review Service**: Manages company reviews and ratings
- **Config Server**: Centralized configuration management
- **Service Registry**: Service discovery using Eureka
- **API Gateway**: Request routing and load balancing
- **Authentication Service**: User authentication and authorization

## 🚀 Technologies

- **Spring Boot**: Core framework for building microservices
- **Spring Cloud**: For cloud-native patterns implementation
- **Docker**: Containerization
- **Kubernetes**: Container orchestration
- **PostgreSQL**: Primary database
- **RabbitMQ**: Message queue
- **Zipkin**: Distributed tracing
- **Resilience4J**: Circuit breaking and fault tolerance
- **Maven**: Dependency management and build tool

## 🛠️ Getting Started

### Prerequisites

- JDK 17 or later
- Maven 3.6+
- Docker
- Kubernetes (Minikube for local development)
- PostgreSQL
- RabbitMQ

### Local Development Setup

1. Clone the repository:
```bash
git clone [repository-url]
cd job-application-platform
```

2. Start the required services:
```bash
docker-compose up -d
```

3. Start the microservices in order:
```bash
# Start Config Server first
cd configserver
mvn spring-boot:run

# Start Service Registry
cd ../service-registry
mvn spring-boot:run

# Start other services
cd ../jobms
mvn spring-boot:run

cd ../companyms
mvn spring-boot:run

cd ../reviewms
mvn spring-boot:run
```

### Docker Deployment

Build and run all services using Docker Compose:

```bash
docker-compose up --build
```

### Kubernetes Deployment

1. Build Docker images for all services
2. Apply Kubernetes configurations:
```bash
kubectl apply -f k8s/
```

## 📚 API Documentation (For Monolithic App (jobapp))

### Job Service
- `GET /api/jobs`: Get all jobs
- `POST /api/jobs`: Create a new job
- `GET /api/jobs/{id}`: Get job by ID
- `PUT /api/jobs/{id}`: Update job
- `DELETE /api/jobs/{id}`: Delete job

### Company Service
- `GET /api/companies`: Get all companies
- `POST /api/companies`: Create a new company
- `GET /api/companies/{id}`: Get company by ID
- `PUT /api/companies/{id}`: Update company
- `DELETE /api/companies/{id}`: Delete company

### Review Service
- `GET /api/companies/{companyId}/reviews`: Get company reviews
- `POST /api/companies/{companyId}/reviews`: Add company review
- `GET /api/companies/{companyId}/reviews/{reviewId}`: Get company review by review ID
- `PUT /api/companies/{companyId}/reviews/{reviewId}`: Update review
- `DELETE /api/companies/{companyId}/reviews/{reviewId}`: Delete review

## 📚 API Documentation (For Microservices)

### Job Service
- `GET /api/jobs`: Get all jobs
- `POST /api/jobs`: Create a new job
- `GET /api/jobs/{id}`: Get job by ID
- `PUT /api/jobs/{id}`: Update job
- `DELETE /api/jobs/{id}`: Delete job

### Company Service
- `GET /api/companies`: Get all companies
- `POST /api/companies`: Create a new company
- `GET /api/companies/{id}`: Get company by ID
- `PUT /api/companies/{id}`: Update company
- `DELETE /api/companies/{id}`: Delete company

### Review Service
- `GET api/reviews?companyId={companyId}`: Get company reviews
- `POST /api/reviews?companyId={companyId}`: Add company review
- `PUT /api/reviews/{reviewId}`: Update review
- `DELETE /api/reviews/{reviewId}`: Delete review

## 🔍 Monitoring

The application includes comprehensive monitoring capabilities:

- Actuator endpoints for health monitoring
- Zipkin for distributed tracing
- Metrics collection and visualization
- Logging with centralized log aggregation

## 🤝 Contributing

1. Fork the repository
2. Create your feature branch (`git checkout -b feature/AmazingFeature`)
3. Commit your changes (`git commit -m 'Add some AmazingFeature'`)
4. Push to the branch (`git push origin feature/AmazingFeature`)
5. Open a Pull Request
