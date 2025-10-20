package com.alamgir.i_consuming_rest_api.service;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import com.alamgir.i_consuming_rest_api.dto.ProductDto;
import com.alamgir.i_consuming_rest_api.dto.another.ProductDto2;
import com.alamgir.i_consuming_rest_api.request.ProductRequest;

@Service
public class ProductService {

    public ResponseEntity<ProductDto[]> getAllProduct() {

        String url = "https://api.escuelajs.co/api/v1/products";
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<ProductDto[]> productResponseEntity = restTemplate.getForEntity(url, ProductDto[].class);
        return productResponseEntity;
    }

    public ResponseEntity<ProductDto> getProduct(int id) {

        String url = "https://api.escuelajs.co/api/v1/products/{id}";
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<ProductDto> productResponseEntity = restTemplate.getForEntity(url, ProductDto.class, id);
        return productResponseEntity;
    }

    public ResponseEntity<ProductDto> updateProduct(int id, ProductRequest productRequest) {

        String url = "https://api.escuelajs.co/api/v1/products/{id}";
        RestTemplate restTemplate = new RestTemplate();
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        HttpEntity<ProductRequest> entity = new HttpEntity<>(productRequest, headers);
        return restTemplate.exchange(url, HttpMethod.PUT, entity, ProductDto.class, id);
    }




    // _________________________________ Another Example ___________

    public ResponseEntity<ProductDto2> getProduct2(int id) {

        String url = "https://fakestoreapi.com/products/{id}";
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<ProductDto2> productResponseEntity = restTemplate.getForEntity(url, ProductDto2.class, id);
        return productResponseEntity;
    }

    public ResponseEntity<ProductDto2> updateProduct2(int id, ProductDto2 productsDto) {

        RestTemplate restTemplate = new RestTemplate();
        String url = "https://fakestoreapi.com/products/{id}";
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        HttpEntity<ProductDto2> entity = new HttpEntity<>(productsDto, headers);
        return restTemplate.exchange(url, HttpMethod.PUT, entity, ProductDto2.class, id);
    }

}
