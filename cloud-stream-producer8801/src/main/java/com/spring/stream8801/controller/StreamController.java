package com.spring.stream8801.controller;

import com.spring.stream8801.service.StreamService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
public class StreamController {
    @Resource
    private StreamService streamService;
    @GetMapping("/getMessage")
    public  String  getMessage(){
        String str = streamService.send();
        System.out.println(str);
        return str;
    }
}
