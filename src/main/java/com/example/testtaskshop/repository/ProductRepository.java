package com.example.testtaskshop.repository;

import com.example.testtaskshop.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

@Component
public interface ProductRepository extends JpaRepository<Product, Integer> {
}
