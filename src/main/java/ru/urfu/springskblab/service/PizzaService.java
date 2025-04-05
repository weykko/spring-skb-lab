package ru.urfu.springskblab.service;

import org.springframework.stereotype.Service;
import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class PizzaService implements ProductService {

    @PostConstruct
    public void postConstruct() {
        log.info("PizzaService is created");
    }

    @PreDestroy
    public void preDestroy() {
        log.info("PizzaService is destroyed");
    }

    @Override
    public String buyProduct() {
        return "You bought pizza \uD83C\uDF55";
    }
}

