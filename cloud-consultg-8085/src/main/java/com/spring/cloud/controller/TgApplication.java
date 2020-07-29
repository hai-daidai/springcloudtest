package com.spring.cloud.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.net.InetAddress;

@RestController
public class TgApplication {
    @GetMapping("/getConsul")
    public String getConsul() throws  Exception{
        return InetAddress.getLocalHost().getHostAddress();
    }

}
