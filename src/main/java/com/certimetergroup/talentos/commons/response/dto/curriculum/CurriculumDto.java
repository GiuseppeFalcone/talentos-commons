package com.certimetergroup.talentos.commons.response.dto.curriculum;

import com.certimetergroup.talentos.commons.enumeration.DrivingLicense;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.Set;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CurriculumDto {
    @NotNull(message = "Curriculum ID cannot be null")
    private Long curriculumId;

    @NotNull(message = "User ID cannot be null")
    private Long userId;

    @Size(max = 255, message = "Mobile phone max length is 255")
    private String mobilePhone;

    @Size(max = 255, message = "Home address max length is 255")
    private String homeAddress;

    @Size(max = 255, message = "Work address max length is 255")
    private String workAddress;

    private Boolean maritalStatus;

    private DrivingLicense drivingLicense;

    private Boolean hasCar;

    private Boolean openForTravel;

    private String summary;

    private LocalDateTime lastModifiedAt;

    @Valid
    private Set<EducationDto> educationHistory;

    @Valid
    private Set<ProjectDto> projects;

    @Valid
    private Set<ProjectDomainOptionDto> domainOptions;
}