package com.starkend.elastictest.controller;

import com.starkend.elastictest.model.Product;
import com.starkend.elastictest.repository.ProductRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ProductController {

    private static Logger LOG = LoggerFactory.getLogger(ProductController.class);

    ProductRepository productRepository;

    public ProductController(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @GetMapping("/products")
    public ResponseEntity<List<Product>> getAllProducts() {
        List<Product> productList = productRepository.getAllProducts();

        LOG.info(productList.toString());
        return new ResponseEntity<>(productList, HttpStatus.OK);
    }

    @GetMapping("/findProductsByName")
    public ResponseEntity<List<Product>> getProductsByName(@RequestParam String name) {
        List<Product> productList = productRepository.findByName(name);

        LOG.info(productList.toString());
        return new ResponseEntity<>(productList, HttpStatus.OK);
    }
}
