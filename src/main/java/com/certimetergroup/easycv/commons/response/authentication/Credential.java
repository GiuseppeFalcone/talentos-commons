package com.certimetergroup.easycv.commons.response.authentication;

import jakarta.validation.constraints.NotBlank;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Builder
@Getter
@Setter
public class Credential {
    @NotBlank(message = "username required")
    private String username;

    @NotBlank(message = "password required")
    private String password;
}
