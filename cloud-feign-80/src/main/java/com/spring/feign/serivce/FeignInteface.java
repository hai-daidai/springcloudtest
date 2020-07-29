package com.spring.feign.serivce;

import com.spring.cloud.config.ResultConfig;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Component
@FeignClient(value="CLOUD-PROVIDER-SERVICE")
public interface FeignInteface {

    @GetMapping("/getDingDan")
    public ResultConfig getDingDan(@RequestParam("id") long id);

    @GetMapping("/getFeign")
    public ResultConfig getFeign();
}
