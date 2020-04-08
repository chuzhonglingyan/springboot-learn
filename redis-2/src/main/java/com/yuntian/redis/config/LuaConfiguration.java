package com.yuntian.redis.config;

/**
 * @author guangleilei.
 * @date Created in 17:57 2019/11/19
 * @description
 */

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.data.redis.core.script.DefaultRedisScript;
import org.springframework.scripting.support.ResourceScriptSource;

/**
 * @author Gjing
 **/
@Configuration
public class LuaConfiguration {
    @Bean
    public DefaultRedisScript<Boolean> redisScript() {
        DefaultRedisScript<Boolean> redisScript = new DefaultRedisScript<>();
        redisScript.setScriptSource(new ResourceScriptSource(new ClassPathResource("script/unLock.lua")));
        redisScript.setResultType(Boolean.class);
        return redisScript;
    }
}

