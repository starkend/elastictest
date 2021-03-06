package com.starkend.elastictest.service;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.starkend.elastictest.model.*;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.List;

@Service
public class SPProductService {

    private final RestTemplate restTemplate;
    private final ObjectMapper objectMapper;
    @Value("${service.spoonacular.url}")
    private String BASE_URL;
    @Value("${service.spoonacular.apiUrlComponent}")
    private String API_URL_COMPONENT;

    public SPProductService(RestTemplate restTemplate, ObjectMapper objectMapper) {
        this.restTemplate = restTemplate;
        this.objectMapper = objectMapper;
    }

    public Product getProductById(Long productId) {
        String url = BASE_URL + "/food/products/" + productId + "?" + API_URL_COMPONENT;

        System.out.println(url);
        HttpEntity<String> response = getStringResponse(url);

        return processProductResponse(response);
    }

    public Product getProductByUpc(String upc) {
        String url = BASE_URL + "/food/products/upc/" + upc + "?" + API_URL_COMPONENT;

        System.out.println(url);
        HttpEntity<String> response = getStringResponse(url);

        return processProductResponse(response);
    }

    public Ingredient getIngredientInfoById(String ingredientId) {
        String url = BASE_URL + "/food/ingredients/" + ingredientId + "/information?" + API_URL_COMPONENT;
        System.out.println(url);
        HttpEntity<String> response = getStringResponse(url);

        return processIngredientResponse(response);
    }

    public Ingredient getIngredientInfoByIdWithAmount(String ingredientId, BigDecimal amount) {
        String url = BASE_URL + "/food/ingredients/" + ingredientId + "/information?amount=" + amount + "&" + API_URL_COMPONENT;
        System.out.println(url);
        HttpEntity<String> response = getStringResponse(url);

        return processIngredientResponse(response);
    }

    public IngredientSubtitutes getIngredientSubtitutes(String ingredient) {
        String url = BASE_URL + "/food/ingredients/substitutes?ingredientName=" + ingredient + "&" + API_URL_COMPONENT;
        System.out.println(url);
        HttpEntity<String> response = getStringResponse(url);

        return processIngredientSubstitutesResponse(response);
    }

    public SearchProducts getSearchProductsByQuery(String queryString) {
        String url = BASE_URL + "/food/products/search?query=" + queryString + "&" + API_URL_COMPONENT;
        System.out.println(url);
        HttpEntity<String> response = getStringResponse(url);

        return processSearchProductsResponse(response);
    }

    public AutocompleteProductSearch getAutocompleteProductSearch(String queryString, Integer number) {
        String url = BASE_URL + "/food/products/suggest?query=" + queryString + "&" + "number=" + number + "&" + API_URL_COMPONENT;
        System.out.println(url);
        HttpEntity<String> response = getStringResponse(url);

        return processAutocompleteProductSearchResponse(response);
    }

    public IngredientSubtitutes getIngredientSubtitutesById(String ingredientId) {
        String url = BASE_URL + "/food/ingredients/" + ingredientId + "/substitutes" + "?" + API_URL_COMPONENT;
        System.out.println(url);
        HttpEntity<String> response = getStringResponse(url);

        return processIngredientSubstitutesResponse(response);
    }

    public Recipe getRecipeById(String recipeId) {
        String url = BASE_URL + "/recipes/" + recipeId + "/information" + "?" + API_URL_COMPONENT;
        System.out.println(url);
        HttpEntity<String> response = getStringResponse(url);

        return processRecipeResponse(response);
    }

    public List<Recipe> getRecipeByIdBulk(List<String> recipeIds) {
        String recipeIdsUrlComponent = String.join(",", recipeIds);

        String url = BASE_URL + "/recipes/informationBulk?ids=" + recipeIdsUrlComponent + "&" + API_URL_COMPONENT;
        System.out.println(url);
        HttpEntity<String> response = getStringResponse(url);

        return processRecipesResponse(response);
    }

    public List<Recipe> getSimilarRecipes(String recipeId) {
        String url = BASE_URL + "/recipes/" + recipeId + "/similar" + "?" + API_URL_COMPONENT;
        System.out.println(url);
        HttpEntity<String> response = getStringResponse(url);

        return processRecipesResponse(response);
    }

    public Recipes getRandomRecipes() {
        String url = BASE_URL + "/recipes/random" + "?" + API_URL_COMPONENT;
        System.out.println(url);
        HttpEntity<String> response = getStringResponse(url);

        return processRandomRecipesResponse(response);
    }

    public List<AnalyzedInstruction> getAnalyzedInstructions(String id) {
        String url = BASE_URL + "/recipes/" + id + "/analyzedInstructions" + "?" + API_URL_COMPONENT;
        System.out.println(url);
        HttpEntity<String> response = getStringResponse(url);

        return processAnalyzedInstructionsResponse(response);
    }

    public MenuItem getMenuItemById(String id) {
        String url = BASE_URL + "/food/menuItems/" + id + "?" + API_URL_COMPONENT;
        System.out.println(url);
        HttpEntity<String> response = getStringResponse(url);

        return processMenuItemResponse(response);
    }

    public List<Ingredient> getAutocompleteIngredientSearch(String queryString, Integer number) {
        String url = BASE_URL + "/food/ingredients/autocomplete?query=" + queryString + "&" + "number=" + number + "&" + API_URL_COMPONENT;
        System.out.println(url);
        HttpEntity<String> response = getStringResponse(url);

        return processAutocompleteIngredientResponse(response);
    }

