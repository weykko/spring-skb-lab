package ru.urfu.springskblab.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Data
@Configuration
@ConfigurationProperties(prefix = "rate-limit")
public class RateLimitConfig {
    private Long countOfRequests;
    private Long windowToCheck;
}
