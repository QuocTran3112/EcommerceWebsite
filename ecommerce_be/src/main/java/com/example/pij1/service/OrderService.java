package com.example.pij1.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.pij1.entity.Order;
import com.example.pij1.exception.ResourceNotFoundException;
import com.example.pij1.repository.OrderRepository;

import java.util.List;
import java.util.Optional;
import java.util.concurrent.CompletableFuture;

@Service
public class OrderService {
    @Autowired
    private OrderRepository orderRepository;

    public CompletableFuture<List<Order>> getAllOrders() { // CompletableFuture
        CompletableFuture<List<Order>> completableFuture = new CompletableFuture<>();
        new Thread(() -> { // lambda
            List<Order> orders = orderRepository.findAll();
            completableFuture.complete(orders);
        }).start();
        return completableFuture;
    }

    public CompletableFuture<Order> createOrder(Order order) { // CompletableFuture
        CompletableFuture<Order> completableFuture = new CompletableFuture<>();
        new Thread(() -> { // lambda
            Order savedOrder = orderRepository.save(order);
            completableFuture.complete(savedOrder);
        }).start();
        return completableFuture;
    }
}