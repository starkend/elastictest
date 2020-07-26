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
public class Ingredient {
    private Long id;
    private String aisle;
    private String name;
    private String image;
    private BigDecimal amount;
    private String consistency;
    private IngredientEstimatedCost estimatedCost;
    private List<String> meta;
    private String original;
    private String originalName;
    private List<String> shoppingListUnits;
    private String unit;
    private String unitLong;
    private String unitShort;
    private List<String> possibleUnits;
    private Measures measures;
}
