package service;

import com.starkend.elastictest.ElastictestApplication;
import com.starkend.elastictest.model.Product;
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
public class ProductServiceTest {

    @Autowired
    ProductService productService;

    @Test
    public void whenFindByName_thenSucceed() {
        List<Product> productList = productService.findByName("Test");

        System.out.println("Size is " + productList.size());

        assertNotNull(productList);
        assertFalse(productList.isEmpty());
    }
}
