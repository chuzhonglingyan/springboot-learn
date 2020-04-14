package com.yuntian.mybatisdemo;

import com.alibaba.fastjson.JSON;
import com.yuntian.mybatisdemo.entity.TestUser;
import com.yuntian.mybatisdemo.service.TestUserService;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import sun.rmi.runtime.Log;

import javax.annotation.Resource;

@Slf4j
@SpringBootTest
class MybatisDemoApplicationTests {
    @Resource
    private TestUserService testUserService;


    @Test
    void contextLoads() {
        TestUser  testUser= testUserService.queryById(1L);
        log.info(JSON.toJSONString(testUser));
    }

}
