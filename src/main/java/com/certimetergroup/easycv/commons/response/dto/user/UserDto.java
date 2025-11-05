package com.certimetergroup.easycv.commons.response.dto.user;

import com.certimetergroup.easycv.commons.enumeration.UserRoleEnum;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.util.Set;

@Getter
@Setter
@ToString
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UserDto {
    @NotNull(message = "User id cannot be null")
    private Long userId;

    @NotNull(message = "Username cannot be null")
    private String username;

    @NotNull(message = "Name cannot be null")
    private String firstName;

    @NotNull(message = "Last name cannot be null")
    private String lastName;

    @NotNull(message = "Role cannot be null")
    private UserRoleEnum role;

    @NotNull
    @Email(message = "Email is not valid")
    private String email;

    private Long managerId;

    private Set<Long> employeeIds;

    @Valid
    private Set<UserDomainOptionDto> userDomainOptions;
}
