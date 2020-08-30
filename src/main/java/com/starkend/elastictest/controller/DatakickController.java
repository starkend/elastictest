//package com.starkend.elastictest.controller;
//
//import com.starkend.elastictest.dto.ProductDto;
//import com.starkend.elastictest.service.DatakickService;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestParam;
//import org.springframework.web.bind.annotation.RestController;
//
//import java.util.List;
//
//@RestController
//@RequestMapping("/dk")
//public class DatakickController {
//
////    private static Logger LOG = LoggerFactory.getLogger(DatakickController.class);
////
////    private DatakickService datakickService;
////
////    public DatakickController(DatakickService datakickService) {
////        this.datakickService = datakickService;
////    }
////
////    @GetMapping("/products")
////    public ResponseEntity<List<ProductDto>> getProducts() {
////        return new ResponseEntity<>(datakickService.getProductDtoList(), HttpStatus.OK);
////    }
////
////    @GetMapping("/productQuery")
////    public ResponseEntity<List<ProductDto>> getProductsByQuery(@RequestParam String query) {
////        return new ResponseEntity<>(datakickService.getProductDtoListByQuery(query), HttpStatus.OK);
////    }
//}
