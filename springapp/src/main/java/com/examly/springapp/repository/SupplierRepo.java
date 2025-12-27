package com.examly.springapp.repository;

import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;
import com.examly.springapp.model.Supplier;

@Repository
public interface SupplierRepo extends JpaRepository<Supplier, Integer> {
}

