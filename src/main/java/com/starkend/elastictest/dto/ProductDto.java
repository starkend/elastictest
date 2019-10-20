package com.starkend.elastictest.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

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

    public Long getGtin14() {
        return gtin14;
    }

    public void setGtin14(Long gtin14) {
        this.gtin14 = gtin14;
    }

    public String getBrandName() {
        return brandName;
    }

    public void setBrandName(String brandName) {
        this.brandName = brandName;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public String getIngredients() {
        return ingredients;
    }

    public void setIngredients(String ingredients) {
        this.ingredients = ingredients;
    }

    public String getServingSize() {
        return servingSize;
    }

    public void setServingSize(String servingSize) {
        this.servingSize = servingSize;
    }

    public String getServingsPerContainer() {
        return servingsPerContainer;
    }

    public void setServingsPerContainer(String servingsPerContainer) {
        this.servingsPerContainer = servingsPerContainer;
    }

    public String getCalories() {
        return calories;
    }

    public void setCalories(String calories) {
        this.calories = calories;
    }

    public String getFatCalories() {
        return fatCalories;
    }

    public void setFatCalories(String fatCalories) {
        this.fatCalories = fatCalories;
    }

    public String getFat() {
        return fat;
    }

    public void setFat(String fat) {
        this.fat = fat;
    }

    public String getSaturatedFat() {
        return saturatedFat;
    }

    public void setSaturatedFat(String saturatedFat) {
        this.saturatedFat = saturatedFat;
    }

    public String getTransFat() {
        return transFat;
    }

    public void setTransFat(String transFat) {
        this.transFat = transFat;
    }

    public String getPolyunsaturatedFat() {
        return polyunsaturatedFat;
    }

    public void setPolyunsaturatedFat(String polyunsaturatedFat) {
        this.polyunsaturatedFat = polyunsaturatedFat;
    }

    public String getMonounsaturatedFat() {
        return monounsaturatedFat;
    }

    public void setMonounsaturatedFat(String monounsaturatedFat) {
        this.monounsaturatedFat = monounsaturatedFat;
    }

    public String getCholesterol() {
        return cholesterol;
    }

    public void setCholesterol(String cholesterol) {
        this.cholesterol = cholesterol;
    }

    public String getSodium() {
        return sodium;
    }

    public void setSodium(String sodium) {
        this.sodium = sodium;
    }

    public String getPotassium() {
        return potassium;
    }

    public void setPotassium(String potassium) {
        this.potassium = potassium;
    }

    public String getCarbohydrate() {
        return carbohydrate;
    }

    public void setCarbohydrate(String carbohydrate) {
        this.carbohydrate = carbohydrate;
    }

    public String getFiber() {
        return fiber;
    }

    public void setFiber(String fiber) {
        this.fiber = fiber;
    }

    public String getSugars() {
        return sugars;
    }

    public void setSugars(String sugars) {
        this.sugars = sugars;
    }

    public String getProtein() {
        return protein;
    }

    public void setProtein(String protein) {
        this.protein = protein;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getFormat() {
        return format;
    }

    public void setFormat(String format) {
        this.format = format;
    }

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public String getPages() {
        return pages;
    }

    public void setPages(String pages) {
        this.pages = pages;
    }

    public String getAlcoholByVolume() {
        return alcoholByVolume;
    }

    public void setAlcoholByVolume(String alcoholByVolume) {
        this.alcoholByVolume = alcoholByVolume;
    }

    @Override
    public int compareTo(ProductDto o) {
        return this.getName().compareTo(o.getName());
    }
}
