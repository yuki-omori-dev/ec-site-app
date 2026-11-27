package com.example.backend.controller;

import com.example.backend.entity.Product;
import com.example.backend.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/products")
@RequiredArgsConstructor

public class ProductController {
    private final ProductService productService;

    //GETリクエストが来たら商品一覧を取得するAPI(GET http://localhost:8080/api/products)
    @GetMapping
    public List<Product> getAllProducts() {
        return productService.getAllProducts();
    }

    //Postリクエストが来たら商品を追加するAPI(POST http://localhost:8080/api/products)
    @PostMapping
    public Product createProduct(@RequestBody Product product) {
        return productService.createProduct(product);
    }
}
