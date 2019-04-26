package com.operr.springboot.operrlocations.com.operr.springboot.locations.rest;

import com.mongodb.MongoClient;
import org.springframework.web.bind.annotation.GetMapping;

import java.time.LocalDateTime;

@org.springframework.web.bind.annotation.RestController
public class RestController {

    @GetMapping("/hello")
    public String getHello() {
        MongoClient mongoClient = new MongoClient("0.0.0.0", 8081);
        return "Hello World \n" + mongoClient.getDatabase("admin").getName();
    }
}
