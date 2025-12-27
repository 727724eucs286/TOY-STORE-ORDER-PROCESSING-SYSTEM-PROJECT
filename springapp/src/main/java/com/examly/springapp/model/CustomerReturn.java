package com.examly.springapp.model;

import java.time.LocalDateTime;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.JoinColumn;

@Entity
public class CustomerReturn {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int customerReturnId;

    private LocalDateTime returnDate;
    private int quantity;
    private String reason;

    @ManyToOne
    @JoinColumn(name = "product_id")
    private Product product;

    // ✅ No-arg constructor
    public CustomerReturn() {
    }

    // Getters and Setters

    public int getCustomerReturnId() {
        return customerReturnId;
    }

    public void setCustomerReturnId(int customerReturnId) {
        this.customerReturnId = customerReturnId;
    }

    public LocalDateTime getReturnDate() {
        return returnDate;
    }

    public void setReturnDate(LocalDateTime returnDate) {
        this.returnDate = returnDate;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }
}

