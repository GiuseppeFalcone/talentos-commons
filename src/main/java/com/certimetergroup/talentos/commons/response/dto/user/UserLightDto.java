package com.certimetergroup.talentos.commons.response.dto.user;

import com.certimetergroup.talentos.commons.enumeration.UserRoleEnum;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;

@Getter
@Setter
@ToString
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UserLightDto {
    @NotNull(message = "User id cannot be null")
    private Long userId;

    @NotBlank(message = "Username cannot be blank")
    private String username;

    @NotBlank(message = "Name cannot be blank")
    private String firstName;

    @NotBlank(message = "lastName cannot be blank")
    private String lastName;

    @NotNull
    private UserRoleEnum role;

    private String email;

    private String refreshToken;
}
