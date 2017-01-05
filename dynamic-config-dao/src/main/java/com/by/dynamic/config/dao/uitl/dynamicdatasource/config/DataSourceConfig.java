package com.by.dynamic.config.dao.uitl.dynamicdatasource.config;

import com.baidu.disconf.client.common.annotations.DisconfFile;
import com.baidu.disconf.client.common.annotations.DisconfFileItem;

/**
 * Created by Erlei Chen on 2017/1/5.
 */
@DisconfFile(filename = "mysql.properties")
public class DataSourceConfig {
    public static final String SOURCE_ID = "plane.DataSource";
    private static String url;
    private static String username;
    private static String password;

    @DisconfFileItem(name = "mysql.url", associateField = "url")
    public static String getUrl() {
        return url;
    }

    public static void setUrl(String url) {
        DataSourceConfig.url = url;
    }

    @DisconfFileItem(name = "mysql.username", associateField = "username")
    public static String getUsername() {
        return username;
    }

    public static void setUsername(String username) {
        DataSourceConfig.username = username;
    }

    @DisconfFileItem(name = "mysql.password", associateField = "password")
    public static String getPassword() {
        return password;
    }

    public static void setPassword(String password) {
        DataSourceConfig.password = password;
    }
}
