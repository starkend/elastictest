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
public class Nutrient {
    private String title;
    private BigDecimal amount;
    private String unit;
    private BigDecimal percentOfDailyNeeds;
}
