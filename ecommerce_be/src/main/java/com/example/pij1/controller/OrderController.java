package com.example.pij1.controller;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.example.pij1.entity.Order;
import com.example.pij1.service.OrderService;

import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Future;

@RestController
@RequestMapping("/orders")
@CrossOrigin(origins = "http://localhost:3000")
public class OrderController {
    private static final Logger log = LogManager.getLogger(OrderController.class); // Log4j2
    @Autowired
    private OrderService orderService;

    @GetMapping
    public CompletableFuture<List<Order>> getAllOrders() { // CompletableFuture
        log.info("Fetching all order"); // Log4j2
        return orderService.getAllOrders();
    }

    @PostMapping
    public CompletableFuture<Order> createOrder(@RequestBody Order order) { // CompletableFuture
        log.info("Creating order"); // Log4j2
        return orderService.createOrder(order);
    }
}