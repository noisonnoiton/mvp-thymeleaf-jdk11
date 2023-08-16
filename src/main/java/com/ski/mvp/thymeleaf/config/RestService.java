package com.ski.mvp.thymeleaf.config;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class RestService<T> {

    private RestTemplate restTemplate;

    public RestService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public ResponseEntity<T> get(String url, HttpHeaders httpHeaders, Class<T> clazz) {
        return callApiEndpoint(url, HttpMethod.GET, httpHeaders, null, clazz);
    }

    public ResponseEntity<T> post(String url, HttpHeaders httpHeaders, Object body, Class<T> clazz) {
        return callApiEndpoint(url, HttpMethod.POST, httpHeaders, body, clazz);
    }

    public ResponseEntity<T> put(String url, HttpHeaders httpHeaders, Object body, Class<T> clazz) {
        return callApiEndpoint(url, HttpMethod.PUT, httpHeaders, body, clazz);
    }

    public ResponseEntity<T> delete(String url, HttpHeaders httpHeaders, Object body, Class<T> clazz) {
        return callApiEndpoint(url, HttpMethod.DELETE, httpHeaders, body, clazz);
    }

    public ResponseEntity<T> callApiEndpoint(String url, HttpMethod httpMethod, HttpHeaders httpHeaders, Object body,
            Class<T> clazz) {
        return restTemplate.exchange(url, httpMethod, new HttpEntity<>(body, httpHeaders), clazz);
    }
}
