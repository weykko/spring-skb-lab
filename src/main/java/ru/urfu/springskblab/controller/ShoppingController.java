package ru.urfu.springskblab.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import ru.urfu.springskblab.service.BuyingService;

@RestController
@RequiredArgsConstructor
public class ShoppingController {

    private final BuyingService buyingService;

    // Метод покупки через GET-запрос
    @GetMapping("/buy")
    public String buy(@RequestParam String productName) {
        return buyingService.buy(productName);
    }
}