    public RecipeEquipment getRecipeEquipmentById(String id) {
        String url = BASE_URL + "/recipes/" + id + "/equipmentWidget.json?" + API_URL_COMPONENT;
        System.out.println(url);
        HttpEntity<String> response = getStringResponse(url);

        return processRecipeEquipmentResponse(response);
    }

    private SearchProducts processSearchProductsResponse(HttpEntity<String> response) {
        SearchProducts searchProducts;

        if (response != null) {
            try {
                searchProducts = objectMapper.readValue(response.getBody(), SearchProducts.class);
            } catch (IOException e) {
                e.printStackTrace();
                return null;
            }
        } else {
            return null;
        }

        return searchProducts;
    }

    private IngredientSubtitutes processIngredientSubstitutesResponse(HttpEntity<String> response) {
        IngredientSubtitutes ingredientSubtitutes;

        if (response != null) {
            try {
                ingredientSubtitutes = objectMapper.readValue(response.getBody(), IngredientSubtitutes.class);
            } catch (IOException e) {
                e.printStackTrace();
                return null;
            }
        } else {
            return null;
        }

        return ingredientSubtitutes;
    }

    private Product processProductResponse(HttpEntity<String> response) {
        Product product;

        if (response != null) {
            try {
                product = objectMapper.readValue(response.getBody(), Product.class);
            } catch (IOException e) {
                e.printStackTrace();
                return null;
            }
        } else {
            return null;
        }

        return product;
    }

    private Ingredient processIngredientResponse(HttpEntity<String> response) {
        Ingredient ingredient;

        if (response != null) {
            try {
                ingredient = objectMapper.readValue(response.getBody(), Ingredient.class);
            } catch (IOException e) {
                e.printStackTrace();
                return null;
            }
        } else {
            return null;
        }

        return ingredient;
    }

    private AutocompleteProductSearch processAutocompleteProductSearchResponse(HttpEntity<String> response) {
        AutocompleteProductSearch autocompleteProductSearch;

        if (response != null) {
            try {
                autocompleteProductSearch = objectMapper.readValue(response.getBody(), AutocompleteProductSearch.class);
            } catch (IOException e) {
                e.printStackTrace();
                return null;
            }
        } else {
            return null;
        }

        return autocompleteProductSearch;
    }

    private Recipe processRecipeResponse(HttpEntity<String> response) {
        Recipe recipe;

        if (response != null) {
            try {
                recipe = objectMapper.readValue(response.getBody(), Recipe.class);
            } catch (IOException e) {
                e.printStackTrace();
                return null;
            }
        } else {
            return null;
        }

        return recipe;
    }

    private List<Recipe> processRecipesResponse(HttpEntity<String> response) {
        List<Recipe> recipes;

        if (response != null) {
            try {
                recipes = objectMapper.readValue(response.getBody(), new TypeReference<List<Recipe>>() {
                });
            } catch (IOException e) {
                e.printStackTrace();
                return null;
            }
        } else {
            return null;
        }

        return recipes;
    }

    private Recipes processRandomRecipesResponse(HttpEntity<String> response) {
        Recipes recipes;

        if (response != null) {
            try {
                recipes = objectMapper.readValue(response.getBody(), Recipes.class);

            } catch (IOException e) {
                e.printStackTrace();
                return null;
            }
        } else {
            return null;
        }

        return recipes;
    }

    private List<AnalyzedInstruction> processAnalyzedInstructionsResponse(HttpEntity<String> response) {
        List<AnalyzedInstruction> analyzedInstructions;

        if (response != null) {
            try {
                analyzedInstructions = objectMapper.readValue(response.getBody(), new TypeReference<List<AnalyzedInstruction>>() {
                });
            } catch (IOException e) {
                e.printStackTrace();
                return null;
            }
        } else {
            return null;
        }

        return analyzedInstructions;
    }

    private MenuItem processMenuItemResponse(HttpEntity<String> response) {
        MenuItem menuItem;

        if (response != null) {
            try {
                menuItem = objectMapper.readValue(response.getBody(), MenuItem.class);

            } catch (IOException e) {
                e.printStackTrace();
                return null;
            }
        } else {
            return null;
        }

        return menuItem;
    }

    private List<Ingredient> processAutocompleteIngredientResponse(HttpEntity<String> response) {
        List<Ingredient> ingredients;

        if (response != null) {
            try {
                ingredients = objectMapper.readValue(response.getBody(), new TypeReference<List<Ingredient>>() {
                });
            } catch (IOException e) {
                e.printStackTrace();
                return null;
            }
        } else {
            return null;
        }

        return ingredients;
    }

    private RecipeEquipment processRecipeEquipmentResponse(HttpEntity<String> response) {
        RecipeEquipment equipment;

        if (response != null) {
            try {
                equipment = objectMapper.readValue(response.getBody(), RecipeEquipment.class);
            } catch (IOException e) {
                e.printStackTrace();
                return null;
            }
        } else {
            return null;
        }

        return equipment;
    }

    private HttpHeaders buildHeaders() {
        HttpHeaders headers = new HttpHeaders();
        headers.set("Accept", MediaType.APPLICATION_JSON_VALUE);
        return headers;
    }

    private HttpEntity<String> getStringResponse(String url) {
        HttpEntity<?> entity = new HttpEntity<>(buildHeaders());

        return restTemplate.exchange(
                url,
                HttpMethod.GET,
                entity,
                String.class);
    }
}


