//package com.yuntian.redis;
//
//import com.yuntian.redis.redisson.RedissonDistributedLocker;
//import lombok.extern.slf4j.Slf4j;
//import org.junit.jupiter.api.Test;
//import org.springframework.boot.test.context.SpringBootTest;
//
//import javax.annotation.Resource;
//import java.util.concurrent.CountDownLatch;
//import java.util.concurrent.ExecutorService;
//import java.util.concurrent.Executors;
//
///**
// * @author guangleilei.
// * @date Created in 16:09 2019/11/13
// * @description
// */
//@Slf4j
//@SpringBootTest
//public class RedissonTest {
//
//    @Resource
//    private RedissonDistributedLocker redisLock;
//
//    private static final String LOCK_KEY = "redis_test_lock";
//
//    private int count = 0;
//
//    @Test
//    public void testRedisson() throws InterruptedException {
//        int clientcount = 1000;
//        CountDownLatch countDownLatch = new CountDownLatch(clientcount);
//
//        ExecutorService executorService = Executors.newFixedThreadPool(clientcount);
//        long start = System.currentTimeMillis();
//        for (int i = 0; i < clientcount; i++) {
//            executorService.execute(() -> {
//                try {
//                    redisLock.lock(LOCK_KEY, 30);
//                    Thread.sleep(300);
//                    count++;
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                } finally {
//                    redisLock.unlock(LOCK_KEY);
//                }
//                countDownLatch.countDown();
//            });
//        }
//        countDownLatch.await();
//        long end = System.currentTimeMillis();
//        log.info("执行线程数:{},总耗时:{},count数为:{}", clientcount, end - start, count);
//    }
//
//    @Test
//    public void testNoRedisson() throws InterruptedException {
//        int clientcount = 1000;
//        CountDownLatch countDownLatch = new CountDownLatch(clientcount);
//
//        ExecutorService executorService = Executors.newFixedThreadPool(clientcount);
//        long start = System.currentTimeMillis();
//        for (int i = 0; i < clientcount; i++) {
//            executorService.execute(() -> {
//                try {
//                    Thread.sleep(300);
//                    count++;
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }
//                countDownLatch.countDown();
//            });
//        }
//        countDownLatch.await();
//        long end = System.currentTimeMillis();
//        log.info("执行线程数:{},总耗时:{},count数为:{}", clientcount, end - start, count);
//    }
//
//}
