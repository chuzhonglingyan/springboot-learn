//package com.yuntian.redis.redisson;
//
//import org.redisson.api.RLock;
//
//import java.util.concurrent.TimeUnit;
//
///**
// * @author guangleilei.
// * @date Created in 18:17 2019/11/19
// * @description
// */
//public interface DistributedLocker {
//
//    RLock lock(String lockKey);
//
//    RLock lock(String lockKey, long timeout);
//
//    RLock lock(String lockKey, TimeUnit unit, long timeout);
//
//    boolean tryLock(String lockKey, TimeUnit unit, long waitTime, long leaseTime);
//
//    void unlock(String lockKey);
//
//    void unlock(RLock lock);
//
//}
