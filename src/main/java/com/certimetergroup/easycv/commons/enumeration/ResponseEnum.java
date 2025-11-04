package com.certimetergroup.easycv.commons.enumeration;

import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;

@AllArgsConstructor
public enum ResponseEnum {
    SUCCESS(200, "Success", HttpStatus.OK),
    CREATED(201, "Created", HttpStatus.CREATED),

    BAD_REQUEST(400, "Invalid request", HttpStatus.BAD_REQUEST),
    FORBIDDEN(401, "Invalid credentials", HttpStatus.UNAUTHORIZED),
    UNAUTHORIZED(403, "Access forbidden, user does not have required role", HttpStatus.FORBIDDEN),
    NOT_FOUND(404, "Resource not found", HttpStatus.NOT_FOUND),
    ALREADY_EXISTS(409, "Resource alredy exists in database", HttpStatus.CONFLICT),

    INTERNAL_SERVER_ERROR(500, "Internal server error", HttpStatus.INTERNAL_SERVER_ERROR),
    DATABASE_ERROR(1500, "Database error", HttpStatus.INTERNAL_SERVER_ERROR),
    PASSWORD_ERROR(4700, "Password processing error", HttpStatus.INTERNAL_SERVER_ERROR),
    JWT_EXPIRED(4011, "Token has expired", HttpStatus.FORBIDDEN),
    JWT_NOT_YET_VALID(4012, "Token not yet valid", HttpStatus.FORBIDDEN),
    JWT_INVALID_SIGNATURE(4013, "Signature not valid", HttpStatus.FORBIDDEN),
    JWT_MALFORMED(4014, "Token not correctly formed", HttpStatus.FORBIDDEN),
    JWT_UNSUPPORTED(4015, "Token unsupported", HttpStatus.FORBIDDEN),
    JWT_INCORRECT_CLAIMS(4016, "Claims not correct", HttpStatus.FORBIDDEN),
    JWT_INVALID(4017, "Token is invalid", HttpStatus.FORBIDDEN),
    JWT_NOT_PRESENT(4018, "No token in Authentication header", HttpStatus.FORBIDDEN),

    EXTERNAL_SERVER_ERROR(6001, "External service timeout", HttpStatus.GATEWAY_TIMEOUT),

    REMOTE_BAD_REQUEST(7001, "Remote service bad request", HttpStatus.BAD_REQUEST),
    REMOTE_UNAUTHORIZED(7002, "Remote service unauthorized", HttpStatus.UNAUTHORIZED),
    REMOTE_FORBIDDEN(7003, "Remote service forbidden", HttpStatus.FORBIDDEN),
    REMOTE_NOT_FOUND(7004, "Remote resource not found", HttpStatus.NOT_FOUND),
    REMOTE_SERVER_ERROR(7005, "Remote service internal error", HttpStatus.INTERNAL_SERVER_ERROR);

    public final int code;
    public final String message;
    public final HttpStatus httpStatus;
}
