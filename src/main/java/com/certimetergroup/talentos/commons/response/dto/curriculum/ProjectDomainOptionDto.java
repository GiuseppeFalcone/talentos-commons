package com.certimetergroup.talentos.commons.response.dto.curriculum;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ProjectDomainOptionDto {
    private Long projectDomainId;

    @NotNull(message = "DomainId cannot be null")
    private Long domainId;

    @NotNull(message = "DomainOptionId cannot be null")
    private Long domainOptionId;

    @NotNull(message = "UserId cannot be null")
    private Long userId;

    @NotNull(message = "Grade cannot be null")
    @Min(value = 0, message = "Grade must be at least 0")
    @Max(value = 5, message = "Grade must be at most 5")
    private Integer grade;
}
