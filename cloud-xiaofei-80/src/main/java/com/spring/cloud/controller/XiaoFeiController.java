package com.spring.cloud.controller;

import com.spring.cloud.config.ResultConfig;
import com.spring.cloud.entity.Dingdan;
import com.spring.cloud.ribbon.MyRandomInterface;
import com.spring.cloud.ribbon.MyRibbonInterface;
import org.junit.Test;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;
import java.net.URI;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

@RestController
public class XiaoFeiController {
    @Resource
    private RestTemplate restTemplate;

    @Resource
    private DiscoveryClient discoveryClient; //发现客户端的意思

    @Resource
    private MyRibbonInterface myRibbonInterface;

    @Resource
    private MyRandomInterface myRandomInterface;

    @GetMapping("/xiaofei/getDingDan")
    public ResultConfig get(long id){
       return restTemplate.getForObject("http://CLOUD-PROVIDER-SERVICE/getDingDan?id="+id,ResultConfig.class);
    }

    @GetMapping("/xiaofei/addDingdan")
    public ResultConfig<Dingdan> creat(Dingdan dingdan){
        return restTemplate.postForObject("http://CLOUD-PROVIDER-SERVICE/addDingdan",dingdan,ResultConfig.class);
    }

    @GetMapping("/xiaofei/getDispatch")
    public ResultConfig getDispatch(){
        return restTemplate.getForObject("http://CLOUD-PROVIDER-SERVICE/getDispatch",ResultConfig.class);
    }

    @GetMapping("/xiaofei/getDingDan2")
    public ResultConfig get2(long id){
        ResultConfig forObject = restTemplate.getForObject("http://CLOUD-PROVIDER-SERVICE/getDingDan?id=" + id, ResultConfig.class);
        if(forObject.getCode()==200){
            return forObject;
        }else{
            return  new ResultConfig(400,"返回错误消息");
        }
    }
    @GetMapping("/xiaofei/getDingDan3")
    public ResultConfig get3(long id){
        ResponseEntity<ResultConfig> forEntity = restTemplate.getForEntity("http://CLOUD-PROVIDER-SERVICE/getDingDan?id=" + id, ResultConfig.class);
      if(forEntity.getStatusCode().is2xxSuccessful()){
          return forEntity.getBody();
      }else{
          return  new ResultConfig(400,"返回错误消息");
      }
    }
    @GetMapping("/xiaofei/addDingdan2")
    public ResultConfig<Dingdan> creat2(Dingdan dingdan){
        return restTemplate.postForObject("http://CLOUD-PROVIDER-SERVICE/addDingdan",dingdan,ResultConfig.class);
    }
    @GetMapping("/xiaofei/addDingdan3")
    public ResponseEntity<ResultConfig> creat3(Dingdan dingdan){
        return restTemplate.postForEntity("http://CLOUD-PROVIDER-SERVICE/addDingdan", dingdan, ResultConfig.class);
    }

    @GetMapping("/xiaofei/lunxun")
    public void lunxun(){
        List<String> services = discoveryClient.getServices();
        List<ServiceInstance> instances = discoveryClient.getInstances("CLOUD-PROVIDER-SERVICE");
        System.out.println("instances.size() = " + instances.size());
        System.out.println("services = " + services.size());
        System.out.println( discoveryClient.description());
    }

    /**
     * 自定义轮训策略
     * @return
     */
    @GetMapping("/xiaofei/getRibbon")
    public ResultConfig<Dingdan> getRibbon(){
        List<ServiceInstance> instances = discoveryClient.getInstances("CLOUD-PROVIDER-SERVICE");
        ServiceInstance loalBal = myRibbonInterface.getLoalBal(instances);
        URI uri =loalBal.getUri();
        return restTemplate.getForObject(uri+"/getRibbon", ResultConfig.class);
    }
    /**
     * 自定义随机策略
     * @return
     */
    @GetMapping("/xiaofei/getRandom")
    public ResultConfig<Dingdan> getRandom(){
        List<ServiceInstance> instances = discoveryClient.getInstances("CLOUD-PROVIDER-SERVICE");
        ServiceInstance loalBal = myRandomInterface.getLoalBal(instances);
        URI uri =loalBal.getUri();
        return restTemplate.getForObject(uri+"/getRibbon", ResultConfig.class);
    }
}
