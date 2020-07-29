package com.spring.cloud.ribbon;

import org.springframework.cloud.client.ServiceInstance;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

@Component
public class MyRibbon implements  MyRibbonInterface{
    private  AtomicInteger atomicInteger = new AtomicInteger(0);
    final int choose(){

        int current;
        int next;
        do{
            current = this.atomicInteger.get();
            next = current>=20?0:current+1;
        }while (!atomicInteger.compareAndSet(current,next));
        return next;
    }

    @Override
    public ServiceInstance getLoalBal(List<ServiceInstance> instances) {
       int current =  choose()%instances.size();
        return instances.get(current);
    }
}
