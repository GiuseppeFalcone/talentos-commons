package com.certimetergroup.easycv.commons.filter;

import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConditionalOnProperty(prefix = "my.logging", name = "enabled", havingValue = "true", matchIfMissing = true)
public class LogEndPointAutoConfiguration {

    @Bean
    public LogEndPointFilter logEndpointFilter() {
        return new LogEndPointFilter();
    }
}