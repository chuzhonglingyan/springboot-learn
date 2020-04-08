package com.yuntian.helloworld.condition;

/**
 * @author guangleilei.
 * @date Created in 15:33 2019/10/22
 * @description
 */

import com.yuntian.helloworld.service.CmdService;
import com.yuntian.helloworld.service.impl.LinuxListServiceImpl;
import com.yuntian.helloworld.service.impl.WindowsListServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Conditional;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ConditionConfig {

    /**
     * 当Condition为true,注入生效
     *
     * @return
     */
    @Bean
    @Conditional(WindowsCondition.class)
    public CmdService windowsListService() {
        return new WindowsListServiceImpl();
    }

    /**
     * 当Condition为true,注入生效
     *
     * @return
     */
    @Bean
    @Conditional(LinuxCondition.class)
    public CmdService linuxListService() {
        return new LinuxListServiceImpl();
    }
}