package com.yuntian.mybatisdynamic;

import com.alibaba.druid.spring.boot.autoconfigure.DruidDataSourceAutoConfigure;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author Administrator
 */
@MapperScan("com.yuntian.mybatisdynamic.dao")
@SpringBootApplication(exclude = DruidDataSourceAutoConfigure.class)
public class MybatisDynamicDemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(MybatisDynamicDemoApplication.class, args);
    }

}
