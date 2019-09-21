package com.starkend.elastictest.repository;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.starkend.elastictest.model.Product;
import org.elasticsearch.ElasticsearchException;
import org.elasticsearch.action.index.IndexRequest;
import org.elasticsearch.action.index.IndexResponse;
import org.elasticsearch.client.ElasticsearchClient;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.client.RestHighLevelClient;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.io.IOException;
import java.util.Map;

@Repository
public class ProductRepository {

    private static Logger LOG = LoggerFactory.getLogger(ProductRepository.class);

    private final String INDEX = "productindex";
    private final String TYPE = "products";

    private ObjectMapper objectMapper;
    private RestHighLevelClient restHighLevelClient;

    @Autowired
    public ProductRepository(ObjectMapper objectMapper, RestHighLevelClient restHighLevelClient) {
        this.objectMapper = objectMapper;
        this.restHighLevelClient = restHighLevelClient;
    }

    public Product insertProduct(Product product) {
        Map attrMap = objectMapper.convertValue(product, Map.class);
        IndexRequest indexRequest = new IndexRequest(INDEX)
                .id(product.getId())
                .source(attrMap);

        try {
            IndexResponse response = restHighLevelClient.index(indexRequest, RequestOptions.DEFAULT);
        } catch (ElasticsearchException e) {
            LOG.error(e.getDetailedMessage());
        } catch (IOException ioe) {
            LOG.error(ioe.getLocalizedMessage());
        }

        return product;
    }
}
