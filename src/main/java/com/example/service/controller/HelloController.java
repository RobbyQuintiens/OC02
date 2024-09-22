package com.example.service.controller;

import com.example.service.client.FeignClientDemo;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    private FeignClientDemo feignClient;

    public HelloController(FeignClientDemo feignClient) {
        this.feignClient = feignClient;
    }

    @Value("${demo.pod}")
    private static String demoUrl;

    @GetMapping("/hello/{name}")
    public ResponseEntity<String> hello(@PathVariable("name") String name) {
        return ResponseEntity.ok("Service Pod " + feignClient.callSomeEndpoint(name));
    }
}
