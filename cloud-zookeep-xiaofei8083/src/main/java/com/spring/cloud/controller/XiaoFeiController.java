package com.spring.cloud.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;
import java.net.InetAddress;
import java.net.UnknownHostException;

@RestController
@Slf4j
public class XiaoFeiController {
    @Resource
    private RestTemplate restTemplate;

    @GetMapping("/getZk")
    public String getZk(){
        return  restTemplate.getForObject("http://cloudzookeeper8084/zk",String.class);
    }
}
