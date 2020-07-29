package com.spring.feign.controller;

import com.spring.cloud.config.ResultConfig;
import com.spring.feign.serivce.FeignInteface;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
public class FeignController {
    @Resource
    private FeignInteface feignInteface;
    @GetMapping("/consumer/getDingDan")
    public ResultConfig getDingDan(long id){
       return feignInteface.getDingDan(id);
    }

    @GetMapping("/consumer/getFeign")
    public ResultConfig getFeign(){
        return feignInteface.getFeign();
    }
}
