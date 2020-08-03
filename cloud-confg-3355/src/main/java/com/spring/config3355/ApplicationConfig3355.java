package com.spring.config3355;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication(exclude= {DataSourceAutoConfiguration.class})
@EnableEurekaClient
public class ApplicationConfig3355 {
    public static void main(String[] args) {
        System.out.println(SpringApplication.run(ApplicationConfig3355.class,args));
    }
}
