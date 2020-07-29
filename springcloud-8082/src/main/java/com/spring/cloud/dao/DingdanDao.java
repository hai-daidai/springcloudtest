package com.spring.cloud.dao;



import com.spring.cloud.entity.Dingdan;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface DingdanDao {

    int create(Dingdan dingdan);

    Dingdan getDingdan(@Param("id")Long id);
}
