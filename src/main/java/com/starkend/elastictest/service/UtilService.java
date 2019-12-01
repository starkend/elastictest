package com.starkend.elastictest.service;

import com.starkend.elastictest.model.Product;
import org.springframework.stereotype.Service;

@Service
public class UtilService {

    private ProductService productService;
    private DatakickService datakickService;

    public UtilService(ProductService productService, DatakickService datakickService) {
        this.productService = productService;
        this.datakickService = datakickService;
    }


}
