package ru.urfu.springskblab.service;

import org.springframework.stereotype.Service;
import ru.urfu.springskblab.dto.ProductRequest;
import ru.urfu.springskblab.dto.ProductResponse;
import ru.urfu.springskblab.entity.Product;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProductService {

    private final static List<Product> DATABASE = new ArrayList<>();
    private static Long idCounter = 0L;

    public ProductResponse addProduct(ProductRequest productRequest) {
        Product product = new Product(idCounter++, productRequest.getPrice(), productRequest.getInfo().getDate());
        DATABASE.add(product);

        return toProductResponse(product);
    }

    private ProductResponse toProductResponse(Product product) {
        ProductResponse response = new ProductResponse();
        response.setPrice(product.getPrice());
        ProductResponse.Info info = new ProductResponse.Info();
        info.setId(product.getId());
        info.setDate(product.getDate());
        response.setInfo(info);

        return response;
    }
}
