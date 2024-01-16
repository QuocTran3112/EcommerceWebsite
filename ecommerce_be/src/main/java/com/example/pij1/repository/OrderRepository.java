package com.example.pij1.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.pij1.entity.Order;

// JPA
public interface OrderRepository extends JpaRepository<Order, Long> {
}
