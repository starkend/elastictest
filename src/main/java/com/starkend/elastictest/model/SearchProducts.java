package com.starkend.elastictest.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
@Data
@AllArgsConstructor
@NoArgsConstructor
public class SearchProducts {
    private List<SearchProduct> products;
    private Long totalProducts;
    private Integer offset;
    private Short number;


}
