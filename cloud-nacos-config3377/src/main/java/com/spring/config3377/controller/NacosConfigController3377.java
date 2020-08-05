package com.spring.config3377.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RefreshScope  //刷新配置
public class NacosConfigController3377 {
     @Value("${config.info}")
    private  String configInfo;
    @GetMapping("/getConfigInfo")
     public  String getConfigInfo(){
        return  "nacos config ok,"+configInfo;
     }

}
