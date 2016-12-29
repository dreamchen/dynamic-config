package com.by.dynamic.config.service.impl;

import com.by.dynamic.config.service.DynamicBean;
import org.springframework.beans.factory.annotation.Value;

/**
 * Created by Erlei Chen on 2016/12/28.
 */
public class DynamicBeanImpl implements DynamicBean {

//    @Value("${nameVal}")
    private String name;
//    @Value("${auto}")
    private String auto;

    public String getAuto() {
        return auto;
    }

    public void setAuto(String auto) {
        this.auto = auto;
        System.out.println("i' m here: setting auto:" + auto);
    }

    public void setName(String name) {
        this.name = name;
        System.out.println("i' m here: setting name:" + name);
    }

    //    @Override
    public String getName() {
        return name;
    }

    public void sayHello() {
        System.out.println("DynamicBean say Hello for " + this.name + "! " + auto);
    }
}
