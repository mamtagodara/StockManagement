package com.example.demo.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;

import java.util.Date;
import java.util.List;

@Entity
public class Stock {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private int quantity;
    private Date receivedDate;
    private String supplier;

    @ManyToOne
    @JoinColumn(name = "project_id")
    @JsonBackReference
    private Project project;

    @OneToMany(mappedBy = "stock", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<StockTransaction> transactions;

    // Constructors, getters, setters
    // Omitted for brevity

    public Stock() {
    }

    public Stock(String name, int quantity, Date receivedDate, String supplier, Project project) {
        this.name = name;
        this.quantity = quantity;
        this.receivedDate = receivedDate;
        this.supplier = supplier;
        this.project = project;
    }

    // Getters and setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public Date getReceivedDate() {
        return receivedDate;
    }

    public void setReceivedDate(Date receivedDate) {
        this.receivedDate = receivedDate;
    }

    public String getSupplier() {
        return supplier;
    }

    public void setSupplier(String supplier) {
        this.supplier = supplier;
    }

    public Project getProject() {
        return project;
    }

    public void setProject(Project project) {
        this.project = project;
    }

    public List<StockTransaction> getTransactions() {
        return transactions;
    }

    public void setTransactions(List<StockTransaction> transactions) {
        this.transactions = transactions;
    }

    public void updateStockDetails(Stock stockDetails) {
        this.setName(stockDetails.getName());
        this.setQuantity(stockDetails.getQuantity());
        this.setReceivedDate(stockDetails.getReceivedDate());
        this.setSupplier(stockDetails.getSupplier());
        this.setProject(stockDetails.getProject());
        // Update other fields as needed
    }
}
