package com.starkend.elastictest.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class ProductDto implements Comparable<ProductDto> {

    private Long gtin14;

    @JsonProperty("brand_name")
    private String brandName;

    private String name;
    private String size;
    private String ingredients;

    @JsonProperty("serving_size")
    private String servingSize;

    @JsonProperty("servings_per_container")
    private String servingsPerContainer;
    private String calories;

    @JsonProperty("fat_calories")
    private String fatCalories;
    private String fat;

    @JsonProperty("saturated_fat")
    private String saturatedFat;

    @JsonProperty("trans_fat")
    private String transFat;

    @JsonProperty("polyunsaturated_fat")
    private String polyunsaturatedFat;

    @JsonProperty("monounsaturated_fat")
    private String monounsaturatedFat;
    private String cholesterol;
    private String sodium;
    private String potassium;
    private String carbohydrate;
    private String fiber;
    private String sugars;
    private String protein;
    private String author;
    private String format;
    private String publisher;
    private String pages;

    @JsonProperty("alcohol_by_volume")
    private String alcoholByVolume;

    @Override
    public int compareTo(ProductDto o) {
        return this.getName().compareTo(o.getName());
    }
}
