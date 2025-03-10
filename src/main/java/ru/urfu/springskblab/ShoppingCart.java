package ru.urfu.springskblab;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ShoppingCart {

    // Dependency Injection через конструктор
    private final ProductA productService;

    @Autowired
    public ShoppingCart(ProductA productService) {
        this.productService = productService;
    }

    // Dependency Injection через поле
    @Autowired
    private ProductB anotherProductService;

    // Dependency Injection через сеттер
    private ProductA setterProductService;

    @Autowired
    public void setSetterProductService(ProductA setterProductService) {
        this.setterProductService = setterProductService;
    }

    public void checkout() {
        System.out.println("Checking out...");

        // Логика покупок для разных сервисов
        productService.buyProduct();
        anotherProductService.buyProduct();
        setterProductService.buyProduct();
    }
}
