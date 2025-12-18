package com.certimetergroup.talentos.commons.response.dto.domain;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.util.HashSet;
import java.util.Set;

@Builder
@Getter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class CreateDomainDto {
    @NotNull(message = "Domain name not provided")
    @NotBlank(message = "Domain name not provided")
    @EqualsAndHashCode.Include
    private String domainName;

    @Builder.Default
    private Set<String> domainOptions = new HashSet<>();
}
