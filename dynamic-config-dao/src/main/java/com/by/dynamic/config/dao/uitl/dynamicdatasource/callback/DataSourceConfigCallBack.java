package com.by.dynamic.config.dao.uitl.dynamicdatasource.callback;

import com.alibaba.druid.pool.DruidDataSource;
import com.baidu.disconf.client.common.annotations.DisconfUpdateService;
import com.baidu.disconf.client.common.update.IDisconfUpdate;
import com.by.dynamic.config.dao.uitl.dynamicdatasource.DynamicDataSource;
import com.by.dynamic.config.dao.uitl.dynamicdatasource.config.DataSourceConfig;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.ConfigurableApplicationContext;

import java.util.Date;

/**
 * Created by Erlei Chen on 2017/1/5.
 */

@DisconfUpdateService(classes = DataSourceConfig.class)
public class DataSourceConfigCallBack implements IDisconfUpdate, ApplicationContextAware {

    private ConfigurableApplicationContext app;

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.app = (ConfigurableApplicationContext) applicationContext;
    }

    @Override
    public void reload() throws Exception {
        String driverClass = "com.mysql.jdbc.Driver";
        DruidDataSource dataSource = new DruidDataSource();
        dataSource.setDriverClassName(driverClass);
        dataSource.setUrl("jdbc:mysql://" + DataSourceConfig.getUrl() + "?useUnicode=true&characterEncoding=utf-8");
        dataSource.setPoolPreparedStatements(true);
        dataSource.setUsername(DataSourceConfig.getUsername());
        dataSource.setPassword(DataSourceConfig.getPassword());
        DynamicDataSource.putTargetDataSources(DataSourceConfig.SOURCE_ID, dataSource);
        //销毁Spring 注入BeanDataSource
        if (app.getBean(DataSourceConfig.SOURCE_ID) != null) {
            ((DruidDataSource) app.getBean(DataSourceConfig.SOURCE_ID)).close();
        }
        System.out.println("DataSourceConfig reload:" + new Date().getTime());
    }
}
