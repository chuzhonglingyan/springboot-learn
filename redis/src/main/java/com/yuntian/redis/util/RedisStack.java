package com.yuntian.redis.util;

import org.springframework.data.redis.core.ListOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import javax.annotation.Resource;

/**
 * @author yuntian
 * @date 2020/4/3 0003 18:53
 * @description
 */
@Component
public class RedisStack {

    @Resource
    private RedisTemplate redisTemplate;

    private final static String PRE = "stack";

    private String getKey(String key) {
        return String.join(":", PRE, key);
    }


    public <V> ListOperations<String, V> getOp() {
        return redisTemplate.opsForList();
    }

    /**
     * 入栈
     *
     * @param key
     * @param v
     * @param time
     * @param <V>
     */
    public <V> void push(String key, V v, long time) {
        push(getKey(key), Collections.singletonList(v), time);
    }

    /**
     * 入栈
     *
     * @param key
     * @param time
     * @param <V>
     */
    public <V> void push(String key, Collection<V> values, long time) {
        getOp().rightPushAll(getKey(key), values, time);
    }

    /**
     * 元素出栈
     *
     * @param key
     * @param <V>
     */
    public <V> void pop(String key) {
        getOp().rightPop(getKey(key));
    }


    public <V> List<V> getAll(String key) {
        return (List<V>) getOp().range(key, 0, -1);
    }

    public <V> V get(String key, long index) {
        return (V) getOp().index(key, index);
    }


}
