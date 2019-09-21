package com.starkend.elastictest.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Product implements Comparable<Product> {

    private String id;
    private Long gtin14;
    private String brandName;
    private String name;
    private String size;
    private String ingredients;
    private String servingSize;
    private String servingsPerContainer;
    private String calories;
    private String fatCalories;
    private String fat;
    private String saturatedFat;
    private String transFat;
    private String polyunsaturatedFat;
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
    private String alcoholByVolume;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

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
    public String toString() {
        return "Product{" +
                "id='" + id + '\'' +
                ", gtin14=" + gtin14 +
                ", brandName='" + brandName + '\'' +
                ", name='" + name + '\'' +
                ", size='" + size + '\'' +
                ", ingredients='" + ingredients + '\'' +
                ", servingSize='" + servingSize + '\'' +
                ", servingsPerContainer='" + servingsPerContainer + '\'' +
                ", calories='" + calories + '\'' +
                ", fatCalories='" + fatCalories + '\'' +
                ", fat='" + fat + '\'' +
                ", saturatedFat='" + saturatedFat + '\'' +
                ", transFat='" + transFat + '\'' +
                ", polyunsaturatedFat='" + polyunsaturatedFat + '\'' +
                ", monounsaturatedFat='" + monounsaturatedFat + '\'' +
                ", cholesterol='" + cholesterol + '\'' +
                ", sodium='" + sodium + '\'' +
                ", potassium='" + potassium + '\'' +
                ", carbohydrate='" + carbohydrate + '\'' +
                ", fiber='" + fiber + '\'' +
                ", sugars='" + sugars + '\'' +
                ", protein='" + protein + '\'' +
                ", author='" + author + '\'' +
                ", format='" + format + '\'' +
                ", publisher='" + publisher + '\'' +
                ", pages='" + pages + '\'' +
                ", alcoholByVolume='" + alcoholByVolume + '\'' +
                '}';
    }

    @Override
    public int compareTo(Product o) {
        return this.getName().compareTo(o.getName());
    }

}
