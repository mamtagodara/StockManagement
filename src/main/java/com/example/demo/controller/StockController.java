package com.example.demo.controller;

import com.example.demo.entity.Stock;
import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.repository.StockRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/stocks")
public class StockController {
    @Autowired
    private StockRepository stockRepository;

    @GetMapping
    public List<Stock> getAllStocks(){
        return stockRepository.findAll();
    }

    @PostMapping
    public Stock createStock(@RequestBody Stock stock){
    return stockRepository.save(stock);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Stock> getStockById(@PathVariable Long id){
        Stock stocks = stockRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Stock not found with id " + id));
    return ResponseEntity.ok(stocks);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Object> updateStock(@PathVariable Long id, @RequestBody Stock stockDetails){
        Stock stocks = stockRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Stock not found with id " + id));
        stocks.setName(stockDetails.getName());
        stocks.setQuantity(stockDetails.getQuantity());
        stocks.setSupplier(stockDetails.getSupplier());
        stocks.setProject(stockDetails.getProject());
        stocks.setReceivedDate(stockDetails.getReceivedDate());

        Stock updatedStock = stockRepository.save(stocks);
        return ResponseEntity.ok(updatedStock);

    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteStock(@PathVariable Long id){
        Stock stocks = stockRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Stock not found with id " + id));

        stockRepository.delete(stocks);

        return ResponseEntity.noContent().build();
    }
}
