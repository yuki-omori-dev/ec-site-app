package com.example.backend.service;

import com.example.backend.entity.Product;
import com.example.backend.repository.ProductRepository;
import org.springframework.transaction.annotation.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductService {
    private final ProductRepository productRepository;

    // 商品一覧を取得する業務処理
    @Transactional(readOnly = true)
    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    // 商品を新規登録する業務処理（ビジネスルールチェック付き）
    @Transactional
    public Product createProduct(Product product) {
        // 例：価格や在庫がマイナスにならないように業務ルールをチェックする
        if (product.getPrice() < 0) {
            throw new IllegalArgumentException("価格は0円以上である必要があります");
        }
        if (product.getStock() < 0) {
            throw new IllegalArgumentException("在庫数は0個以上である必要があります");
        }
        return productRepository.save(product);
    }
}
