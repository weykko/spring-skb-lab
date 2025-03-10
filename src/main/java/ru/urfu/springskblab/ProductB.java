package ru.urfu.springskblab;

import org.springframework.stereotype.Component;
import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;

@Component
public class ProductB implements ProductService {

    @PostConstruct
    public void init() {
        System.out.println("ProductB is created");
    }

    @PreDestroy
    public void destroy() {
        System.out.println("ProductB is destroyed");
    }

    @Override
    public void buyProduct() {
        System.out.println("Buying Product B");
    }
}
