package com.certimetergroup.easycv.commons.response;

import com.certimetergroup.easycv.commons.enums.ResponseEnum;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.*;

import java.time.LocalDateTime;

@JsonInclude(JsonInclude.Include.NON_NULL)
@Getter @Setter @ToString
@AllArgsConstructor @NoArgsConstructor
public class Response {
    private int code;
    private LocalDateTime timestamp;
    private String message;

    public Response(ResponseEnum responseEnum) {
        this.code = responseEnum.code;
        this.timestamp = LocalDateTime.now();
        this.message = responseEnum.description;
    }
}
