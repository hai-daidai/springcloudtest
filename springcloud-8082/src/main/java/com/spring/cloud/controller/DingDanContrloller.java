package com.spring.cloud.controller;


import com.spring.cloud.config.ResultConfig;
import com.spring.cloud.entity.Dingdan;
import com.spring.cloud.ribbon.MyRibbonInterface;
import com.spring.cloud.service.DingDanService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

@RestController
@Controller
public class DingDanContrloller {

    @Resource
    private DingDanService service;
    @Value("${server.port}")
    private  String serverPost;

    @Resource
    private DiscoveryClient discoveryClient;

    @Resource
    private MyRibbonInterface myRibbonInterface;

    @RequestMapping("/addDingdan")
    public ResultConfig addDingDan(@RequestBody Dingdan dingdan) {
        int count = service.create(dingdan);
        if (count > 0) {
            return new ResultConfig(200, "添加成功"+serverPost, count);
        } else {
            return new ResultConfig(404, "添加失败"+serverPost, count);
        }
    }

    @GetMapping("/getDingDan")
    public ResultConfig getDingDan(long id) {
        Dingdan dingdan = service.getDingdan(id);
        if (dingdan != null) {
            return new ResultConfig(200, "获取成功"+serverPost, dingdan);
        } else {
            return new ResultConfig(404, "获取失败"+serverPost, dingdan);
        }
    }
    @GetMapping("/hello")
    public ResultConfig test() {
        return  new ResultConfig(200,"xixi");
    }

    @GetMapping("/getRibbon")
    public ResultConfig getRibbon() {
        return  new ResultConfig(200,"成功",serverPost);
    }
}

