package com.certimetergroup.talentos.commons.utility;

import com.certimetergroup.talentos.commons.enumeration.ResponseEnum;
import com.certimetergroup.talentos.commons.exception.FailureException;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.web.servlet.HandlerMapping;

import java.util.Map;
import java.util.Optional;

public class HttpHeaderUtil {
    public static String sanitizeAccessToken(String accessToken) {
        try {
            return accessToken.startsWith("Bearer ") ? accessToken.substring(7).trim() : accessToken.trim();
        } catch (NullPointerException exception) {
            throw new FailureException(ResponseEnum.JWT_NOT_PRESENT, exception);
        }
    }

    public static Optional<String> getPathVariableFromRequest(HttpServletRequest request, String pathVariableName) {
        Map<String, String> pathVariables = (Map<String, String>) request.getAttribute(
                HandlerMapping.URI_TEMPLATE_VARIABLES_ATTRIBUTE );
        return Optional.of(pathVariables.get(pathVariableName));
    }
}
