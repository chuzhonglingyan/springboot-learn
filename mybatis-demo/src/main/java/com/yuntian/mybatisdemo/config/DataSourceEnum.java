package com.yuntian.mybatisdemo.config;

/**
 * @author guangleilei.
 * @date Created in 17:16 2019/11/14
 * @description
 */

public enum DataSourceEnum {

    // 主表
    MASTER("master"),
    // 从表
    SLAVE("slave");

    private String name;

    DataSourceEnum(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}