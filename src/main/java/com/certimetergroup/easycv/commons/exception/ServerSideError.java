package com.certimetergroup.easycv.commons.exception;

import com.certimetergroup.easycv.commons.enums.ResponseEnum;

public class ServerSideError extends RuntimeException {
    private final ResponseEnum responseEnum;

    public ServerSideError(ResponseEnum responseEnum) {
        super();
        this.responseEnum = responseEnum;
    }

    public ServerSideError(ResponseEnum responseEnum, String message) {
        super(message);
        this.responseEnum = responseEnum;
    }
}
