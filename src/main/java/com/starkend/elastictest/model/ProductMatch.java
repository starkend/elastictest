package com.starkend.elastictest.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@JsonIgnoreProperties(ignoreUnknown = true)
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductMatch {
    private Long id;
    private String title;
    private String description;
    private BigDecimal price;
    private String imageUrl;
    private BigDecimal averageRating;
    private BigDecimal ratingCount;
    private BigDecimal score;
    private String link;
}
