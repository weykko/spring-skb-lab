package ru.urfu.springskblab.service;

import org.springframework.stereotype.Service;
import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;

@Service
public class SushiService implements ProductService {

    @PostConstruct
    public void postConstruct() {
        System.out.println("SushiService is created");
    }

    @PreDestroy
    public void preDestroy() {
        System.out.println("SushiService is destroyed");
    }

    @Override
    public String buyProduct() {
        return "You bought sushi \uD83C\uDF63";
    }
}