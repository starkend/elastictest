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

import static junit.framework.TestCase.assertTrue;
import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = ElastictestApplication.class)
public class ProductRepositoryTest {

    @Autowired
    ProductRepository productRepository;

    @Test
    public void whenInsertProduct_thenSucceed() {
        Product product = createProduct("Test Brand Name", "Test Name", 1000L);

        String id = product.getId();

        Product saveProduct = productRepository.insertProduct(product);
        assertNotNull(saveProduct);

        Product findProduct = productRepository.findById(id);

        assertNotNull(findProduct);
        assertEquals(id, findProduct.getId());

        boolean didDeleteSucceed = productRepository.deleteById(product.getId());
        assertTrue(didDeleteSucceed);
    }

    @Test
    public void whenInsertAndDeleteProduct_thenSucceed() {
        Product product = createProduct("Delete Brand Name", "Delete Name", 100L);

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

    @Test
    public void whenFindById_thenSucceed() {
        Product product = createProduct("Test FindById Brand Name", "Test FindById Name", 2000L);
        String id = product.getId();

        Product saveProduct = productRepository.insertProduct(product);
        assertNotNull(product);

        Product findByIdProduct = productRepository.findById(id);

        assertNotNull(findByIdProduct);
        assertEquals(id, findByIdProduct.getId());

        boolean didDeleteSucceed = productRepository.deleteById(id);
        assertTrue(didDeleteSucceed);
    }

    @Test
    public void whenGetAllProducts_thenSucceed() {
        List<Product> productList = productRepository.getAllProducts();

        assertNotNull(productList);
        assertFalse(productList.isEmpty());
    }

    private Product createProduct(String brandName, String name, long gtin) {
        Product product = new Product();
        product.setId(UUID.randomUUID().toString());
        product.setBrandName(brandName);
        product.setName(name);
        product.setGtin14(gtin);
        return product;
    }
}