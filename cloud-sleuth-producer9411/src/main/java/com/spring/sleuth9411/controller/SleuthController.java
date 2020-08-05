package com.spring.sleuth9411.controller;

import com.spring.cloud.config.ResultConfig;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SleuthController {

     @GetMapping("/getSleuth")
    public String getSleuth(){
//         return  new ResultConfig(200,"dgsgdfhbvcx");
         return "gsgdfhbvcx";
     }
  /*  public ResultConfig test() {
        return  new ResultConfig(200,"xixi");
    }*/
}
