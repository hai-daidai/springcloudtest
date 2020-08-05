package com.spring.config3377;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class})
@EnableDiscoveryClient
public class ApplicationNacosConfig3377 {
    public static void main(String[] args) {
        System.out.println(SpringApplication.run(ApplicationNacosConfig3377.class,args));
    }
}
