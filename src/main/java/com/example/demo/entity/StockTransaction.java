package com.example.demo.entity;

import jakarta.persistence.*;


import java.time.LocalDateTime;

@Entity
public class StockTransaction {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "stock_id")
    private Stock stock;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    private int quantity;
    private LocalDateTime timestamp;
    private boolean approved;

    public static StockTransaction updateTransaction(Long id, StockTransaction transaction) {
        return transaction;
    }

    public static void deleteTransaction(Long id) {
    }
}
