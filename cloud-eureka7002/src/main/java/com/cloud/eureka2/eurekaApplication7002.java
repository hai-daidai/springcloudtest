package com.cloud.eureka2;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@EnableEurekaServer
@SpringBootApplication
public class eurekaApplication7002 {
    public static void main(String[] args) {
        SpringApplication.run(eurekaApplication7002.class,args);
    }
}
