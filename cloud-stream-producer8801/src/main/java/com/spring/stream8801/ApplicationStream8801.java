package com.spring.stream8801;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication(exclude= {DataSourceAutoConfiguration.class})
public class ApplicationStream8801 {
    public static void main(String[] args) {
        System.out.println(SpringApplication.run(ApplicationStream8801.class,args));
    }
}
