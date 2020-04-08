package com.yuntian.mybatisdemo.config;

/**
 * @author guangleilei.
 * @date Created in 17:17 2019/11/14
 * @description
 */
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 数据源选择--自定义注解
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
public @interface DataSourceAnnotation {
    // 默认主表master
    DataSourceEnum value() default DataSourceEnum.MASTER;

}