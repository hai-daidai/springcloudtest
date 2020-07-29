package com.spring.gateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class ApplicationGateWay {
    public static void main(String[] args) {
        System.out.println(SpringApplication.run(ApplicationGateWay.class,args));
    }
}
