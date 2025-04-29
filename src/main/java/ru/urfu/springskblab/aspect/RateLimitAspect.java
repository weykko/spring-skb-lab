package ru.urfu.springskblab.aspect;

import lombok.RequiredArgsConstructor;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;
import ru.urfu.springskblab.config.RateLimitConfig;
import ru.urfu.springskblab.exception.RateLimitException;
import ru.urfu.springskblab.service.RequestService;

@Aspect
@Component
@RequiredArgsConstructor
public class RateLimitAspect {

    private final RequestService requestService;

    private final RateLimitConfig rateLimitConfig;

    @Before("@annotation(RateLimit)")
    public void beforeRateLimit() {
        if (requestService.getRequestCount() >= rateLimitConfig.getMaxRequests()) {
            throw new RateLimitException("Too many requests");
        }
    }
}
