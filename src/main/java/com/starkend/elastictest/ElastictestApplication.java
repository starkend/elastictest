package com.starkend.elastictest;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.starkend.elastictest.service.DatakickService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

import javax.xml.crypto.Data;

@SpringBootApplication
public class ElastictestApplication {

    public static void main(String[] args) {
        SpringApplication.run(ElastictestApplication.class, args);
    }

    @Bean
    public ObjectMapper objectMapper() {
        return new ObjectMapper();
    }

    @Bean
    public RestTemplate restTemplate(RestTemplateBuilder builder) {
        return builder.build();
    }

}
