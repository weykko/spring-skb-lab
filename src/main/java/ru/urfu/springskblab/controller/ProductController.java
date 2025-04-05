package ru.urfu.springskblab.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import ru.urfu.springskblab.dto.ProductRequest;
import ru.urfu.springskblab.dto.ProductResponse;
import ru.urfu.springskblab.exception.CustomBadGatewayException;
import ru.urfu.springskblab.service.ProductService;

@RequiredArgsConstructor
@Controller
@RequestMapping("/product")
public class ProductController {

    private final ProductService productService;

    @PostMapping
    public ProductResponse addProduct(@RequestBody ProductRequest productRequest) {
        return productService.addProduct(productRequest);
    }

    @GetMapping("/502")
    public void get502Error() {
        throw new CustomBadGatewayException("ERROR! \uD83D\uDEAB\uD83D\uDEAB\uD83D\uDEAB");
    }
}
