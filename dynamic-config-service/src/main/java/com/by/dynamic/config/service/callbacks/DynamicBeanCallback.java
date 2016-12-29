package com.by.dynamic.config.service.callbacks;

import com.baidu.disconf.client.common.annotations.DisconfUpdateService;
import com.baidu.disconf.client.common.update.IDisconfUpdate;
import com.by.dynamic.config.service.impl.DynamicBeanImpl;

import javax.annotation.Resource;

/**
 * Created by Erlei Chen on 2016/12/29.
 */
@DisconfUpdateService(confFileKeys = "common.properties")
public class DynamicBeanCallback implements IDisconfUpdate {

    @Resource
    private DynamicBeanImpl dynamicBean;

    @Override
    public void reload() throws Exception {
         System.out.println("this common.properties is callback." + this.dynamicBean.getName() + "/" + this.dynamicBean.getAuto());
    }
}
