package com.spring.consumer8802;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication(exclude= {DataSourceAutoConfiguration.class})
public class ApplicationConsumer8802 {
    public static void main(String[] args) {
        System.out.println(SpringApplication.run(ApplicationConsumer8802.class,args));
    }
}
