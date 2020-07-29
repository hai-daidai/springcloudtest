package com.spring.cloud.service.Impl;

import com.spring.cloud.dao.DingdanDao;
import com.spring.cloud.entity.Dingdan;
import com.spring.cloud.service.DingDanService;
import org.springframework.stereotype.Service;


import javax.annotation.Resource;
@Service
public class DingDanServiceImpl implements DingDanService {
    @Resource
    private DingdanDao dingdanDao;

    @Override
    public int create(Dingdan dingdan) {
        return dingdanDao.create(dingdan);
    }

    @Override
    public Dingdan getDingdan(Long id) {
        return dingdanDao.getDingdan(id);
    }
}
