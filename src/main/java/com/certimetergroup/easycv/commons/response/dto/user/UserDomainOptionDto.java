package com.certimetergroup.easycv.commons.response.dto.user;

import jakarta.validation.constraints.NotNull;
import lombok.*;

@Getter
@ToString
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UserDomainOptionDto {
    @NotNull(message = "DomainId cannot be null")
    private Long domainId;

    @NotNull(message = "DomainOptionId cannot be null")
    private Long domainOptionId;

    private int grade;
}

