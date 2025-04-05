package ru.urfu.springskblab.service;

import org.springframework.stereotype.Service;
import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class SushiService implements ProductService {

    @PostConstruct
    public void postConstruct() {
        log.info("SushiService is created");
    }

    @PreDestroy
    public void preDestroy() {
        log.info("SushiService is destroyed");
    }

    @Override
    public String buyProduct() {
        return "You bought sushi \uD83C\uDF63";
    }
}