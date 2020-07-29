package com.spring.cloud.controller;


import com.spring.cloud.config.ResultConfig;
import com.spring.cloud.entity.Dingdan;
import com.spring.cloud.ribbon.MyRibbon;
import com.spring.cloud.ribbon.MyRibbonInterface;
import com.spring.cloud.service.DingDanService;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.time.ZonedDateTime;
import java.util.List;
import java.util.concurrent.TimeUnit;

@RestController
@Controller
@Slf4j
public class DingDanContrloller {

    @Resource
    private DingDanService service;
    @Value("${server.port}")
    private  String serverPost;
    @Resource
    private MyRibbonInterface myRibbonInterface;
    @Resource
    private DiscoveryClient discoveryClient; //发现客户端的意思

    @RequestMapping("/addDingdan")//@RequestBody
    public ResultConfig addDingDan(@RequestBody Dingdan dingdan) {
        int count = service.create(dingdan);
        if (count > 0) {
            return new ResultConfig(200, "添加成功"+serverPost, count);
        } else {
            return new ResultConfig(404, "添加失败"+serverPost, count);
        }
    }

    @GetMapping("/getDingDan")
    public ResultConfig getDiscovery(long id) {
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
    @GetMapping("/getDispatch")
    public void getDispatch(){
        List<String> services = discoveryClient.getServices();
        for (String servernName: services) {
            System.out.println("servernName = " + servernName);
            log.info("servernName = " + servernName);
        }
        String description = discoveryClient.description();
        System.out.println("description = " + description);
        int order = discoveryClient.getOrder();
        System.out.println("order = " + order);
        List<ServiceInstance> instances = discoveryClient.getInstances("CLOUD-PROVIDER-SERVICE");
        for (ServiceInstance serviceInstance: instances) {
            System.out.println(serviceInstance.getInstanceId()+","+serviceInstance.getServiceId()+","+serviceInstance.getHost()+","+serviceInstance.getPort()+","+serviceInstance.getUri());
        }
    }
    @GetMapping("/getRibbon")
    public ResultConfig getRibbon() {
      return  new ResultConfig(200,"成功",serverPost);
    }

    @GetMapping("/getFeign")
    public ResultConfig getFeign() {
        try {
            TimeUnit.SECONDS.sleep(3);
        }catch (InterruptedException e){
            e.printStackTrace();
        }
        return  new ResultConfig(200,"成功",serverPost);
    }
    @Test
    public  void test1(){
        ZonedDateTime time = ZonedDateTime.now();
        System.out.println(time);
    }
}

