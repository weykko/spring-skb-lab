package ru.urfu.springskblab.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class BuyingService {

    // Dependency Injection через конструктор (осуществляется через @RequiredArgsConstructor)
    private final PizzaService pizzaService;

    // Dependency Injection через поле
    @Autowired
    private BurgerService burgerService;

    // Dependency Injection через сеттер
    private SushiService sushiService;

    @Autowired
    public void setSushiService(SushiService sushiService) {
        this.sushiService = sushiService;
    }

    public String buy(String productName){
        log.info("Purchasing in progress...");

        return switch (productName.toLowerCase()) {
            case "pizza" -> pizzaService.buyProduct();
            case "burger" -> burgerService.buyProduct();
            case "sushi" -> sushiService.buyProduct();
            default -> "Error! This product was not found";
        };
    }
}
