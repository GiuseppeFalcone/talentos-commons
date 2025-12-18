package com.certimetergroup.talentos.commons.response.dto.curriculum.create;

import com.certimetergroup.talentos.commons.enumeration.DrivingLicense;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CreateCurriculumDto {

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

    @Valid
    private Set<CreateEducationDto> educationHistory;

    @Valid
    private Set<CreateProjectDto> projects;

    @Valid
    private Set<CreateProjectDomainOptionDto> domainOptions;
}
