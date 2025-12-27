package com.examly.springapp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.examly.springapp.model.PurchaseOrderItem;
import com.examly.springapp.repository.PurchaseOrderItemRepo;

@RestController
@RequestMapping("/api/purchase-order-items")
public class PurchaseOrderItemController {

    @Autowired
    private PurchaseOrderItemRepo purchaseOrderItemRepo;

    // ✅ POST - Add Purchase Order Item
    @PostMapping
    public ResponseEntity<PurchaseOrderItem> addPurchaseOrderItem(
            @RequestBody PurchaseOrderItem item) {

        PurchaseOrderItem saved = purchaseOrderItemRepo.save(item);
        return new ResponseEntity<>(saved, HttpStatus.CREATED);
    }

    // ✅ GET - Items by Purchase Order ID
    @GetMapping("/order/{orderId}")
    public ResponseEntity<List<PurchaseOrderItem>> getItemsByOrderId(
            @PathVariable int orderId) {

        List<PurchaseOrderItem> items =
                purchaseOrderItemRepo.findByPurchaseOrder_PurchaseOrderId(orderId);

        return new ResponseEntity<>(items, HttpStatus.OK);
    }
}

