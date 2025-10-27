package com.certimetergroup.easycv.commons.enums;

import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;

@AllArgsConstructor
public enum ResponseEnum {
    SUCCESS (200, "success", HttpStatus.OK),
    BAD_REQUEST (400, "Invalid Request", HttpStatus.BAD_REQUEST),
    UNAUTHORIZED (401, "Invalid password", HttpStatus.UNAUTHORIZED),
    FORBIDDEN (403, "access forbidden, user does not have required role", HttpStatus.FORBIDDEN),
    RESOURCE_NOT_FOUND (404, "resource not found", HttpStatus.NOT_FOUND),
    INTERNAL_SERVER_ERROR(500, "internal server error", HttpStatus.INTERNAL_SERVER_ERROR),
    NOT_IMPLEMENTED (501, "request method not implemented", HttpStatus.NOT_IMPLEMENTED),
    DATABASE_ERROR (1500, "database error", HttpStatus.INTERNAL_SERVER_ERROR),
    PASSWORD_ERROR (4700, "password processing error", HttpStatus.INTERNAL_SERVER_ERROR);

    public final int code;
    public final String description;
    public final HttpStatus httpStatus;
}
