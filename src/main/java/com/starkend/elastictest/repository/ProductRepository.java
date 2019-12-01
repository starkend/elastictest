package com.starkend.elastictest.repository;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.starkend.elastictest.model.Product;
import org.elasticsearch.ElasticsearchException;
import org.elasticsearch.action.DocWriteResponse;
import org.elasticsearch.action.bulk.BulkRequest;
import org.elasticsearch.action.bulk.BulkResponse;
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
import org.springframework.stereotype.Repository;

import java.io.IOException;
import java.util.*;

@Repository
public class ProductRepository {

    private static final int MAX_RESULT_SIZE = 100;
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
        if (product.getId() == null) {
            product.setId(UUID.randomUUID().toString());
        }

        Map attrMap = objectMapper.convertValue(product, Map.class);
        IndexRequest indexRequest = new IndexRequest(INDEX)
                .id(product.getId())
                .source(attrMap);

        IndexResponse response = null;
        DocWriteResponse.Result result = null;

        try {
            response = restHighLevelClient.index(indexRequest, RequestOptions.DEFAULT);
            result = response.getResult();
        } catch (ElasticsearchException e) {
            LOG.error(e.getDetailedMessage());
        } catch (IOException ioe) {
            LOG.error(ioe.getLocalizedMessage());
        }

        switch (result) {
            case CREATED:
            case UPDATED:
                return product;
            default:
                LOG.error("Response result type not CREATED or UPDATED as expected");
                return null;
        }
    }

    public List<Product> findByName(String name) {
        SearchRequest searchRequest = new SearchRequest(INDEX);
        final String PRODUCT_NAME_FIELD = "name";
        QueryBuilder matchQueryBuilder = QueryBuilders.matchQuery(PRODUCT_NAME_FIELD, name);
        SearchSourceBuilder searchSourceBuilder = getSearchSourceBuilder();
        searchSourceBuilder.query(matchQueryBuilder);

        searchRequest.source(searchSourceBuilder);

        SearchResponse searchResponse = null;
        try {
            searchResponse = restHighLevelClient.search(searchRequest, RequestOptions.DEFAULT);
        } catch (IOException e) {
            LOG.error(e.getLocalizedMessage());
        }

        return processSearchResponse(searchResponse);
    }


    public boolean deleteById(String id) {
        DeleteRequest deleteRequest = new DeleteRequest(INDEX, id);

        DeleteResponse deleteResponse = null;
        try {
            deleteResponse = restHighLevelClient.delete(deleteRequest, RequestOptions.DEFAULT);
        } catch (IOException e) {
            LOG.error(e.getLocalizedMessage());
        }

        return deleteResponse.getResult().equals(DocWriteResponse.Result.DELETED);
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
            LOG.error(e.getLocalizedMessage());
        }

        return product;
    }

    public List<Product> getAllProducts() {
        SearchRequest searchRequest = new SearchRequest(INDEX);
        SearchSourceBuilder searchSourceBuilder = getSearchSourceBuilder();
        searchSourceBuilder.query(QueryBuilders.matchAllQuery());
        searchRequest.source(searchSourceBuilder);

        SearchResponse searchResponse = null;

        try {
            searchResponse = restHighLevelClient.search(searchRequest, RequestOptions.DEFAULT);
        } catch (IOException e) {
            LOG.error(e.getLocalizedMessage());
        }

        return processSearchResponse(searchResponse);

    }

    public boolean bulkInsertProducts(List<Product> insertProductList) {
        BulkRequest bulkRequest = new BulkRequest();
        boolean didAllSucceed = false;

        for (Product product : insertProductList) {
            Map attrMap = objectMapper.convertValue(product, Map.class);
            IndexRequest indexRequest = new IndexRequest(INDEX)
                    .id(product.getId())
                    .source(attrMap);
            bulkRequest.add(indexRequest);
        }

        BulkResponse bulkResponse = null;
        try {
            bulkResponse = restHighLevelClient.bulk(bulkRequest, RequestOptions.DEFAULT);
        } catch (IOException e) {
            LOG.error(e.getLocalizedMessage());
        }

        didAllSucceed = !bulkResponse.hasFailures();

        return didAllSucceed;
    }

    private SearchSourceBuilder getSearchSourceBuilder() {
        SearchSourceBuilder searchSourceBuilder = new SearchSourceBuilder();
        searchSourceBuilder.size(MAX_RESULT_SIZE);
        return searchSourceBuilder;
    }

    private List<Product> processSearchResponse(SearchResponse searchResponse) {
        SearchHits hits = searchResponse.getHits();

        if (hits == null) {
            return new ArrayList<Product>();
        }

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

}
