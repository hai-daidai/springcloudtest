package com.spring.nacos.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class NacosController {
    @Value("${server.port}")
    private String serverPort;

    @GetMapping("/getNacos")
    public String getNacos(){
        return  "nacos-consumer-port"+serverPort;
    }
}
