package com.spring.cloud.ribbon;

import org.springframework.cloud.client.ServiceInstance;

import java.util.List;

/**
 * @Author jmq
 * @Description 手动编写负载均衡算法
 * @Date 2020/7/15 0015
 */
public interface MyRibbonInterface {

    ServiceInstance getLoalBal(List<ServiceInstance> instances);
}
