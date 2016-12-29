package com.by.dynamic.config.service.impl;

import com.by.dynamic.config.dao.DemoDao;
import com.by.dynamic.config.domain.DemoDomain;
import com.by.dynamic.config.service.DemoService;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by Erlei Chen on 2016/12/28.
 */
public class DemoServiceImpl implements DemoService {

    @Resource
    private DemoDao demoDao;

    @Override
    public List<DemoDomain> getDemoList() throws Exception {
        return this.demoDao.findDemoList();
    }
}
