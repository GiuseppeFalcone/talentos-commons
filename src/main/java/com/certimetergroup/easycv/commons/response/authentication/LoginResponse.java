package com.certimetergroup.easycv.commons.response.authentication;

import com.certimetergroup.easycv.commons.response.dto.user.UserLightDto;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import lombok.*;

@Getter
@Builder
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class LoginResponse {
    @Valid
    private UserLightDto userLightDto;

    @NotBlank
    private String accessToken;

    @NotBlank
    private String refreshToken;
}
