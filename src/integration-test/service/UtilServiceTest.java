package service;

import com.starkend.elastictest.ElastictestApplication;
import com.starkend.elastictest.dto.ProductDto;
import com.starkend.elastictest.model.Product;
import com.starkend.elastictest.service.DatakickService;
import com.starkend.elastictest.service.ProductService;
import com.starkend.elastictest.service.UtilService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = ElastictestApplication.class)
public class UtilServiceTest {

    @Autowired
    UtilService utilService;

    @Autowired
    ProductService productService;

    @Autowired
    DatakickService datakickService;

    @Test
    public void whenUtilServiceIsCreatedWithDependencies_thenSucceed() {
        assertNotNull(utilService);
    }

    @Test
    public void whenInsertSingleDatakickProductToElasticProductIndex_thenSucceed() {
        List<ProductDto> productDtos = datakickService.getProductDtoList();
        ProductDto productDto = productDtos.isEmpty() ? null : productDtos.get(0);
        assertNotNull(productDto);

        Product savedProduct = utilService.insertDatakickProductToElasticIndex(productDto);
        assertNotNull(savedProduct);

        assertEquals(productDto.getGtin14(), savedProduct.getGtin14());

        productService.deleteById(savedProduct.getId());

    }
}
