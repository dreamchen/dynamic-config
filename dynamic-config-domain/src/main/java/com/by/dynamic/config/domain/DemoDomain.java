package com.by.dynamic.config.domain;

import java.io.Serializable;

/**
 * Created by Erlei Chen on 2016/12/28.
 */
public class DemoDomain implements Serializable {

    private static final long serialVersionUID = -5542679716458646578L;

    private String demoId;
    private String demoName;

    public String getDemoId() {
        return demoId;
    }

    public void setDemoId(String demoId) {
        this.demoId = demoId;
    }

    public String getDemoName() {
        return demoName;
    }

    public void setDemoName(String demoName) {
        this.demoName = demoName;
    }
}
