package com.amaristest.amaristest.infrastructure.configuration;

import feign.RequestInterceptor;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class FeignConfiguration {

    @Bean
    public RequestInterceptor tokenFromCookieInterceptor(@Autowired HttpServletRequest request) {
        return template -> {
            Cookie[] cookies = request.getCookies();
            if (cookies != null) {
                for (Cookie cookie : cookies) {
                    if ("accessToken".equals(cookie.getName())) {
                        template.header("Authorization", "Bearer " + cookie.getValue());
                        break;
                    }
                }
            }
        };
    }
}
