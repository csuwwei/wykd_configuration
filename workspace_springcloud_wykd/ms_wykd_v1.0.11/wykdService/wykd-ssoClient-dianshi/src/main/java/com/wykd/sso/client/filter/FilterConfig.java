package com.wykd.sso.client.filter;

import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class FilterConfig {
 
    @Bean
    public FilterRegistrationBean registFilter() {
        FilterRegistrationBean registration = new FilterRegistrationBean();
        registration.setFilter(new DianshiFilter());
        registration.addUrlPatterns("/*");
        registration.setName("DianshiFilter");
        registration.setOrder(1);
        return registration;
    }
 
}
