package com.certimetergroup.talentos.commons.response.authentication;

import jakarta.validation.constraints.NotBlank;
import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class RefreshToken {
    @NotBlank(message = "Refresh Token required")
    String refreshToken;
}