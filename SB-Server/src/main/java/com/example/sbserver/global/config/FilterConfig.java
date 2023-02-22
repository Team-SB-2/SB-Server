package com.example.sbserver.global.config;

import com.example.sbserver.global.error.ExceptionFilter;
import com.example.sbserver.global.security.jwt.JwtParser;
import com.example.sbserver.global.security.jwt.JwtTokenFilter;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.security.config.annotation.SecurityConfigurerAdapter;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.DefaultSecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@RequiredArgsConstructor
public class FilterConfig extends SecurityConfigurerAdapter<DefaultSecurityFilterChain, HttpSecurity> {

    private final JwtParser jwtParser;
    private final ObjectMapper objectMapper;

    @Override
    public void configure(HttpSecurity builder) {
        builder.addFilterBefore(new JwtTokenFilter(jwtParser), UsernamePasswordAuthenticationFilter.class);
        builder.addFilterBefore(new ExceptionFilter(objectMapper), JwtTokenFilter.class);
    }
}