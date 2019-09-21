package com.starkend.elastictest.repository;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.starkend.elastictest.model.Product;
import org.elasticsearch.ElasticsearchException;
import org.elasticsearch.action.index.IndexRequest;
import org.elasticsearch.action.index.IndexResponse;
import org.elasticsearch.action.search.SearchRequest;
import org.elasticsearch.action.search.SearchResponse;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.client.RestHighLevelClient;
import org.elasticsearch.index.query.QueryBuilder;
import org.elasticsearch.index.query.QueryBuilders;
import org.elasticsearch.search.SearchHit;
import org.elasticsearch.search.SearchHits;
import org.elasticsearch.search.builder.SearchSourceBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Repository
public class ProductRepository {

    private static Logger LOG = LoggerFactory.getLogger(ProductRepository.class);

    private final String INDEX = "productindex";
    private final String TYPE = "products";
    private final String PRODUCT_NAME_FIELD = "name";

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

    public List<Product> findByName(String name) {
        SearchRequest searchRequest = new SearchRequest(INDEX);
        QueryBuilder matchQueryBuilder = QueryBuilders.matchQuery(PRODUCT_NAME_FIELD, name);
        SearchSourceBuilder searchSourceBuilder = new SearchSourceBuilder();
        searchSourceBuilder.query(searchSourceBuilder.query());

        searchRequest.source(searchSourceBuilder);


        SearchResponse searchResponse = null;
        try {
            searchResponse = restHighLevelClient.search(searchRequest, RequestOptions.DEFAULT);
        } catch (IOException e) {
            LOG.error(e.getLocalizedMessage());
        }

        SearchHits hits = searchResponse.getHits();

        List<Product> productList = new ArrayList<>();

        Arrays.stream(hits.getHits()).forEach(hit -> {
            String source = hit.getSourceAsString();
            try {
                Product product = objectMapper.readValue(source, Product.class);
                productList.add(product);
            } catch (IOException e) {
                e.printStackTrace();
            }
        });

        return productList;
    }
}
