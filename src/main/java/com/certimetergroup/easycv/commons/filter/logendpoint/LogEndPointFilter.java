package com.certimetergroup.easycv.commons.filter.logendpoint;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;

@Component
public class LogEndPointFilter extends OncePerRequestFilter {
    private static final Logger logger = LoggerFactory.getLogger(LogEndPointFilter.class);

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        String endpoint = request.getRequestURI();
        String method = request.getMethod();
        String queryString = (request.getQueryString() == null) ? null : request.getQueryString();
        String methodResponse = String.valueOf(response.getStatus());

        if (logger.isInfoEnabled()) {
            logger.info("---------- START - {} {}", method, endpoint);
            logger.info("endpoint: {}", endpoint);
            logger.info("method: {}", method);
            if (queryString != null)
                logger.info("queryString: {}", queryString);
            logger.info("methodResponse: {}", methodResponse);
        }
        try {
            filterChain.doFilter(request, response);
        } finally {
            logger.info("response: {}", response.getStatus());
            logger.info("---------- END - {} {}", method, endpoint);
        }
    }
}