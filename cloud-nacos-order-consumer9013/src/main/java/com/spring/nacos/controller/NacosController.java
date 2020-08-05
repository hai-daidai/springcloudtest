package com.spring.nacos.controller;


import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

@RestController
public class NacosController {
    @Resource
    private RestTemplate restTemplate;
    @Value("${server.port}")
    private String serverPort;

    @GetMapping("consumer/getNacos")
    public String getNacos(){
       return restTemplate.getForObject("http://nacos/getNacos",String.class);
    }
}
