package com.certimetergroup.easycv.commons.response;

import com.certimetergroup.easycv.commons.enums.ResponseEnum;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter @Setter @ToString
public class PayloadResponse<T> extends Response {
    private final T payload;

    public PayloadResponse(ResponseEnum responseEnum, T payload) {
        super(responseEnum);
        this.payload = payload;
    }
}

