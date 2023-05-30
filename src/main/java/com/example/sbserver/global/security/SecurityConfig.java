package com.example.sbserver.global.security;

import com.example.sbserver.domain.user.domain.Role;
import com.example.sbserver.global.config.FilterConfig;
import com.example.sbserver.global.security.jwt.JwtParser;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@RequiredArgsConstructor
@Configuration
@EnableWebSecurity
public class SecurityConfig {
    private final ObjectMapper objectMapper;
    private final JwtParser jwtParser;


    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        return http
                .csrf().disable()
                .formLogin().disable()
                .cors()

                .and()
                .authorizeRequests()
                .antMatchers("/users/anonymous").permitAll()
                .antMatchers("/users/token").permitAll()
                .antMatchers(HttpMethod.PATCH, "/users").hasRole(Role.MEMBER.name())
                .anyRequest()
                .authenticated()

                .and()
                .apply(new FilterConfig(jwtParser, objectMapper))
                .and().build();
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}