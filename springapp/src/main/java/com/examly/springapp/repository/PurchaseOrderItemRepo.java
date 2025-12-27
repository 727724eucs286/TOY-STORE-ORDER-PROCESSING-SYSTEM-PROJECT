package com.examly.springapp.repository;

import java.util.List;

import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;

import com.examly.springapp.model.PurchaseOrderItem;

@Repository
public interface PurchaseOrderItemRepo extends JpaRepository<PurchaseOrderItem, Integer> {

    // ✅ REQUIRED for Day 13 GET test
    List<PurchaseOrderItem> findByPurchaseOrder_PurchaseOrderId(int purchaseOrderId);
}

