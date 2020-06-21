# elastictest

Elasticsearch proof of concept
- Using the Rest High Level Client in order to utilize the latest version of Elasticsearch. The Spring Data repo version is behind and incompatible with the latest Elasticsearch version.

# Built with
- **Spring Boot**
- **Elasticsearch**
    - run with Docker
    - docker pull docker.elastic.co/elasticsearch/elasticsearch:7.3.2
    - Create directory to store Elasticsearch data beyond the life of the docker container
        - sudo mkdir -p $PWD/elasticsearch/data
        - sudo chmod 777 -R $PWD/elasticsearch/data
    - docker run -p 9200:9200 -p 9300:9300 -v $PWD/elasticsearch/data:/usr/share/elasticsearch/data -e "discovery.type=single-node" docker.elastic.co/elasticsearch/elasticsearch:7.6.2
- **Datakick API**
  - https://www.datakick.org/api
-  **Swagger**
      - API Documentation
