package com.example.demo.controller;

import com.example.demo.entity.StockTransaction;
import com.example.demo.repository.StockTransactionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/transactions")
public class StockTransactionController {

    @Autowired
    private StockTransactionRepository stockTransactionRepository;

    @GetMapping

    public List<StockTransaction> getAllTransactions(){
        return stockTransactionRepository.findAll();
    }


    @GetMapping("/{id}")
    public ResponseEntity<StockTransaction> getTransactionById(@PathVariable Long id) {
        Optional<StockTransaction> transaction = stockTransactionRepository.findById(id);
        return transaction.map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }


@PostMapping
    public StockTransaction addTransaction(@RequestBody StockTransaction transaction){
    return stockTransactionRepository.save(transaction);
}

@PutMapping("/{id}")
    public StockTransaction updateTransaction(@PathVariable Long id, @RequestBody StockTransaction transaction){
    return stockTransactionRepository.save(transaction);
}

@DeleteMapping("/{id}")
    public void deleteTransaction(@PathVariable Long id){
    stockTransactionRepository.deleteById(id);
}
}
