package com.starkend.elastictest.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.starkend.elastictest.model.Product;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;

@Service
public class SPProductService {

    private static final String API_KEY_PARAM = "apiKey";

    @Value("${service.spoonacular.url}")
    private String BASE_URL;

    @Value("${service.spoonacular.apiKey}")
    private String API_KEY;

    private final RestTemplate restTemplate;

    private final ObjectMapper objectMapper;

    public SPProductService(RestTemplate restTemplate, ObjectMapper objectMapper) {
        this.restTemplate = restTemplate;
        this.objectMapper = objectMapper;
    }

    public Product getProduct(Long productId) {
        String url = BASE_URL + "/food/products/" + productId + "?" + API_KEY_PARAM + "=" + API_KEY;

        HttpEntity<String> response = getStringResponse(url);

        return processProductResponse(response);
    }

    private Product processProductResponse(HttpEntity<String> response) {
        Product product;

        if (response != null) {
            try {
                product = objectMapper.readValue(response.getBody(), Product.class);
            } catch (IOException e) {
                e.printStackTrace();
                return null;
            }
        } else {
            return null;
        }

        return product;

    }

    private HttpHeaders buildHeaders() {
        HttpHeaders headers = new HttpHeaders();
        headers.set("Accept", MediaType.APPLICATION_JSON_VALUE);
        return headers;
    }


    private HttpEntity<String> getStringResponse(String url) {
        HttpEntity<?> entity = new HttpEntity<>(buildHeaders());

        return restTemplate.exchange(
                url,
                HttpMethod.GET,
                entity,
                String.class);
    }

}
