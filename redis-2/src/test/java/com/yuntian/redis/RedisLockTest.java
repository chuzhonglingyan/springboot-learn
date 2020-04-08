//package com.yuntian.redis;
//
//import com.yuntian.redis.lock.RedisLock;
//import lombok.extern.slf4j.Slf4j;
//import org.junit.jupiter.api.Test;
//import org.springframework.boot.test.context.SpringBootTest;
//
//import javax.annotation.Resource;
//import java.util.UUID;
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
//public class RedisLockTest {
//
//    @Resource
//    private RedisLock redisLock;
//
//
//    private int count = 0;
//
//    @Test
//    public void testRedisson() throws InterruptedException {
//        String goodStock = "stock:122300111";
//        int clientcount = 10;
//        CountDownLatch countDownLatch = new CountDownLatch(clientcount);
//        ExecutorService executorService = Executors.newFixedThreadPool(clientcount);
//        long start = System.currentTimeMillis();
//        for (int i = 0; i < clientcount; i++) {
//            executorService.execute(() -> {
//                String requestId = UUID.randomUUID().toString();
//                try {
//                    redisLock.lock(goodStock, requestId);
//                    Thread.sleep(300);
//                    count++;
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                } finally {
//                    redisLock.unLock(goodStock, requestId);
//                }
//                countDownLatch.countDown();
//            });
//        }
//        countDownLatch.await();
//        long end = System.currentTimeMillis();
//        log.info("执行线程数:{},总耗时:{},count数为:{}", clientcount, end - start, count);
//    }
//
//
//}
