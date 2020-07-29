package com.spring.cloud.controller;

import cn.hutool.core.util.IdUtil;
import com.spring.cloud.service.HyStrixService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@Slf4j
public class HyStrixController {
    @Resource
    private HyStrixService hyStrixService;

    @GetMapping("/getHyStrix_ok/{id}")
    public String  getHyStrix_ok(@PathVariable("id") Integer id){
        return  hyStrixService.hyStrix_ok(id);
    }

    @GetMapping("/getHyStrix_timeout/{id}")
    public String  getHyStrix_timeout(@PathVariable("id") Integer id){
        return  hyStrixService.hyStrix_timeout(id);
    }

    @GetMapping("/hyStrix_timeout_rongduan/{id}")
    public String hyStrix_timeout_rongduan(@PathVariable("id") Integer id){
        return hyStrixService.hyStrix_timeout_rongduan(id);
    }


}
