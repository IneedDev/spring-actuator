package com.example.actuator.controller;

import com.example.actuator.dto.Post;
import com.example.actuator.service.RestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RestTemplateController {

    @Autowired
    RestService restService;

    //response as plain json
    @GetMapping(value = "/get-posts-with-rest-template")
    public String getPostsWithRestTemplate() {
        return restService.getPostsPlainJson();
    }

    // response as object from json request
    @GetMapping(value = "/get-posts-with-rest-template-object")
    public Post[] getPostsWithRestTemplateAsObject() {
        return restService.getPostsAsObject();
    }

    //url parameters
    @GetMapping(value = "/get-posts-with-parameter")
    public Post getPostWithUrlParameter(@RequestParam String id) {
        return restService.getPostWithUrlParameter(id);
    }

    //response HTPP handling
    @GetMapping(value = "/get-posts-http-response")
    public Post getPostWithResponseHandling() {
        return restService.getPostWithResponseHandling();
    }
    @GetMapping(value = "/get-posts-http-header")
    public Post getPostWithCustomerHeaders() {
        return restService.getPostWithCustomerHeaders();
    }
    @PostMapping(value = "/create-post")
    public void createPost() {
        restService.createPost();
        return ;
    }



}
