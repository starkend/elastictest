package service;

import com.starkend.elastictest.ElastictestApplication;
import com.starkend.elastictest.dto.ProductDto;
import com.starkend.elastictest.model.DKProduct;
import com.starkend.elastictest.service.ProductService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = ElastictestApplication.class)
public class DKProductServiceTest {

    @Autowired
    ProductService productService;

    @Test
    public void whenFindByName_thenReturnPopulatedProductList() {
        List<DKProduct> DKProductList = productService.findByName("Test");

        verifyProductList(DKProductList);
    }

    @Test
    public void whenGetAllProducts_thenReturnPopulatedProductList() {
        List<DKProduct> DKProductList = productService.getAllProducts();

        verifyProductList(DKProductList);
    }

    @Test
    public void whenGetAllProductsAsDtos_thenReturnPopulatedDtoList() {
        List<ProductDto> productDtos = productService.getAllProductsAsDtos();

        verifyProductList(productDtos);
    }

    private <T> void verifyProductList(List<T> productList) {
        System.out.println("Size is " + productList.size());

        assertNotNull(productList);
        assertFalse(productList.isEmpty());
    }
}
