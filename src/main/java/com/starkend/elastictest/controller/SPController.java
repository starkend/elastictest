package com.starkend.elastictest.controller;

import com.starkend.elastictest.dto.ProductDto;
import com.starkend.elastictest.model.Product;
import com.starkend.elastictest.service.DatakickService;
import com.starkend.elastictest.service.SPProductService;
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
@RequestMapping("/sp")
public class SPController {

    private static Logger LOG = LoggerFactory.getLogger(com.starkend.elastictest.controller.SPController.class);

    private SPProductService spProductService;

    public SPController(SPProductService spProductService) {
        this.spProductService = spProductService;
    }

    @GetMapping("/product")
    public ResponseEntity<Product> getProduct(@RequestParam String prodId) {
        return new ResponseEntity<>(spProductService.getProduct(Long.valueOf(prodId)), HttpStatus.OK);
    }

}