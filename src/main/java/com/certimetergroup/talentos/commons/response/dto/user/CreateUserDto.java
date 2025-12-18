package com.certimetergroup.talentos.commons.response.dto.user;

import com.certimetergroup.talentos.commons.enumeration.UserRoleEnum;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Builder;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CreateUserDto {
    @NotNull(message = "Name cannot be null")
    private String firstName;

    @NotNull(message = "Last name cannot be null")
    private String lastName;

    @NotNull(message = "Role cannot be null")
    private UserRoleEnum role;

    private Long managerId;

    @NotNull
    @Email(message = "Email is not valid", regexp = "[A-Za-z0-9._]+@company.com$")
    private String email;
}
