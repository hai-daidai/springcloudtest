package com.spring.cloud.controller;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.net.InetAddress;
import java.util.UUID;

@RestController
@Slf4j
public class ZookeepController {
    @Value("${server.port}")
    private String serverPost;

    @GetMapping("/zk")
    public String  getZk(){
        log.info("spring-cloud-zookeeper serverPost:"+serverPost+ UUID.randomUUID().toString());
        return "spring-cloud-zookeeper serverPost:"+serverPost+ UUID.randomUUID().toString();
    }
    @Test
    public  void aa() throws  Exception{
//        System.out.println(InetAddress.getLocalHost().getHostAddress());
        System.out.println(InetAddress.getLocalHost().getHostAddress());
        System.out.println(InetAddress.getLocalHost().getHostName());



    }
}
