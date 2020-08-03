package com.spring.config3355.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RefreshScope
public class TestController {

    @Value("${config.info}")
    private  String configinfo;
    @RequestMapping("/configinfo")
    public String configinfo(){
        return  configinfo;
    }
}
