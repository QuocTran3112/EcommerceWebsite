package com.example.pij1.controller;

import lombok.extern.slf4j.Slf4j;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.example.pij1.entity.Product;
import com.example.pij1.service.ProductService;

import java.util.List;
import java.util.concurrent.CompletableFuture;

@RestController
@RequestMapping("/products")
@CrossOrigin(origins = "http://localhost:3000")
public class ProductController {
    private static final Logger log = LogManager.getLogger(ProductController.class); // Log4j2
    @Autowired
    private ProductService productService;

    @GetMapping
    public CompletableFuture<List<Product>> getAllProducts() {
        log.info("Fetching all product"); // Log4j2
        return productService.getAllProducts();
    }

    @GetMapping("/{id}")
    public CompletableFuture<Product> getProductById(@PathVariable Long id) {
        log.info("Fetching product with id {}", id); // Log4j2
        return productService.getProductById(id);
    }
}
