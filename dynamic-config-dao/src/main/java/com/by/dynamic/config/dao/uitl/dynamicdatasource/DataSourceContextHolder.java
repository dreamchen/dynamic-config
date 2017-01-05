package com.by.dynamic.config.dao.uitl.dynamicdatasource;

import java.util.Map;

/**
 * Created by Erlei Chen on 2017/1/4.
 */
public class DataSourceContextHolder {

    public static final ThreadLocal<String> holder = new ThreadLocal<String>();
    public static Map<Object, Object> targetDataSources;

    public static void putDataSource(String name) {
        holder.set(name);
    }

    public static String getDataSouce() {
        return holder.get();
    }

    public static Map<Object, Object> getTargetDataSources() {
        return targetDataSources;
    }

    public static void setTargetDataSources(Map<Object, Object> targetDataSources) {
        DataSourceContextHolder.targetDataSources = targetDataSources;
    }
}
