package com.spring.stream8803;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class})
public class ApplicationStream8803 {
    public static void main(String[] args) {
        System.out.println(SpringApplication.run(ApplicationStream8803.class,args));
    }
}
