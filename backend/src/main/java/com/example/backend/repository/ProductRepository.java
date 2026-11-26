package com.example.backend.repository;

import com.example.backend.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends JpaRepository<Product,Long> {
    //JpaRepositoryを継承するとfindAll()やsave()などの基本的なCRUD操作が自動的に提供されます。
}