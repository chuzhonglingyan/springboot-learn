package com.yuntian.redis;

/**
 * @author guangleilei.
 * @date Created in 16:01 2019/11/13
 * @description
 */

import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;

import java.util.concurrent.TimeUnit;

/**
 * redis 工具类类
 *
 * @author zhangxinlin
 */
public class RedisClient {

    private RedisTemplate<String, Object> redisTemplate;

    public void setRedisTemplate(RedisTemplate<String, Object> redisTemplate) {
        this.redisTemplate = redisTemplate;
    }


    public void set(String key, String val) {
        ValueOperations<String, Object> ops = redisTemplate.opsForValue();
        ops.set(key, val);
    }

    public void set(String key, String val, long expireSecond) throws Exception {
        ValueOperations<String, Object> ops = redisTemplate.opsForValue();
        ops.set(key, val, expireSecond, TimeUnit.SECONDS);
    }

    public Object get(String key) {
        ValueOperations<String, Object> ops = redisTemplate.opsForValue();
        return ops.get(key);
    }

    public Boolean exists(String key) {
        return redisTemplate.hasKey(key);
    }


    public Boolean setIfAbsent(String key, String val, long expireSecond) {
        ValueOperations<String, Object> ops = redisTemplate.opsForValue();
        return ops.setIfAbsent(key, val, expireSecond, TimeUnit.SECONDS);
    }

    public Boolean delete(String key) {
        return redisTemplate.delete(key);
    }

}
