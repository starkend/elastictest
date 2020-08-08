package com.starkend.elastictest.controller;

import com.starkend.elastictest.model.*;
import com.starkend.elastictest.service.SPProductService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;
import java.util.List;

@RestController
@RequestMapping("/sp")
public class SPController {

    private static final Logger LOG = LoggerFactory.getLogger(SPController.class);

    private final SPProductService spProductService;

    public SPController(SPProductService spProductService) {
        this.spProductService = spProductService;
    }

    @GetMapping("/product")
    public ResponseEntity<Product> getProduct(@RequestParam String prodId) {
        return new ResponseEntity<>(spProductService.getProductById(Long.valueOf(prodId)), HttpStatus.OK);
    }

    @GetMapping("/productByUpc")
    public ResponseEntity<Product> getProductByUpc(@RequestParam String upc) {
        return new ResponseEntity<>(spProductService.getProductByUpc(upc), HttpStatus.OK);
    }

    @GetMapping("/ingredient")
    public ResponseEntity<Ingredient> getIngredient(@RequestParam String ingredientId) {
        return new ResponseEntity<>(spProductService.getIngredientInfoById(ingredientId), HttpStatus.OK);
    }

    @GetMapping("/ingredientWithAmount")
    public ResponseEntity<Ingredient> getIngredientByIdAndAmount(@RequestParam String ingredientId, @RequestParam String amount) {
        return new ResponseEntity<>(spProductService.getIngredientInfoByIdWithAmount(ingredientId, new BigDecimal(amount)), HttpStatus.OK);
    }

    @GetMapping("/ingredientSubstitutes")
    public ResponseEntity<IngredientSubtitutes> getIngredientSubstitutes(@RequestParam String ingredient) {
        return new ResponseEntity<>(spProductService.getIngredientSubtitutes(ingredient), HttpStatus.OK);
    }

    @GetMapping("/productSearch")
    public ResponseEntity<SearchProducts> getSearchProduct(@RequestParam String queryString) {
        return new ResponseEntity<>(spProductService.getSearchProductsByQuery(queryString), HttpStatus.OK);
    }

    @GetMapping("/partialProductSearch")
    public ResponseEntity<AutocompleteProductSearch> getAutocompleteProductSearch(@RequestParam String queryString, @RequestParam String number) {
        return new ResponseEntity<>(spProductService.getAutocompleteProductSearch(queryString, Integer.valueOf(number)), HttpStatus.OK);
    }

    @GetMapping("/ingredientSubstitutesById")
    public ResponseEntity<IngredientSubtitutes> getIngredientSubstitutesById(@RequestParam String ingredientId) {
        return new ResponseEntity<>(spProductService.getIngredientSubtitutesById(ingredientId), HttpStatus.OK);
    }

    @GetMapping("/recipeById")
    public ResponseEntity<Recipe> getRecipeById(@RequestParam String recipeId) {
        return new ResponseEntity<>(spProductService.getRecipeById(recipeId), HttpStatus.OK);
    }

    @GetMapping("/similarRecipes")
    public ResponseEntity<List<Recipe>> getSimilarRecipes(@RequestParam String recipeId) {
        return new ResponseEntity<>(spProductService.getSimilarRecipes(recipeId), HttpStatus.OK);
    }


}