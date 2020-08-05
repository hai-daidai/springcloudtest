package com.spring.sleuth9412.controller;

import com.spring.cloud.config.RestConfig;
import com.spring.cloud.config.ResultConfig;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

@RestController
public class SleuthConsumer {
    @Resource
    private RestTemplate restTemplate;

    @GetMapping("/consumer/getSleuth")
    public ResultConfig getSleuth(){
       return restTemplate.getForObject("http://SLEUTH-PRO9412/getSleuth",ResultConfig.class);
    }
}
