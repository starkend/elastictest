package com.starkend.elastictest.service;

import com.starkend.elastictest.dto.ProductDto;
import com.starkend.elastictest.model.Product;
import com.starkend.elastictest.repository.ProductRepository;
import com.starkend.elastictest.util.ProductUtils;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
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

    public List<ProductDto> getAllProductsAsDtos() {
        List<ProductDto> productDtos = new ArrayList<>();
        getAllProducts().forEach(product -> productDtos.add(ProductUtils.convertProductToProductDto(product)));

        return productDtos;
    }

    public boolean bulkInsertProducts(List<Product> insertProductList) {
        return productRepository.bulkInsertProducts(insertProductList);
    }
}
