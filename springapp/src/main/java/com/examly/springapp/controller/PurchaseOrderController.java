package com.examly.springapp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.examly.springapp.model.PurchaseOrder;
import com.examly.springapp.repository.PurchaseOrderRepo;

@RestController
@RequestMapping("/api/purchase-orders")
public class PurchaseOrderController {

    @Autowired
    private PurchaseOrderRepo purchaseOrderRepo;

    // ✅ POST - Add Purchase Order
    @PostMapping
    public ResponseEntity<PurchaseOrder> addPurchaseOrder(@RequestBody PurchaseOrder purchaseOrder) {
        PurchaseOrder saved = purchaseOrderRepo.save(purchaseOrder);
        return new ResponseEntity<>(saved, HttpStatus.CREATED);
    }

    // ✅ GET - All Purchase Orders
    @GetMapping
    public ResponseEntity<List<PurchaseOrder>> getAllPurchaseOrders() {
        return new ResponseEntity<>(purchaseOrderRepo.findAll(), HttpStatus.OK);
    }

    // ✅ GET - By ID (PathVariable REQUIRED)
    @GetMapping("/{id}")
    public ResponseEntity<PurchaseOrder> getPurchaseOrderById(@PathVariable int id) {
        return purchaseOrderRepo.findById(id)
                .map(order -> new ResponseEntity<>(order, HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    // ✅ PUT - Update Purchase Order
    @PutMapping("/{id}")
    public ResponseEntity<PurchaseOrder> updatePurchaseOrder(
            @PathVariable int id,
            @RequestBody PurchaseOrder updatedOrder) {

        return purchaseOrderRepo.findById(id).map(existing -> {
            existing.setOrderNumber(updatedOrder.getOrderNumber());
            existing.setOrderDate(updatedOrder.getOrderDate());
            existing.setStatus(updatedOrder.getStatus());
            existing.setSupplier(updatedOrder.getSupplier());
            purchaseOrderRepo.save(existing);
            return new ResponseEntity<>(existing, HttpStatus.OK);
        }).orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }
}

