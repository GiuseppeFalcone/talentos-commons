package com.certimetergroup.easycv.commons.dto;


import com.certimetergroup.easycv.commons.enumeration.ResponseEnum;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;
import lombok.Builder;
import lombok.AllArgsConstructor;

import java.time.LocalDateTime;

@Data
@Builder
@AllArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Response<T> {
    private int code;
    @Builder.Default
    private LocalDateTime timestamp = LocalDateTime.now();
    private String message;
    private T data;

    public Response(ResponseEnum responseEnum) {
        this.code = responseEnum.code;
        this.message = responseEnum.message;
        this.timestamp = LocalDateTime.now();
        this.data = null;
    }

    public Response(ResponseEnum responseEnum, T data) {
        this.code = responseEnum.code;
        this.timestamp = LocalDateTime.now();
        this.message = responseEnum.message;
        this.data = data;
    }
}
