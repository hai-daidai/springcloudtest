package com.cloud.dashbo;

import com.netflix.hystrix.contrib.metrics.eventstream.HystrixMetricsStreamServlet;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@EnableHystrixDashboard //启用Hystrix仪表板
public class ApplicationDashbo {
    public static void main(String[] args) {
        System.out.println(SpringApplication.run(ApplicationDashbo.class,args));
    }
}
