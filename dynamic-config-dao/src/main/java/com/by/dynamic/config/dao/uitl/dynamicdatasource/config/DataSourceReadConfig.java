package com.by.dynamic.config.dao.uitl.dynamicdatasource.config;

import com.baidu.disconf.client.common.annotations.DisconfFile;
import com.baidu.disconf.client.common.annotations.DisconfFileItem;

/**
 * Created by Erlei Chen on 2017/1/5.
 */
@DisconfFile(filename = "mysql.read.properties")
public class DataSourceReadConfig {
    public static final String SOURCE_ID = "plane.DataSourceRead";
    private static String url;
    private static String username;
    private static String password;

    @DisconfFileItem(name = "mysql.read.url", associateField = "url")
    public static String getUrl() {
        return url;
    }

    public static void setUrl(String url) {
        DataSourceReadConfig.url = url;
    }

    @DisconfFileItem(name = "mysql.read.username", associateField = "username")
    public static String getUsername() {
        return username;
    }

    public static void setUsername(String username) {
        DataSourceReadConfig.username = username;
    }

    @DisconfFileItem(name = "mysql.read.password", associateField = "password")
    public static String getPassword() {
        return password;
    }

    public static void setPassword(String password) {
        DataSourceReadConfig.password = password;
    }
}
