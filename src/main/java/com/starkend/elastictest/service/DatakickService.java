package com.starkend.elastictest.service;

import com.starkend.elastictest.dto.ProductDto;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
public class DatakickService {

    @Value("${service.datakick.url}")
    private String BASE_URL;

    private RestTemplate restTemplate;

    public DatakickService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public List<ProductDto> getItemsList() {
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

    private HttpHeaders buildHeaders() {
        HttpHeaders headers = new HttpHeaders();
        headers.set("Accept", MediaType.APPLICATION_JSON_VALUE);
        return headers;
    }
}
