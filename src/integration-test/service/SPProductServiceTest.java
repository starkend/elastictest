package service;

import com.starkend.elastictest.ElastictestApplication;
import com.starkend.elastictest.model.Product;
import com.starkend.elastictest.service.SPProductService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.assertNotNull;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = ElastictestApplication.class)
public class SPProductServiceTest {

    @Autowired
    SPProductService spProductService;

    @Test
    public void whenGetProductById_thenSucceed() {
        Product product = spProductService.getProductById(22347L);

        assertNotNull(product);
        System.out.println(product);
    }

}
