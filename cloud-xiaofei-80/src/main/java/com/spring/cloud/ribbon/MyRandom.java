package com.spring.cloud.ribbon;

import org.springframework.cloud.client.ServiceInstance;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

@Component
public class MyRandom  implements  MyRandomInterface{
//    choose -- 选择的意思
    final  int  chooseRandomInt(int serverSize){
        return ThreadLocalRandom.current().nextInt(serverSize);
    }
    @Override
    public ServiceInstance getLoalBal(List<ServiceInstance> instances) {
        int randomInt = chooseRandomInt(instances.size());
        return instances.get(randomInt);
    }
}
