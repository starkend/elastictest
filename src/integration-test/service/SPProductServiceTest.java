package service;

import com.starkend.elastictest.ElastictestApplication;
import com.starkend.elastictest.model.*;
import com.starkend.elastictest.service.SPProductService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertFalse;
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

    @Test
    public void whenGetIngredientSubstitutes_thenSucceed() {
        final String INGREDIENT_BUTTER = "butter";
        IngredientSubtitutes ingredientSubtitute = spProductService.getIngredientSubtitutes(INGREDIENT_BUTTER);

        assertNotNull(ingredientSubtitute);
        System.out.println(ingredientSubtitute);
    }

    @Test
    public void whenSearchProductsByQuery_thenSucceed() {
        final String SEARCH_FOR_PIZZA = "pizza";
        SearchProducts searchProducts = spProductService.getSearchProductsByQuery(SEARCH_FOR_PIZZA);

        assertNotNull(searchProducts);
        System.out.println(searchProducts);
    }

    @Test
    public void whenAutocompleteProductSearch_thenSucceed() {
        final String SEARCH_QUERY_PARTIAL = "chicke";
        final Integer NUMBER_2 = 2;

        AutocompleteProductSearch autocompleteProductSearch = spProductService.getAutocompleteProductSearch(SEARCH_QUERY_PARTIAL, NUMBER_2);

        assertNotNull(autocompleteProductSearch);
        System.out.println(autocompleteProductSearch);
    }

    @Test
    public void whenGetIngredientSubstitutesById_thenSucceed() {
        final String INGREDIENT_BUTTER_ID = "1001";
        IngredientSubtitutes ingredientSubtitutes = spProductService.getIngredientSubtitutesById(INGREDIENT_BUTTER_ID);

        assertNotNull(ingredientSubtitutes);
        System.out.println(ingredientSubtitutes);
    }

    @Test
    public void whenGetRecipeById_thenSucceed() {
        final String PASTA_WITH_STUFF_RECIPE_ID = "716429";
        Recipe recipe = spProductService.getRecipeById(PASTA_WITH_STUFF_RECIPE_ID);

        assertNotNull(recipe);
        System.out.println(recipe);
    }

    @Test
    public void whenGetRecipeByIdBulk_thenSucceed() {
        final String RECIPE_ID_1 = "716429";
        final String RECIPE_ID_2 = "715538";
        List<String> recipeIds = new ArrayList<>();
        recipeIds.add(RECIPE_ID_1);
        recipeIds.add(RECIPE_ID_2);
        List<Recipe> recipes = spProductService.getRecipeByIdBulk(recipeIds);

        assertNotNull(recipes);
        System.out.println(recipes);
    }

    @Test
    public void whenGetRecipesSimilar_thenSucceed() {
        final String RECIPE = "715538";
        List<Recipe> recipes = spProductService.getSimilarRecipes(RECIPE);

        assertNotNull(recipes);
        assertFalse(recipes.isEmpty());
        System.out.println(recipes);
    }
}
