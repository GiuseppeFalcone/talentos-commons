# Talentos Commons

A shared Java library for the Talentos platform, providing common components, DTOs, utilities, and filters for Spring Boot applications.

## Overview

This library contains reusable components for the Talentos ecosystem, including:

- **DTOs (Data Transfer Objects)**: Standardized data structures for users, curriculums, domains, and authentication
- **Response Handling**: Consistent API response formatting with status codes and error handling
- **Authentication**: JWT token utilities and authentication-related DTOs
- **Exception Handling**: Custom exception classes for standardized error management
- **Filters**: HTTP request/response logging filters
- **Utilities**: Helper classes for common operations

## Features

### Response Management
- `Response<T>`: Generic response wrapper with code, timestamp, message, and data
- `ResponseEnum`: Predefined response codes and HTTP status mappings
- Support for success, error, and custom response types

### DTOs
- **User Management**: UserDto, CreateUserDto, UserLightDto, UserDomainOptionDto
- **Curriculum Management**: CurriculumDto, EducationDto, ProjectDto
- **Domain Management**: DomainDto, DomainOptionDto
- **Authentication**: LoginResponse, RefreshToken, Credential, AccAndRefresh

### Exception Handling
- `FailureException`: Custom runtime exception with ResponseEnum integration
- Standardized error messages and status codes

### Filters
- `LogEndPointFilter`: HTTP request/response logging filter
- Auto-configuration support for Spring Boot applications

### Utilities
- `HttpHeaderUtil`: JWT token sanitization and path variable extraction

## Technologies

- **Java**: 25
- **Spring Boot**: 3.5.6
- **Jakarta Persistence API**: 3.2.0
- **Jakarta Validation API**: 3.1.1
- **Lombok**: 1.18.42
- **MapStruct**: 1.6.3
- **JJWT**: 0.13.0 (JSON Web Token support)

## Installation

### Maven

Add this dependency to your `pom.xml`:

```xml
<dependency>
    <groupId>com.certimetergroup.talentos</groupId>
    <artifactId>commons</artifactId>
    <version>0.0.1-SNAPSHOT</version>
</dependency>
```

## Building the Project

### Prerequisites
- Java 25 or higher
- Maven 3.6+

### Build Commands

```bash
# Clean and compile
mvn clean compile

# Run tests
mvn test

# Package
mvn package

# Install to local repository
mvn clean install
```

## Usage Examples

### Using Response Wrapper

```java
import com.certimetergroup.talentos.commons.response.Response;
import com.certimetergroup.talentos.commons.enumeration.ResponseEnum;

// Success response with data
Response<UserDto> response = new Response<>(ResponseEnum.SUCCESS, userDto);

// Error response
Response<Void> errorResponse = new Response<>(ResponseEnum.NOT_FOUND);
```

### Using Custom Exception

```java
import com.certimetergroup.talentos.commons.exception.FailureException;
import com.certimetergroup.talentos.commons.enumeration.ResponseEnum;

// Throw custom exception
throw new FailureException(ResponseEnum.NOT_FOUND);

// With custom message
throw new FailureException(ResponseEnum.BAD_REQUEST, "Invalid user ID");
```

### JWT Token Sanitization

```java
import com.certimetergroup.talentos.commons.utility.HttpHeaderUtil;

// Remove "Bearer " prefix from token
String token = HttpHeaderUtil.sanitizeAccessToken(authHeader);
```

### Using DTOs

```java
import com.certimetergroup.talentos.commons.response.dto.user.UserDto;

UserDto user = UserDto.builder()
    .userId(1L)
    .username("john.doe")
    .firstName("John")
    .lastName("Doe")
    .email("john.doe@example.com")
    .role(UserRoleEnum.USER)
    .build();
```

## Response Codes

The library includes predefined response codes:

| Code | Message | HTTP Status |
|------|---------|-------------|
| 200 | Success | OK |
| 201 | Created | CREATED |
| 400 | Invalid request | BAD_REQUEST |
| 401 | Invalid credentials | UNAUTHORIZED |
| 403 | Access forbidden | FORBIDDEN |
| 404 | Resource not found | NOT_FOUND |
| 409 | Resource already exists | CONFLICT |
| 500 | Internal server error | INTERNAL_SERVER_ERROR |
| 4011-4018 | JWT-related errors | FORBIDDEN |
| 6001 | External service timeout | GATEWAY_TIMEOUT |
| 7001-7005 | Remote service errors | Various |

## Project Structure

```
src/main/java/com/certimetergroup/talentos/commons/
├── enumeration/          # Enumerations (ResponseEnum, UserRoleEnum, DrivingLicense)
├── exception/            # Custom exceptions
├── filter/               # HTTP filters
│   └── logendpoint/      # Endpoint logging filter
├── response/             # Response models and DTOs
│   ├── authentication/   # Authentication DTOs
│   └── dto/             # Data Transfer Objects
│       ├── curriculum/   # Curriculum-related DTOs
│       ├── domain/       # Domain-related DTOs
│       └── user/         # User-related DTOs
└── utility/              # Utility classes
```

## Contributing

This is a shared library. Please ensure:
- All changes are backward compatible
- Code follows existing patterns and conventions
- DTOs include proper validation annotations
- Response codes are added to ResponseEnum when needed

## License

This project is licensed under the MIT License.
