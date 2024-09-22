package com.example.service.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "other-microservice", url = "${demo.pod}")
public interface FeignClientDemo {

    @GetMapping("/hello/{name}")
    String callSomeEndpoint(@PathVariable("name") String name);
}
