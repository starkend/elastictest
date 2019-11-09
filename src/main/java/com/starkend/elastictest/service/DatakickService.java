package com.starkend.elastictest.service;

import com.starkend.elastictest.dto.ProductDto;
import com.starkend.elastictest.model.Product;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;
import com.starkend.elastictest.util.ProductUtils;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Service
public class DatakickService {

    private static final String QUERY_PARAM = "query";

    @Value("${service.datakick.url}")
    private String BASE_URL;

    private RestTemplate restTemplate;

    public DatakickService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public List<ProductDto> getProductDtoList() {
        HttpEntity<?> entity = new HttpEntity<>(buildHeaders());

        HttpEntity<List<ProductDto>> responseEntity = restTemplate.exchange(
                BASE_URL,
                HttpMethod.GET,
                entity,
                new ParameterizedTypeReference<List<ProductDto>>() {
                }
        );

        return responseEntity.getBody();
    }

    public List<Product> getProductList() {
        List<ProductDto> dtoList = getProductDtoList();
        List<Product> productList = new ArrayList<>();

        dtoList.forEach(productDto -> productList.add(ProductUtils.convertProductDtoToProduct(productDto)));
        return productList;
    }


    public List<ProductDto> getProductDtoListByQuery(String queryString) {
        HttpEntity<?> entity = new HttpEntity<>(buildHeaders());

        //NOTE: The Datakick API requires a plus sign(+) between multi-word search items
        //      For example Peanut Butter would be Peanut+Butter when passed to Datakick
        String preparedQueryString = prepareDatakickQueryString(queryString);

        MultiValueMap<String, String> queryParams = new LinkedMultiValueMap<>();
        queryParams.put(QUERY_PARAM, Collections.singletonList(preparedQueryString));

        UriComponentsBuilder builder = getUriComponentsBuilderWithParams(BASE_URL, queryParams);

        HttpEntity<List<ProductDto>> responseEntity = restTemplate.exchange(
                builder.toUriString(),
                HttpMethod.GET,
                entity,
                new ParameterizedTypeReference<List<ProductDto>>() {
                });

        return responseEntity.getBody();
    }

    private HttpHeaders buildHeaders() {
        HttpHeaders headers = new HttpHeaders();
        headers.set("Accept", MediaType.APPLICATION_JSON_VALUE);
        return headers;
    }

    private UriComponentsBuilder getUriComponentsBuilderWithParams(String url, MultiValueMap<String, String> params) {
        return UriComponentsBuilder.fromUriString(url)
                .queryParams(params);
    }

    private String prepareDatakickQueryString(String inputString) {
        String outputString = inputString
                .trim()
                .replaceAll(" +", " ")
                .replaceAll(" ", "\\+");

        return outputString;
    }

}
