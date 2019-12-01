package com.starkend.elastictest.service;

import com.starkend.elastictest.dto.ProductDto;
import com.starkend.elastictest.model.Product;
import com.starkend.elastictest.util.ProductUtils;
import org.springframework.stereotype.Service;

@Service
public class UtilService {

    private ProductService productService;
    private DatakickService datakickService;

    public UtilService(ProductService productService, DatakickService datakickService) {
        this.productService = productService;
        this.datakickService = datakickService;
    }

    public Product insertDatakickProductToElasticIndex(ProductDto productDto) {
        return productService.insertProduct(ProductUtils.convertProductDtoToProduct(productDto));
    }

}
