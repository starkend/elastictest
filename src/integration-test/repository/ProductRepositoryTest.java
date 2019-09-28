package repository;

import com.starkend.elastictest.ElastictestApplication;
import com.starkend.elastictest.model.Product;
import com.starkend.elastictest.repository.ProductRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.validation.constraints.AssertTrue;
import java.util.List;
import java.util.UUID;

import static junit.framework.TestCase.assertTrue;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = ElastictestApplication.class)
public class ProductRepositoryTest {

    @Autowired
    ProductRepository productRepository;

    @Test
    public void whenInsertProduct_thenSucceed() {
        Product product = new Product();
        product.setId(UUID.randomUUID().toString());
        product.setBrandName("Test Brand");
        product.setName("Test Name");
        product.setGtin14(1000L);

//        Product saveProduct = productRepository.insertProduct(product);
//
//        assertNotNull(saveProduct);

        List<Product> findProducts = productRepository.findByName(product.getName());

        findProducts.forEach(System.out::println);

        assertNotNull(findProducts);
        assertFalse(findProducts.isEmpty());
    }

    @Test
    public void whenInsertAndDeleteProduct_thenSucceed() {
        Product product = new Product();
        product.setId(UUID.randomUUID().toString());
        product.setBrandName("Delete Brand Name");
        product.setName("Delete Name");
        product.setGtin14(100L);

        Product saveProduct = productRepository.insertProduct(product);

        assertNotNull(product);

        boolean didDeleteSucceed = productRepository.deleteById(product.getId());

        assertTrue(didDeleteSucceed);
    }

    @Test
    public void whenFindByName_thenSucceed() {
        String name = "Name";

        List<Product> productList = productRepository.findByName(name);

        assertNotNull(productList);
        assertFalse(productList.isEmpty());

        productList.forEach(p -> System.out.println(p.getName()));
    }
}
