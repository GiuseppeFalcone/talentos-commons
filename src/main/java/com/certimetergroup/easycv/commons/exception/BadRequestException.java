package com.certimetergroup.easycv.commons.exception;

import com.certimetergroup.easycv.commons.enums.ResponseEnum;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter @Setter @ToString
public class BadRequestException extends RuntimeException {
    private final ResponseEnum responseEnum;

    public BadRequestException(String message) {
        super(message);
        this.responseEnum = ResponseEnum.BAD_REQUEST;
    }
}
