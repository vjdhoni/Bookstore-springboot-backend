package com.apiplatform.bookstore.config;

import com.apiplatform.bookstore.dtos.JwtClaimsDTO;
import com.apiplatform.bookstore.interceptors.JwtInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.context.annotation.RequestScope;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class CustomWebConfig implements WebMvcConfigurer  {

    @Autowired
    private JwtInterceptor jwtInterceptor;

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(jwtInterceptor);
    }

    @Bean
    @RequestScope
    public JwtClaimsDTO getJwtClaimsDTO() {
        return new JwtClaimsDTO();
    }

    @Bean
    public JwtInterceptor jwtClaimsDTO() {
        return new JwtInterceptor(getJwtClaimsDTO());
    }
}
