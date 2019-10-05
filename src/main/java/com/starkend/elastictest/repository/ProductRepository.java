package com.starkend.elastictest.repository;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.starkend.elastictest.model.Product;
import org.elasticsearch.ElasticsearchException;
import org.elasticsearch.action.DocWriteResponse;
import org.elasticsearch.action.delete.DeleteRequest;
import org.elasticsearch.action.delete.DeleteResponse;
import org.elasticsearch.action.get.GetRequest;
import org.elasticsearch.action.get.GetResponse;
import org.elasticsearch.action.index.IndexRequest;
import org.elasticsearch.action.index.IndexResponse;
import org.elasticsearch.action.search.SearchRequest;
import org.elasticsearch.action.search.SearchResponse;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.client.RestHighLevelClient;
import org.elasticsearch.index.query.QueryBuilder;
import org.elasticsearch.index.query.QueryBuilders;
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

@Repository
public class ProductRepository {

    private static Logger LOG = LoggerFactory.getLogger(ProductRepository.class);

    private final String INDEX = "productindex";
    private final String TYPE = "products";

    private ObjectMapper objectMapper;
    private RestHighLevelClient restHighLevelClient;

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
        final String PRODUCT_NAME_FIELD = "name";
        QueryBuilder matchQueryBuilder = QueryBuilders.matchQuery(PRODUCT_NAME_FIELD, name);
        SearchSourceBuilder searchSourceBuilder = new SearchSourceBuilder();
        searchSourceBuilder.query(matchQueryBuilder);

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
                LOG.error(e.getLocalizedMessage());
            }
        });

        return productList;
    }

    public boolean deleteById(String id) {
        DeleteRequest deleteRequest = new DeleteRequest(INDEX, id);

        DeleteResponse deleteResponse = null;
        try {
            deleteResponse = restHighLevelClient.delete(deleteRequest, RequestOptions.DEFAULT);
        } catch (IOException e) {
            LOG.error(e.getLocalizedMessage());
        }

        if (deleteResponse.getResult().equals(DocWriteResponse.Result.DELETED)) {
            return true;
        } else {
            return false;
        }
    }

    public Product findById(String id) {
        GetRequest getRequest = new GetRequest(INDEX, id);

        GetResponse getResponse = null;
        try {
            getResponse = restHighLevelClient.get(getRequest, RequestOptions.DEFAULT);
        } catch (IOException e) {
            LOG.error(e.getLocalizedMessage());
        }

        Product product = null;
        try {
            product = objectMapper.readValue(getResponse.getSourceAsString(), Product.class);
        } catch (IOException e) {
            e.printStackTrace();
        }

        return product;
    }
}
