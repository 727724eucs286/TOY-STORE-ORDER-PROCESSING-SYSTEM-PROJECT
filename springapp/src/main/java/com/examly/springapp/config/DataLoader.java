package com.examly.springapp.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import com.examly.springapp.model.Product;
import com.examly.springapp.repository.ProductRepo;

@Configuration
public class DataLoader implements CommandLineRunner {

    @Autowired
    private ProductRepo productRepo;

    @Override
    public void run(String... args) throws Exception {

        if (productRepo.count() == 0) {
            Product p1 = new Product();
            p1.setProductName("Laptop");

            Product p2 = new Product();
            p2.setProductName("Mobile");

            productRepo.save(p1);
            productRepo.save(p2);
        }
    }
}
