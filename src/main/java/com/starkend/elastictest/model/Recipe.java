package com.starkend.elastictest.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Recipe {
    private Long id;
    private String title;
    private String image;
    private String imageType;
    private Integer servings;
    private Integer readyInMinutes;
    private String license;
    private String sourceName;
    private String sourceUrl;
    private String spoonacularSourceUrl;
    private Integer aggregateLikes;
    private BigDecimal healthScore;
    private List<String> analyzedInstructions;
    private Boolean cheap;
    private String creditsText;
    private List<String> cuisines;
    private Boolean dairyFree;
    private List<String> diets;
    private String gaps;
    private Boolean glutenFree;
    private String instructions;
    private Boolean ketogenic;
    private Boolean lowFodmap;
    private List<String> occasions;
    private Boolean sustainable;
    private Boolean vegan;
    private Boolean vegetarian;
    private Boolean veryHealthy;
    private Boolean veryPopular;
    private Boolean whole30;
    private Integer weightWatcherSmartPoints;
    private List<String> dishTypes;
    //private List<Ingredient> extendedIngredients;
    private String summary;
    //private List winePairing;


}
