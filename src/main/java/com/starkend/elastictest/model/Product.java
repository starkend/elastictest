package com.starkend.elastictest.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Product {
    private Long id;
    private String title;
    private List<String> images;
    private List<String> badges;
    @JsonProperty("important_badges")
    private List<String> importantBadges;
    private BigDecimal ingredientCount;
    private String generatedText;
    private String ingredientList;
    private List<ProductIngredient> ingredients;
    private BigDecimal likes;
    @JsonProperty("number_of_servings")
    private BigDecimal numberOfServings;
    private String aisle;
    private ProductNutrition nutrition;
    private BigDecimal price;
    @JsonProperty("serving_size")
    private String servingSize;
    @JsonProperty("spoonacular_score")
    private BigDecimal spoonacularScore;

}
