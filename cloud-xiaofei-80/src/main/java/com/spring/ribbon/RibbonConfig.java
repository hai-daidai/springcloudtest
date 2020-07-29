package com.spring.ribbon;

import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RandomRule;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @Author jmq
 * @Description 修改默认策略
 * @Date 2020/7/15 0015
 */
@Configuration
public class RibbonConfig {
    @Bean
    public IRule getRandom(){
        return  new RandomRule();
    }
}
