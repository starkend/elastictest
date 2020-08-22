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
public class MenuItem {
    private Long id;
    private String title;
    private String restaurantChain;
    private ProductNutrition nutrition;
    private List<String> badges;
    private List<String> breadcrumbs;
    private String generatedText;
    private String imageType;
    private Long likes;
    private BigDecimal numberOfServings;
    private BigDecimal price;
    private BigDecimal readableServingSize;
    private BigDecimal servingSize;
    private BigDecimal spoonacularScore;
}
