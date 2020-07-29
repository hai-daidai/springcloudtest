package com.spring.feignhystrix.controller;

import com.netflix.hystrix.contrib.javanica.annotation.DefaultProperties;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import com.spring.feignhystrix.global.GlobalHystrix;
import com.spring.feignhystrix.service.FeignHystrixService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@Slf4j
//@DefaultProperties(defaultFallback = "global")
public class FeignHystrixController {
    @Resource
    private FeignHystrixService feignHystrixService;
    @GetMapping("/cosumer/getHyStrix_ok/{id}")
    public String  getHyStrix_ok(@PathVariable("id") Integer id){
        return  feignHystrixService.getHyStrix_ok(id);
    }

 /* @HystrixCommand(fallbackMethod="getHyStrix_timeoutHandel",commandProperties={
            @HystrixProperty(name="execution.isolation.thread.timeoutInMilliseconds",value = "1000")
    })*/

//    @HystrixCommand
    @GetMapping("/cosumer/getHyStrix_timeout/{id}")
    public String  getHyStrix_timeout(@PathVariable("id") Integer id){
        int a = 10/0;
        return  feignHystrixService.getHyStrix_timeout(id);
    }

    public String getHyStrix_timeoutHandel(@PathVariable("id") Integer id){
        return  "运行异常或者超时报错";
    }

    public String global(){
        return  "全局运行异常或者超时报错";
    }
}
