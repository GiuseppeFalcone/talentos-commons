package com.certimetergroup.easycv.commons.filter.logendpoint.autoconfigure;

import com.certimetergroup.easycv.commons.filter.logendpoint.LogEndPointFilter;
import jakarta.servlet.DispatcherType;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.Ordered;

@Configuration
@ConditionalOnProperty(prefix = "commons.log-endpoint", name = "enabled", havingValue = "true", matchIfMissing = true)
public class LogEndPointAutoConfiguration {

    @Bean
    public FilterRegistrationBean<LogEndPointFilter> logEndpointFilter() {
        FilterRegistrationBean<LogEndPointFilter> registrationBean = new FilterRegistrationBean<>(new LogEndPointFilter());
        registrationBean.addUrlPatterns("/*");
        registrationBean.setOrder(Ordered.LOWEST_PRECEDENCE);
        registrationBean.setDispatcherTypes(DispatcherType.REQUEST);
        return registrationBean;
    }
}