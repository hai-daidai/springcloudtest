package com.spring.feignhystrix.service;

import com.spring.feignhystrix.global.GlobalHystrix;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Component
@FeignClient(value="CLOUDHYSTRIX8087",fallback = GlobalHystrix.class)
public interface FeignHystrixService {
    @GetMapping("/getHyStrix_ok/{id}")
    public String  getHyStrix_ok(@PathVariable("id") Integer id);

    @GetMapping("/getHyStrix_timeout/{id}")
    public String  getHyStrix_timeout(@PathVariable("id") Integer id);

    @GetMapping("/hyStrix_timeout_rongduan/{id}")
    public String hyStrix_timeout_rongduan(@PathVariable("id") Integer id);
}
