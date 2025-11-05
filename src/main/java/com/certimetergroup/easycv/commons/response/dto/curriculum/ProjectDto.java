package com.certimetergroup.easycv.commons.response.dto.curriculum;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PastOrPresent;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.Set;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ProjectDto {
    private Long projectId;

    @NotNull(message = "Start date cannot be null")
    @PastOrPresent(message = "Start date must be in the past or present")
    private LocalDate startDate;

    @PastOrPresent(message = "End date must be in the past or present")
    private LocalDate endDate;

    @NotEmpty(message = "Description cannot be empty")
    private String description;

    @Valid
    private Set<ProjectDomainOptionDto> domainOptions;
}