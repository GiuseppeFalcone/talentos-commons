package com.certimetergroup.talentos.commons.response.dto.curriculum;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CurriculumLightDto {
    @NotNull(message = "Curriculum ID cannot be null")
    private Long curriculumId;

    @NotNull(message = "User ID cannot be null")
    private Long userId;

    @NotNull(message = "Last Modified Date Time cannot be null")
    private LocalDateTime lastModifiedAt;

    private Boolean hasCar;

    private Boolean openForTravel;

    private Integer numberOfProjects;

    private Boolean hasDegree;
}
