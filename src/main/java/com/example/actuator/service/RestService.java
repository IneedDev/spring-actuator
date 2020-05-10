package com.example.actuator.service;

import com.example.actuator.dto.Post;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

@Service
public class RestService {

    private final RestTemplate restTemplate;

    public RestService(RestTemplateBuilder restTemplateBuilder) {
        this.restTemplate = restTemplateBuilder.build();
    }

    public String getPostsPlainJson() {
        String url = "https://jsonplaceholder.typicode.com/posts";
        return this.restTemplate.getForObject(url, String.class);
    }

    public Post[] getPostsAsObject() {
        String url = "https://jsonplaceholder.typicode.com/posts";
        return this.restTemplate.getForObject(url, Post[].class);
    }

    public Post getPostWithUrlParameter(String id) {
        String url = "https://jsonplaceholder.typicode.com/posts/{id}";
        return this.restTemplate.getForObject(url, Post.class, id);
    }

    // http response handling
    public Post getPostWithResponseHandling() {
        String url = "https://jsonplaceholder.typicode.com/posts/{id}";
        ResponseEntity<Post> response = this.restTemplate.getForEntity(url, Post.class, 3);
        if (response.getStatusCode() == HttpStatus.OK) {
            System.out.println(response.getStatusCode());
            return response.getBody();
        } else {
            return null;
        }
    }

    //create customer request header
    public Post getPostWithCustomerHeaders() {
        String url = "https://jsonplaceholder.typicode.com/posts/{id}";

        HttpHeaders httpHeaders = new HttpHeaders();
        //set accept header
        httpHeaders.setAccept(Collections.singletonList(MediaType.APPLICATION_ATOM_XML));
        //set customer header
        httpHeaders.set("x-request-source", "desktop");

        HttpEntity request = new HttpEntity(httpHeaders);

        ResponseEntity<Post> response = this.restTemplate.exchange(url, HttpMethod.GET, request, Post.class, 3);
        if(response.getStatusCode() == HttpStatus.OK) {
            return response.getBody();
        } else {
            return null;
        }
    }

    //create new resource

    public Post createPost() {
        String url = "https://jsonplaceholder.typicode.com/posts";
        // create headers
        HttpHeaders headers = new HttpHeaders();
        // set `content-type` header
        headers.setContentType(MediaType.APPLICATION_JSON);
        // set `accept` header
        headers.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));

        //map for entity creation
        Map<String, Object> map = new HashMap<>();
        map.put("userId", 1);
        map.put("title", "Introduction to Spring Boot");
        map.put("body", "Spring Boot makes it easy to create stand-alone, production-grade Spring based Applications.");

        HttpEntity<Map<String, Object>> entity = new HttpEntity<>(map, headers);

        ResponseEntity<Post> response = this.restTemplate.postForEntity(url, entity, Post.class);

        // check response status code
        if (response.getStatusCode() == HttpStatus.CREATED) {
            System.out.println(HttpStatus.CREATED);
            return response.getBody();
        } else {
            return null;
        }
    }


}
