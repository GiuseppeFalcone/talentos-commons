package com.certimetergroup.talentos.commons.exception;

import com.certimetergroup.talentos.commons.enumeration.ResponseEnum;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter @Setter @ToString
public class FailureException extends RuntimeException {
    private ResponseEnum responseEnum;
    private Exception exception;

    public FailureException(ResponseEnum responseEnum) {
        super(responseEnum.message);
        this.responseEnum = responseEnum;
        this.exception = null;
    }

    public FailureException(ResponseEnum responseEnum, Exception exception) {
        super(exception.getMessage());
        this.responseEnum = responseEnum;
        this.exception = exception;
    }

    public FailureException(ResponseEnum responseEnum, String message) {
        super(message);
        this.responseEnum = responseEnum;
        this.exception = null;
    }
}
