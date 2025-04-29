package ru.urfu.springskblab.config;

import lombok.Getter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

@Getter
@Configuration
public class RateLimitConfig {
    @Value("${config.max-requests}")
    private Long maxRequests;

}
