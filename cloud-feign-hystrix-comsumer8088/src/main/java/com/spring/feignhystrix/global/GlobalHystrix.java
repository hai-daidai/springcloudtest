package com.spring.feignhystrix.global;

import com.spring.feignhystrix.service.FeignHystrixService;
import feign.hystrix.FallbackFactory;
import org.springframework.stereotype.Component;

@Component
public class GlobalHystrix implements FeignHystrixService {
    @Override
    public String getHyStrix_ok(Integer id) {
        return "全局 超时或者运行时异常  getHyStrix_ok";
    }
    @Override
    public String getHyStrix_timeout(Integer id) {
        return "全局 超时或者运行时异常   getHyStrix_timeout";
    }

    @Override
    public String hyStrix_timeout_rongduan(Integer id) {
        return "全局 熔断 超时或者运行时异常   getHyStrix_timeout";
    }

}
