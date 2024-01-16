package com.example.pij1.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.pij1.entity.Product;

// JPA
public interface ProductRepository extends JpaRepository<Product, Long> {
}