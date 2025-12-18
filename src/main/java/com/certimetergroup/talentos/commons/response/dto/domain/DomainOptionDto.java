package com.certimetergroup.talentos.commons.response.dto.domain;

import lombok.*;

@Builder
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class DomainOptionDto {
    private Long domainOptionId;
    private String value;
}
