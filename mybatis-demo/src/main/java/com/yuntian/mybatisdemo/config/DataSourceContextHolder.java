package com.yuntian.mybatisdemo.config;

/**
 * @author guangleilei.
 * @date Created in 17:18 2019/11/14
 * @description
 */

/**
 * 动态数据源的上下文 threadlocal
 * @author guangleilei
 */
public class DataSourceContextHolder {
    private final static ThreadLocal<String> LOCAL = new ThreadLocal<>();

    public static void putDataSource(String name) {
        LOCAL.set(name);
    }

    public static String getCurrentDataSource() {
        return LOCAL.get();
    }

    public static void removeCurrentDataSource() {
        LOCAL.remove();
    }

}