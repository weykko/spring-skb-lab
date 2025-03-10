package ru.urfu.springskblab.service;

import org.springframework.stereotype.Component;
import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;

@Component
public class BurgerService implements ProductService {

    @PostConstruct
    public void postConstruct() {
        System.out.println("BurgerService is created");
    }

    @PreDestroy
    public void preDestroy() {
        System.out.println("BurgerService is destroyed");
    }

    @Override
    public String buyProduct() {
        return "You bought burger \uD83C\uDF54";
    }
}
