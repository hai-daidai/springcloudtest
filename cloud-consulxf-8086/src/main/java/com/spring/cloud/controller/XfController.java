package com.spring.cloud.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

@RestController
public class XfController {
    @Resource
    private RestTemplate restTemplate;

    @GetMapping("xf/getConsl")
    public String getConsl(){
        return  restTemplate.getForObject("http://consultg8085/getConsul",String.class);
    }
}
