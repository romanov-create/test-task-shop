package com.example.testtaskshop.service.impl;

import com.example.testtaskshop.model.Product;
import com.example.testtaskshop.repository.ProductRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.when;

class ProductServiceImplTest {

    @InjectMocks
    ProductServiceImpl productService;

    @Mock
    ProductRepository productRepository;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void getAllWithoutRegExTest() {
        List<Product> products = new ArrayList<>();
        int amount = 10;
        int page = 0;
        String regex = "^.*[1].*$";

        for (int i = 0; i < 100; i++) {
            Product product = new Product(i, "name" + i, "description");
            products.add(product);
        }

        Page<Product> productPage = new PageImpl<>(products);
        Pageable pageable = PageRequest.of(page, amount * 2);

        when(productRepository.findAll(pageable)).thenReturn(productPage);

        List<Product> returnProductList = productService.getAllWithoutRegEx(regex, amount);

        Assertions.assertEquals(81, returnProductList.size());
    }
}