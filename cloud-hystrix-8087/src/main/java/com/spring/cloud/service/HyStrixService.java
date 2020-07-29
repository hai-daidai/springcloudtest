package com.spring.cloud.service;

import cn.hutool.core.util.IdUtil;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import org.springframework.stereotype.Service;

import java.util.concurrent.TimeUnit;

@Service
public class HyStrixService {


    public String hyStrix_ok(Integer id){
        return "线线程数："+Thread.currentThread().getName()+" id"+id;
    }

    public String hyStrix_okHandel(Integer id){
        return "线线程数："+Thread.currentThread().getName()+" id"+id+"运行异常或者超市报错";
    }

    @HystrixCommand(fallbackMethod="hyStrix_okHandel",commandProperties={
            @HystrixProperty(name="execution.isolation.thread.timeoutInMilliseconds",value = "3000")
    })
    public String hyStrix_timeout(Integer id){
//        int a = 10/0;
        try{
         TimeUnit.SECONDS.sleep(5);
            return "线线程数："+Thread.currentThread().getName()+" id"+id+"睡眠3秒";
        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }
@HystrixCommand(fallbackMethod = "hyStrix_timeout_rongduanHandel",commandProperties={
        @HystrixProperty(name = "circuitBreaker.enabled",value = "true"),
        @HystrixProperty(name = "circuitBreaker.requestVolumeThreshold",value = "6"),
        @HystrixProperty(name = "circuitBreaker.sleepWindowInMilliseconds",value = "5000"),
        @HystrixProperty(name = "circuitBreaker.errorThresholdPercentage",value = "50")
})
    public String hyStrix_timeout_rongduan(Integer id){
        if(id<0){
            throw  new RuntimeException("id不能为负数");
        }
        String uuid = IdUtil.simpleUUID();
        return "参数id:"+id+"=============="+"uuid:"+uuid;
    }

    public String hyStrix_timeout_rongduanHandel(Integer id){
        return "id 参数不能是负数";
    }
}
