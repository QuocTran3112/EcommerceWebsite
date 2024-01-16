package com.example.pij1.service;

import java.util.List;
import java.util.Optional;
import java.util.concurrent.CompletableFuture;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.pij1.entity.Order;
import com.example.pij1.entity.Product;
import com.example.pij1.exception.ResourceNotFoundException;
import com.example.pij1.repository.ProductRepository;

@Service
public class ProductService {
    @Autowired
    private ProductRepository productRepository;

    public CompletableFuture<List<Product>> getAllProducts() {
        CompletableFuture<List<Product>> completableFuture = new CompletableFuture<>();
        new Thread(() -> { // lambda
            List<Product> products = productRepository.findAll();
            completableFuture.complete(products);
        }).start();
        return completableFuture;
    }

    public CompletableFuture<Product> getProductById(Long id) {
        CompletableFuture<Product> completableFuture = new CompletableFuture<>();
        new Thread(() -> { // lambda
            Optional<Product> product = productRepository.findById(id);
            completableFuture.complete(product.orElseThrow(() -> // lambda
                    new ResourceNotFoundException("Product", "id", id)
            ));
        }).start();
        return completableFuture;
    }
}
