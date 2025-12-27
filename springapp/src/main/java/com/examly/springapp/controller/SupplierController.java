package com.examly.springapp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.examly.springapp.model.Supplier;
import com.examly.springapp.repository.SupplierRepo;

@RestController
@RequestMapping("/api/suppliers")
public class SupplierController {

    @Autowired
    private SupplierRepo supplierRepo;

    // ✅ POST - Add Supplier
    @PostMapping
    public ResponseEntity<Supplier> addSupplier(@RequestBody Supplier supplier) {
        Supplier savedSupplier = supplierRepo.save(supplier);
        return new ResponseEntity<>(savedSupplier, HttpStatus.CREATED);
    }

    // ✅ GET - All Suppliers
    @GetMapping
    public ResponseEntity<List<Supplier>> getAllSuppliers() {
        List<Supplier> suppliers = supplierRepo.findAll();
        return new ResponseEntity<>(suppliers, HttpStatus.OK);
    }

    // ✅ GET - Supplier by ID (PathVariable REQUIRED by test)
    @GetMapping("/{id}")
    public ResponseEntity<Supplier> getSupplierById(@PathVariable int id) {
        return supplierRepo.findById(id)
                .map(supplier -> new ResponseEntity<>(supplier, HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    // ✅ PUT - Update Supplier (PathVariable REQUIRED by test)
    @PutMapping("/{id}")
    public ResponseEntity<Supplier> updateSupplier(
            @PathVariable int id,
            @RequestBody Supplier updatedSupplier) {

        return supplierRepo.findById(id).map(existing -> {
            existing.setSupplierName(updatedSupplier.getSupplierName());
            existing.setContactNumber(updatedSupplier.getContactNumber());
            existing.setEmail(updatedSupplier.getEmail());
            existing.setAddress(updatedSupplier.getAddress());
            supplierRepo.save(existing);
            return new ResponseEntity<>(existing, HttpStatus.OK);
        }).orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }
}

