package com.yuntian.redis;

import org.junit.jupiter.api.Test;
import org.redisson.api.RedissonClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import lombok.extern.slf4j.Slf4j;

/**
 * @author guangleilei.
 * @date Created in 16:09 2019/11/13
 * @description
 */
@Slf4j
@SpringBootTest
public class RedisClientTest {
    @Autowired
    RedisClient redisClient;

    @Autowired
    RedissonClient redissonClient;


    @Test
    void testRedis() throws InterruptedException {
        try {
            redisClient.set("testKey", "hh");
            String testValue = (String) redisClient.get("testKey");
            System.out.println("从redis获取的key值：" + testValue);
        } catch (Exception e) {
            e.printStackTrace();
        }
        Thread.sleep(2000);
    }

    @Test
    void testSetRedis() {
        try {
            redisClient.set("testKey","哈哈");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    void testGeRedis() {
        try {
            String testValue = (String) redisClient.get("testKey");
            System.out.println("从redis获取的key值：" + testValue);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    @Test
    public void testLock() {
        String lock = "test-lock";
        log.info("加锁：" + (redisClient.setIfAbsent(lock, String.valueOf(1), 5) ? "成功" : "失败"));
        log.info("加锁：" + (redisClient.setIfAbsent(lock, String.valueOf(1), 5) ? "成功" : "失败"));
        try {
            Thread.sleep(5 * 1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        log.info("加锁：" + (redisClient.setIfAbsent(lock, String.valueOf(1), 5) ? "成功" : "失败"));
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        log.info("释放锁：" + (redisClient.delete(lock) ? "成功" : "失败"));
        log.info("加锁：" + (redisClient.setIfAbsent(lock, String.valueOf(1), 5) ? "成功" : "失败"));
    }
}
