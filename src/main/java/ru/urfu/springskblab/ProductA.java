package ru.urfu.springskblab;

import org.springframework.stereotype.Component;
import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;

@Component
public class ProductA implements ProductService {

    @PostConstruct
    public void init() {
        System.out.println("ProductA is created");
    }

    @PreDestroy
    public void destroy() {
        System.out.println("ProductA is destroyed");
    }

    @Override
    public void buyProduct() {
        System.out.println("Buying Product A");
    }
}

