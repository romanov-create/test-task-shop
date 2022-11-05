package com.example.testtaskshop.service;

import com.example.testtaskshop.model.Product;

import java.util.List;

public interface ProductService {
    List<Product> getAllWithoutRegEx(String regex, Integer amount);

    List<Product> getAllWithoutRegEx(String regex, Integer amount, Integer page, List<Product> returnProducts);
}
