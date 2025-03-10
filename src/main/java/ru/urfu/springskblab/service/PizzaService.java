package ru.urfu.springskblab.service;

import org.springframework.stereotype.Service;
import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;

@Service
public class PizzaService implements ProductService {

    @PostConstruct
    public void postConstruct() {
        System.out.println("PizzaService is created");
    }

    @PreDestroy
    public void preDestroy() {
        System.out.println("PizzaService is destroyed");
    }

    @Override
    public String buyProduct() {
        return "You bought pizza \uD83C\uDF55";
    }
}

