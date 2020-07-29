package com.spring.cloud.service;


import com.spring.cloud.entity.Dingdan;
import org.apache.ibatis.annotations.Param;

//@Service
public interface DingDanService {

    int create(Dingdan dingdan);

    Dingdan getDingdan(@Param("id") Long id);

}
