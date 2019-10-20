package service;

import com.starkend.elastictest.ElastictestApplication;
import com.starkend.elastictest.dto.ProductDto;
import com.starkend.elastictest.service.DatakickService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = ElastictestApplication.class)
public class DatakickServiceTest {

    @Autowired
    DatakickService datakickService;

    @Test
    public void whenGetItems_thenReturnPopulatedItemsList() {
        List<ProductDto> productList = datakickService.getItemsList();

        assertNotNull(productList);
        assertFalse(productList.isEmpty());

        productList.forEach(p -> System.out.println(p.getName()));
    }

}
