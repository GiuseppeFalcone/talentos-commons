# TalentOS Commons

> Shared Java library for DTO contracts, response envelopes, enums, exceptions, and reusable web utilities across the TalentOS ecosystem

## Overview

**TalentOS Commons** is a reusable Maven module that centralizes cross-service contracts and utilities used by TalentOS microservices.

It provides standardized response wrappers, shared DTOs (authentication, domain, user, curriculum), common enums, custom exceptions, HTTP helper utilities, and optional Spring Boot auto-configuration for endpoint logging.

The goal is to keep all microservices aligned on request/response models and infrastructure conventions while reducing duplication and drift.

## Key Features

- **Standardized Response Envelope**: Generic `Response<T>` model with code, message, timestamp, and payload
- **Centralized Response Semantics**: `ResponseEnum` with shared business and technical status codes (including JWT and remote-service categories)
- **Shared DTO Contracts**: Reusable DTOs for user, domain, curriculum, and authentication flows
- **Validation-Ready Models**: Jakarta Validation annotations embedded in DTOs for boundary safety
- **Custom Business Exception**: `FailureException` to propagate typed failures via `ResponseEnum`
- **HTTP Utilities**: Helpers for bearer token sanitization and path-variable extraction from servlet requests
- **Endpoint Logging Filter**: Optional auto-configured request logging filter for all endpoints
- **Spring Boot Auto-Configuration**: Plug-and-play registration via `AutoConfiguration.imports`
- **Boilerplate Reduction**: Lombok-enabled model and contract classes

## Technology Stack

| Component                   | Technology                     | Version |
| --------------------------- | ------------------------------ | ------- |
| **Language**                | Java                           | 25      |
| **Framework APIs**          | Spring Boot Web                | 3.5.6   |
| **Persistence API**         | Jakarta Persistence API        | 3.2.0   |
| **Validation API**          | Jakarta Validation API         | 3.1.1   |
| **JWT Utilities**           | JJWT (`jjwt-api/impl/jackson`) | 0.13.0  |
| **Mapping (consumer-side)** | MapStruct                      | 1.6.3   |
| **Boilerplate Reduction**   | Lombok                         | 1.18.42 |
| **Build Tool**              | Maven                          | 4.0.0   |

## Project Structure

```text
src/
├── main/
│   ├── java/com/certimetergroup/talentos/commons/
│   │   ├── enumeration/
│   │   │   ├── DrivingLicense.java                     # Shared driving-license enum
│   │   │   ├── ResponseEnum.java                       # Standard response/error taxonomy
│   │   │   └── UserRoleEnum.java                       # Shared role enum
│   │   ├── exception/
│   │   │   └── FailureException.java                   # Typed runtime business exception
│   │   ├── filter/logendpoint/
│   │   │   ├── LogEndPointFilter.java                  # Request endpoint logging filter
│   │   │   └── autoconfigure/
│   │   │       └── LogEndPointAutoConfiguration.java   # Conditional filter auto-registration
│   │   ├── response/
│   │   │   ├── Response.java                           # Generic response envelope
│   │   │   ├── authentication/                         # Auth response/request contracts
│   │   │   └── dto/                                    # Shared DTO contracts by bounded context
│   │   │       ├── curriculum/
│   │   │       ├── domain/
│   │   │       └── user/
│   │   └── utility/
│   │       └── HttpHeaderUtil.java                     # Header/path utilities
│   └── resources/
│       └── META-INF/spring/
│           └── org.springframework.boot.autoconfigure.AutoConfiguration.imports
└── test/
```

## Getting Started

### Prerequisites

- **Java 25** or higher
- **Maven 3.6+**

### Build

```bash
mvn clean package
```

### Install to Local Maven Repository

```bash
mvn clean install
```

This publishes the artifact locally as:

- `com.certimetergroup.talentos:commons:0.0.1-SNAPSHOT`

## Consumption in Other Services

Add the dependency in the consumer service `pom.xml`:

```xml
<dependency>
    <groupId>com.certimetergroup.talentos</groupId>
    <artifactId>commons</artifactId>
    <version>0.0.1-SNAPSHOT</version>
</dependency>
```

## Library Usage

### Standard Response Contract

Example usage in a controller/service layer:

```java
return new Response<>(ResponseEnum.SUCCESS, payload);
```

Envelope shape:

- `code`: numeric business/status code
- `timestamp`: response generation timestamp
- `message`: standard message from `ResponseEnum`
- `data`: typed payload (`T`)

### Failure Propagation

Throw a typed exception using shared semantics:

```java
throw new FailureException(ResponseEnum.NOT_FOUND);
```

### Token Sanitization Utility

```java
String jwt = HttpHeaderUtil.sanitizeAccessToken(authHeader);
```

Supports both `Bearer <token>` and raw token values.

### Optional Endpoint Logging Filter

The logging filter is auto-registered via Spring Boot auto-configuration and can be toggled with:

```properties
commons.log-endpoint.enabled=true
```

If the property is missing, logging is enabled by default.

## Shared Domain Model (Contracts)

This module includes shared contracts for:

- **Authentication**: `Credential`, `RefreshToken`, `AccAndRefresh`, `LoginResponse`
- **User**: `CreateUserDto`, `UserDto`, `UserLightDto`, `UserDomainOptionDto`
- **Domain**: `CreateDomainDto`, `DomainDto`, `DomainOptionDto`
- **Curriculum**: create DTOs and read DTOs for curriculum, education, projects, and related options
- **Common enums**: `UserRoleEnum`, `DrivingLicense`, `ResponseEnum`

## Configuration

### Auto-Configuration Import

Spring Boot discovers commons auto-configuration from:

- `META-INF/spring/org.springframework.boot.autoconfigure.AutoConfiguration.imports`

Current entry:

- `com.certimetergroup.talentos.commons.filter.logendpoint.autoconfigure.LogEndPointAutoConfiguration`

### Logging Filter Property

```properties
commons.log-endpoint.enabled=true
```

- `true`: register request logging filter
- `false`: disable filter registration

## Testing

Run tests with:

```bash
mvn test
```

## Dependencies Management

Dependencies are managed in `pom.xml`.

Resolve and inspect dependency updates with:

```bash
mvn dependency:resolve
mvn versions:display-dependency-updates
```

## Development Guidelines

When extending this module:

1. Preserve backward compatibility of DTO fields whenever possible
2. Add Jakarta Validation annotations for any new externally consumed contracts
3. Keep response/error semantics centralized in `ResponseEnum`
4. Keep reusable infrastructure (filters/utilities/exceptions) generic and service-agnostic
5. Update this README when adding new shared models or auto-configurations

## Contributing

When contributing to this project:

1. Follow existing package structure and naming conventions
2. Keep contracts framework-neutral where possible
3. Avoid business logic tied to a single microservice in commons
4. Ensure consumer impact is considered before changing shared DTOs

## License

MIT License. See [LICENSE](LICENSE) for details.

---

**Developed by Giuseppe Falcone**
