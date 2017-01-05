package com.by.dynamic.config.dao.uitl.dynamicdatasource;

import com.alibaba.druid.pool.DruidDataSource;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.jdbc.datasource.lookup.AbstractRoutingDataSource;

import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * Created by Erlei Chen on 2017/1/4.
 */
public class DynamicDataSource extends AbstractRoutingDataSource {


    private static Map<Object, Object> targetDataSources = new LinkedHashMap<Object, Object>();
    private static boolean forceInit = false;
    private static DruidDataSource defaultDetaSource;

    public static DruidDataSource getDefaultDetaSource() {
        return defaultDetaSource;
    }

    public static void setDefaultDetaSource(DruidDataSource defaultDetaSource) {
        DynamicDataSource.defaultDetaSource = defaultDetaSource;
    }

    public static Map<Object, Object> getTargetDataSources() {
        return targetDataSources;
    }

    public static void putTargetDataSources(String key, DruidDataSource dataSource) {
        Iterator iter = targetDataSources.keySet().iterator();
        boolean bool = false;
        while (iter.hasNext()) {
            String mapKey = (String) iter.next();
            if (mapKey.equals(key)) {
                bool = true;
            }
        }
        if (bool) {
            DruidDataSource dds = (DruidDataSource) targetDataSources.get(key);
            if (dds != null) {
                dds.close();
            }
            targetDataSources.remove(key);
        }
        targetDataSources.put(key, dataSource);
        forceInit = true;
    }

    public void forceTargetDataSources() {
        if (forceInit) {
            this.setTargetDataSources(targetDataSources);
            this.setDefaultTargetDataSource(targetDataSources.get(0));
            this.afterPropertiesSet();
            if (defaultDetaSource != null) {
                this.setDefaultTargetDataSource(defaultDetaSource);
            }
            forceInit = false;
        }
    }

    @Override
    protected Object determineCurrentLookupKey() {
        forceTargetDataSources();
        return DataSourceContextHolder.getDataSouce();
    }
}
