package com.example.testtaskshop.controller;

import com.example.testtaskshop.model.Product;
import com.example.testtaskshop.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController()
@RequestMapping("/shop")
public class ProductController {
    @Autowired
    private ProductService productService;

    @GetMapping("/product")
    @ResponseBody
    List<Product> getAllWithoutRegEx(@RequestParam("nameFilter") String nameFilter, Integer amount) {
        return productService.getAllWithoutRegEx(nameFilter, amount);
    }
}
