package repository;

import com.starkend.elastictest.ElastictestApplication;
import com.starkend.elastictest.model.DKProduct;
import com.starkend.elastictest.repository.ProductRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import static junit.framework.TestCase.assertTrue;
import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = ElastictestApplication.class)
public class DKProductRepositoryTest {

    @Autowired
    ProductRepository productRepository;

    @Test
    public void whenInsertProduct_thenSucceed() {
        DKProduct DKProduct = createProduct("Test Brand Name", "Test Name", 1000L);

        String id = DKProduct.getId();

        DKProduct saveDKProduct = productRepository.insertProduct(DKProduct);
        assertNotNull(saveDKProduct);

        DKProduct findDKProduct = productRepository.findById(id);

        assertNotNull(findDKProduct);
        assertEquals(id, findDKProduct.getId());

        boolean didDeleteSucceed = productRepository.deleteById(DKProduct.getId());
        assertTrue(didDeleteSucceed);
    }

    @Test
    public void whenInsertAndDeleteProduct_thenSucceed() {
        DKProduct DKProduct = createProduct("Delete Brand Name", "Delete Name", 100L);

        DKProduct saveDKProduct = productRepository.insertProduct(DKProduct);
        assertNotNull(DKProduct);

        boolean didDeleteSucceed = productRepository.deleteById(DKProduct.getId());
        assertTrue(didDeleteSucceed);
    }

    @Test
    public void whenFindByName_thenSucceed() {
        String name = "Name";

        List<DKProduct> DKProductList = productRepository.findByName(name);

        assertNotNull(DKProductList);
        assertFalse(DKProductList.isEmpty());

        DKProductList.forEach(p -> System.out.println(p.getName()));
    }

    @Test
    public void whenFindById_thenSucceed() {
        DKProduct DKProduct = createProduct("Test FindById Brand Name", "Test FindById Name", 2000L);
        String id = DKProduct.getId();

        DKProduct saveDKProduct = productRepository.insertProduct(DKProduct);
        assertNotNull(DKProduct);

        DKProduct findByIdDKProduct = productRepository.findById(id);

        assertNotNull(findByIdDKProduct);
        assertEquals(id, findByIdDKProduct.getId());

        boolean didDeleteSucceed = productRepository.deleteById(id);
        assertTrue(didDeleteSucceed);
    }

    @Test
    public void whenGetAllProducts_thenSucceed() {
        List<DKProduct> DKProductList = productRepository.getAllProducts();

        assertNotNull(DKProductList);
        assertFalse(DKProductList.isEmpty());
    }

    @Test
    public void whenBulkInsertProducts_thenSucceed() {
        List<DKProduct> insertDKProductList = new ArrayList<>();

        for (int i = 0; i < 4; i++) {
            DKProduct DKProduct = createProduct("Bulk Brand " + i, "Bulk Name " + i, 100L + i);
            insertDKProductList.add(DKProduct);
        }

        boolean didSucceed = productRepository.bulkInsertProducts(insertDKProductList);

        assertTrue(didSucceed);

        for (DKProduct DKProduct : insertDKProductList) {
            boolean didDeleteSucceed = productRepository.deleteById(DKProduct.getId());
            assertTrue(didDeleteSucceed);
        }
    }

    private DKProduct createProduct(String brandName, String name, long gtin) {
        DKProduct DKProduct = new DKProduct();
        DKProduct.setId(UUID.randomUUID().toString());
        DKProduct.setBrandName(brandName);
        DKProduct.setName(name);
        DKProduct.setGtin14(gtin);
        return DKProduct;
    }
}