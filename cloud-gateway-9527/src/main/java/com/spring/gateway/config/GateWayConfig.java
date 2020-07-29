package com.spring.gateway.config;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class GateWayConfig {
    @Bean
    public RouteLocator create(RouteLocatorBuilder builder){
        RouteLocatorBuilder.Builder routes = builder.routes();
        routes.route("jmq",r -> r.path("/guoji").uri("https://news.baidu.com/guoji")).build();
//        "jmq",r -> r.host("/ceshi").uri("https://www.jianshu.com/p/6ff196940b67").build()
        return  routes.build();
    }

}
