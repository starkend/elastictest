package com.starkend.elastictest.controller;

//import com.starkend.elastictest.model.DKProduct;
import com.starkend.elastictest.service.ProductService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/es")
public class ProductController {

    private static Logger LOG = LoggerFactory.getLogger(ProductController.class);

    private ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

//    @GetMapping("/products")
//    public ResponseEntity<List<DKProduct>> getAllProducts() {
//        List<DKProduct> DKProductList = productService.getAllProducts();
//
//        LOG.info(DKProductList.toString());
//        return new ResponseEntity<>(DKProductList, HttpStatus.OK);
//    }
//
//    @GetMapping("/findProductsByName")
//    public ResponseEntity<List<DKProduct>> getProductsByName(@RequestParam String name) {
//        List<DKProduct> DKProductList = productService.findByName(name);
//
//        LOG.info(DKProductList.toString());
//        return new ResponseEntity<>(DKProductList, HttpStatus.OK);
//    }
//
//    @GetMapping("/findProductById")
//    public ResponseEntity<DKProduct> getProductById(@RequestParam String id) {
//        DKProduct DKProduct = productService.findById(id);
//
//        LOG.info(DKProduct.getName());
//        return new ResponseEntity<>(DKProduct, HttpStatus.OK);
//    }
}
