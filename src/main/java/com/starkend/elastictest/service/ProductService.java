package com.starkend.elastictest.service;

import com.starkend.elastictest.model.Product;
import com.starkend.elastictest.repository.ProductRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {

    private ProductRepository productRepository;

    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public Product insertProduct(Product product) {
        return productRepository.insertProduct(product);
    }

    public List<Product> findByName(String name) {
        return productRepository.findByName(name);
    }

    public boolean deleteById(String id) {
        return productRepository.deleteById(id);
    }

    public Product findById(String id) {
        return productRepository.findById(id);
    }

    public List<Product> getAllProducts() {
        return productRepository.getAllProducts();
    }

}
