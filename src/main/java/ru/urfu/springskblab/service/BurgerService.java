package ru.urfu.springskblab.service;

import org.springframework.stereotype.Component;
import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
public class BurgerService implements ProductService {

    @PostConstruct
    public void postConstruct() {
        log.info("BurgerService is created");
    }

    @PreDestroy
    public void preDestroy() {
        log.info("BurgerService is destroyed");
    }

    @Override
    public String buyProduct() {
        return "You bought burger \uD83C\uDF54";
    }
}
