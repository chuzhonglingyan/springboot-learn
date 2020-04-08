package com.yuntian.helloworld;

import com.yuntian.helloworld.properties.MyProperties;
import com.yuntian.helloworld.properties.TestProerties;
import com.yuntian.helloworld.service.CmdService;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;

import javax.annotation.Resource;

@SpringBootTest
@Slf4j
class HelloWorldApplicationTests {

    @Resource
    private TestProerties testProperties;

    @Resource
    private MyProperties myProperties;

    @Resource
    private CmdService cmdService;

    @Resource
    private ApplicationContext context;


    @Test
    void contextLoads() {
        log.info("count:"+testProperties.getCount());
        log.info("url:"+myProperties.getUrl());
        log.info("secret:"+myProperties.getSecret());
        log.info(context.getEnvironment().getProperty("os.name")
                + "系统下的列表命令："
                + cmdService.listCmd());
    }

}
