package com.klu.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.klu.entity.Product;
import com.klu.service.ProductService;

@RestController
@RequestMapping("/products")
public class ProductController {

    @Autowired
    private ProductService service;

    // Insert Product
    @PostMapping
    public Product addProduct(@RequestBody Product product) {
        return service.addProduct(product);
    }

    // Category search
    @GetMapping("/category/{category}")
    public List<Product> getByCategory(@PathVariable String category) {
        return service.getByCategory(category);
    }

    // Price filter
    @GetMapping("/filter")
    public List<Product> filterPrice(@RequestParam double min, @RequestParam double max) {
        return service.filterByPrice(min, max);
    }

    // Sorted by price
    @GetMapping("/sorted")
    public List<Product> getSortedProducts() {
        return service.getSortedProducts();
    }

    // Expensive products
    @GetMapping("/expensive/{price}")
    public List<Product> getExpensiveProducts(@PathVariable double price) {
        return service.getExpensiveProducts(price);
    }
}