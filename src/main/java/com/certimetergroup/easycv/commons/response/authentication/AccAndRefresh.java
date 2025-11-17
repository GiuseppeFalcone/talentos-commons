package com.certimetergroup.easycv.commons.response.authentication;

import lombok.*;

@Getter
@Builder
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class AccAndRefresh {
    private String accessToken;
    private String refreshToken;
}
