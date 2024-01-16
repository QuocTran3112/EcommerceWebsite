package com.example.pij1.entity;

import java.time.LocalDate;
import java.util.List;

import jakarta.persistence.*;
import lombok.*;

@Getter 
@Setter // lombok
@NoArgsConstructor // lombok
@AllArgsConstructor // lombok
@Builder // lombok
@Entity // persistence
@Table(name = "orders") // persistence
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long productId;
    private int quantity;
    private LocalDate orderDate;
}