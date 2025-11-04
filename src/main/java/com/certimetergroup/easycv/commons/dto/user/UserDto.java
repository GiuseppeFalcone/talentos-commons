package com.certimetergroup.easycv.commons.dto.user;

import com.certimetergroup.easycv.commons.enumeration.UserRoleEnum;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import lombok.*;
import lombok.experimental.SuperBuilder;

import java.util.Set;

@Getter @Setter @ToString
@SuperBuilder
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

    private Set<UserDomainOptionDto> userDomainOptions;
}
