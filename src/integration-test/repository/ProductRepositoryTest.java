package repository;

import com.starkend.elastictest.ElastictestApplication;
import com.starkend.elastictest.model.Product;
import com.starkend.elastictest.repository.ProductRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;
import java.util.UUID;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = ElastictestApplication.class)
public class ProductRepositoryTest {

    @Autowired
    ProductRepository productRepository;

    @Test
    public void whenTestInsertProductIntoMongodb_thenSucceed() {
        Product product = new Product();
        product.setId(UUID.randomUUID().toString());
        product.setBrandName("Test Brand");
        product.setName("Blah Name");
        product.setGtin14(1000L);

        //Product saveProduct = productRepository.insertProduct(product);

        List<Product> findProducts = productRepository.findByName(product.getName());

        assertNotNull(findProducts);
        assertFalse(findProducts.isEmpty());

        //productRepository.delete(findProducts);

    }

}
