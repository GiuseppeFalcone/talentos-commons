package com.certimetergroup.easycv.commons.response.dto.curriculum.create;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PastOrPresent;
import jakarta.validation.constraints.PositiveOrZero;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDate;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CreateEducationDto {
    private Long schoolNameId;

    private Long degreeNameId;

    @PositiveOrZero(message = "Grade must be zero or positive")
    private BigDecimal grade;

    @PositiveOrZero(message = "Max grade must be zero or positive")
    private BigDecimal maxGrade;

    @NotNull(message = "Start date cannot be null")
    @PastOrPresent(message = "Start date must be in the past or present")
    private LocalDate startDate;

    @PastOrPresent(message = "End date must be in the past or present")
    private LocalDate endDate;
}