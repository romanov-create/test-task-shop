package com.example.testtaskshop.service.impl;

import com.example.testtaskshop.model.Product;
import com.example.testtaskshop.repository.ProductRepository;
import com.example.testtaskshop.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

@Service
public class ProductServiceImpl implements ProductService {
    @Autowired
    private ProductRepository productRepository;
/*
//for initialization DB , after commit this method
    @PostConstruct
    void initDB() {
        List<Product> products = new ArrayList<>();

        for (int i = 0; i < 100; i++) {
            Product product = new Product("name" + i, "description");
            products.add(product);
        }

        productRepository.saveAll(products);
    }

*/

    @Override
    public List<Product> getAllWithoutRegEx(String regex, Integer amount) {
        return getAllWithoutRegEx(regex, amount, 0, new ArrayList<>());
    }

    @Override
    public List<Product> getAllWithoutRegEx(String regex, Integer amount, Integer page, List<Product> returnProducts) {
        Pageable pageable = PageRequest.of(page, amount * 2);
        int count = 0;

        Page<Product> productsPage = productRepository.findAll(pageable);
        List<Product> products = productsPage.toList();

        while (returnProducts.size() < amount && products.size() > count) {
            Product product = products.get(count);

            if (!Pattern.matches(regex, product.getName())) {
                returnProducts.add(product);
            }
            count++;
        }

        if (productsPage.hasNext() && returnProducts.size() < amount) {
            getAllWithoutRegEx(regex, amount, page + 1, returnProducts);
        }

        return returnProducts;
    }
}
