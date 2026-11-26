package com.example.backend.controller;

import com.example.backend.entity.Product;
import com.example.backend.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/products")
@RequiredArgsConstructor

public class ProductController {
    private final ProductRepository productRepository;

    //GETリクエストが来たら商品一覧を取得するAPI(GET http://localhost:8080/api/products)
    @GetMapping
    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    //Postリクエストが来たら商品を追加するAPI(POST http://localhost:8080/api/products)
    @PostMapping
    public Product createProduct(@RequestBody Product product) {
        return productRepository.save(product);
    }
}
