package com.yuntian.redis.service.impl;


import com.yuntian.redis.service.RedisLuaService;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.script.DefaultRedisScript;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import javax.annotation.Resource;

/**
 * @Auther: yuntian
 * @Date: 2019/11/22 0022 00:05
 * @Description: https://www.cnblogs.com/barrywxx/p/8563533.html
 */
@Service
public class RedisLuaServiceImpl implements RedisLuaService {

    private static final String RATE_LIMITINGL = "rate.limit:";

    @Resource
    private RedisTemplate redisTemplate;

    @Resource
    private DefaultRedisScript<Boolean> redisLimitScript;


    @Override
    public Boolean rateLimit(String key, Integer times, Integer expire) {
        if (StringUtils.isEmpty(key)) {
            return Boolean.TRUE;
        }
        Map<String, Integer> argvMap = new HashMap<>();
        argvMap.put("count", times);
        argvMap.put("expire", expire);
        return (Boolean) redisTemplate.execute(redisLimitScript, Collections.singletonList(RATE_LIMITINGL + key), argvMap);
    }
}
