//package service;
//
//import com.starkend.elastictest.ElastictestApplication;
//import com.starkend.elastictest.dto.ProductDto;
////import com.starkend.elastictest.model.DKProduct;
//import com.starkend.elastictest.service.DatakickService;
//import org.junit.Test;
//import org.junit.runner.RunWith;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.test.context.junit4.SpringRunner;
//
//import java.util.List;
//
//import static org.junit.Assert.assertFalse;
//import static org.junit.Assert.assertNotNull;
//
//@RunWith(SpringRunner.class)
//@SpringBootTest(classes = ElastictestApplication.class)
//public class DatakickServiceTest {
//
////    @Autowired
////    DatakickService datakickService;
////
////    @Test
////    public void whenGetProductDtoList_thenReturnPopulatedDtoList() {
////        List<ProductDto> productList = datakickService.getProductDtoList();
////
////        assertNotNull(productList);
////        assertFalse(productList.isEmpty());
////
////        productList.forEach(p -> System.out.println(p.getName()));
////    }
////
////    @Test
////    public void whenSearchBySingleWord_thenReturnPopulatedDtoList() {
////        String queryString = "peanut";
////        List<ProductDto> productList = datakickService.getProductDtoListByQuery(queryString);
////
////        assertNotNull(productList);
////        assertFalse(productList.isEmpty());
////    }
////
////    @Test
////    public void whenSearchByMultipleWords_thenReturnPopulatedDtoList() {
////        String queryString = "peanut butter";
////        List<ProductDto> productList = datakickService.getProductDtoListByQuery(queryString);
////
////        assertNotNull(productList);
////        assertFalse(productList.isEmpty());
////        productList.forEach(p -> System.out.println(p.getName()));
////    }
////
////    @Test
////    public void whenGetProductList_thenReturnPopulatedProductList() {
////        List<DKProduct> DKProductList = datakickService.getProductList();
////
////        assertNotNull(DKProductList);
////        assertFalse(DKProductList.isEmpty());
////    }
//}
