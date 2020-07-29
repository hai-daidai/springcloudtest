package com.spring.cloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient //开启发现客户端自动配置
public class ZookeepApplication {
    public static void main(String[] args) {
        SpringApplication.run(ZookeepApplication.class,args);
    }
}
