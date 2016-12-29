package com.by.dynamic.config.dao;

import com.by.dynamic.config.domain.DemoDomain;

import java.util.List;

/**
 * Created by Erlei Chen on 2016/12/28.
 */
public interface DemoDao {

    List<DemoDomain> findDemoList();
}
