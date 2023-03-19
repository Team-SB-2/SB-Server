package com.example.sbserver.global.config;

import com.example.sbserver.global.security.jwt.JwtProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

@EnableConfigurationProperties(value = {JwtProperties.class, RedisConfig.class})
public class EnableConfigurationPropertiesConfig {
}