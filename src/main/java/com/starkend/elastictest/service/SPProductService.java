package com.starkend.elastictest.service;

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


