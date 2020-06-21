package com.starkend.elastictest.service;

import com.starkend.elastictest.dto.ProductDto;
import com.starkend.elastictest.model.DKProduct;
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

    public DKProduct insertProduct(DKProduct DKProduct) {
        return productRepository.insertProduct(DKProduct);
    }

    public List<DKProduct> findByName(String name) {
        return productRepository.findByName(name);
    }

    public boolean deleteById(String id) {
        return productRepository.deleteById(id);
    }

    public DKProduct findById(String id) {
        return productRepository.findById(id);
    }

    public List<DKProduct> getAllProducts() {
        return productRepository.getAllProducts();
    }

    public List<ProductDto> getAllProductsAsDtos() {
        List<ProductDto> productDtos = new ArrayList<>();
        getAllProducts().forEach(product -> productDtos.add(ProductUtils.convertProductToProductDto(product)));

        return productDtos;
    }

    public boolean bulkInsertProducts(List<DKProduct> insertDKProductList) {
        return productRepository.bulkInsertProducts(insertDKProductList);
    }
}
