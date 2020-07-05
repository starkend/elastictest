package service;

import com.starkend.elastictest.ElastictestApplication;
import com.starkend.elastictest.model.Ingredient;
import com.starkend.elastictest.model.Product;
import com.starkend.elastictest.service.SPProductService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigDecimal;

import static org.junit.Assert.assertNotNull;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = ElastictestApplication.class)
public class SPProductServiceTest {

    @Autowired
    SPProductService spProductService;

    @Test
    public void whenGetProductById_thenSucceed() {
        final Long SNICKERS_MINI_PRODUCT_ID = 22347L;
        Product product = spProductService.getProductById(SNICKERS_MINI_PRODUCT_ID);

        assertNotNull(product);
        System.out.println(product);
    }

    @Test
    public void whenGetProductByUpc_thenSucceed() {
        final String WHOLE_GRAIN_CHEERIOS_UPC = "016000275287";
        Product product = spProductService.getProductByUpc(WHOLE_GRAIN_CHEERIOS_UPC);

        assertNotNull(product);
        System.out.println(product);
    }

    @Test
    public void whenGetIngredientInfo_thenSucceed() {
        final String PINEAPPLE_INGREDIENT_ID = "9266";
        Ingredient ingredient = spProductService.getIngredientInfoById(PINEAPPLE_INGREDIENT_ID);

        assertNotNull(ingredient);
        System.out.println(ingredient);
    }

    @Test
    public void whenGetIngredientInfoWithAmount_thenSucceed() {
        final String PINEAPPLE_INGREDIENT_ID = "9266";
        final BigDecimal AMOUNT = new BigDecimal(1.0);
        Ingredient ingredient = spProductService.getIngredientInfoByIdWithAmount(PINEAPPLE_INGREDIENT_ID, AMOUNT);

        assertNotNull(ingredient);
        System.out.println(ingredient);
    }
}
