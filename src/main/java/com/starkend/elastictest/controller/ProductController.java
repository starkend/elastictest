package com.starkend.elastictest.controller;

import com.starkend.elastictest.model.Product;
import com.starkend.elastictest.repository.ProductRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ProductController {

    ProductRepository productRepository;

    public ProductController(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

//    @GetMapping("/products")
//    public ResponseEntity<List<Product>> getAllProducts() {
////        productRepository.
//    }
}
