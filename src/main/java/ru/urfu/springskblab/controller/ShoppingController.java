package ru.urfu.springskblab.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import ru.urfu.springskblab.service.PizzaService;
import ru.urfu.springskblab.service.BurgerService;
import ru.urfu.springskblab.service.SushiService;

@RestController
public class ShoppingController {

    // Dependency Injection через конструктор
    private final PizzaService pizzaService;

    @Autowired
    public ShoppingController(PizzaService pizzaService) {
        this.pizzaService = pizzaService;
    }

    // Dependency Injection через поле
    @Autowired
    private BurgerService burgerService;

    // Dependency Injection через сеттер
    private SushiService sushiService;

    @Autowired
    public void setSushiService(SushiService sushiService) {
        this.sushiService = sushiService;
    }

    // Метод покупки через GET-запрос
    @GetMapping("/buy")
    public String buy(@RequestParam String productName) {
        System.out.println("Purchasing in progress...");

        return switch (productName.toLowerCase()) {
            case "pizza" -> pizzaService.buyProduct();
            case "burger" -> burgerService.buyProduct();
            case "sushi" -> sushiService.buyProduct();
            default -> "Error! This product was not found";
        };
    }
}
