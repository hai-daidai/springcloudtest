package com.spring.nacos;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class})
@EnableDiscoveryClient
public class ApplicationNacosOrderConsumer9013 {
    public static void main(String[] args) {
        System.out.println(SpringApplication.run(ApplicationNacosOrderConsumer9013.class,args));
    }
}
