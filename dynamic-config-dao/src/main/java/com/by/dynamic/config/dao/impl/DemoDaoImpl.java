package com.by.dynamic.config.dao.impl;

import com.by.dynamic.config.dao.DemoDao;
import com.by.dynamic.config.dao.mapper.DemoMapper;
import com.by.dynamic.config.domain.DemoDomain;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by Erlei Chen on 2016/12/28.
 */
public class DemoDaoImpl implements DemoDao {

    @Resource
    private DemoMapper demoMapper;

    @Override
    public List<DemoDomain> findDemoList() {
        return this.demoMapper.findDemoList();
    }
}
