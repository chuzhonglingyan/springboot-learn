//package com.yuntian.redis.redisson;
//
///**
// * @author guangleilei.
// * @date Created in 18:17 2019/11/19
// * @description
// */
//
//import org.redisson.api.RLock;
//import org.redisson.api.RedissonClient;
//
//import java.util.concurrent.TimeUnit;
//
//public class RedissonDistributedLocker implements DistributedLocker {
//
//    private RedissonClient redissonClient;
//
//    public RedissonDistributedLocker(RedissonClient redissonClient) {
//        this.redissonClient = redissonClient;
//    }
//
//    /**
//     * lock(), 拿不到lock就不罢休，不然线程就一直block
//     *
//     * @param lockKey
//     * @return
//     */
//    @Override
//    public RLock lock(String lockKey) {
//        RLock lock = redissonClient.getLock(lockKey);
//        lock.lock();
//        return lock;
//    }
//
//    /**
//     * leaseTime为加锁时间，单位为秒
//     *
//     * @param lockKey
//     * @param leaseTime
//     * @return
//     */
//    @Override
//    public RLock lock(String lockKey, long leaseTime) {
//        RLock lock = redissonClient.getLock(lockKey);
//        lock.lock(leaseTime, TimeUnit.SECONDS);
//        return lock;
//    }
//
//    /**
//     * timeout为加锁时间，时间单位由unit确定
//     *
//     * @param lockKey
//     * @param unit
//     * @param timeout
//     * @return
//     */
//    @Override
//    public RLock lock(String lockKey, TimeUnit unit, long timeout) {
//        RLock lock = redissonClient.getLock(lockKey);
//        lock.lock(timeout, unit);
//        return lock;
//    }
//
//    /**
//     * tryLock()，马上返回，拿到lock就返回true，不然返回false。
//     * 带时间限制的tryLock()，拿不到lock，就等一段时间，超时返回false.
//     */
//    @Override
//    public boolean tryLock(String lockKey, TimeUnit unit, long waitTime, long leaseTime) {
//        RLock lock = redissonClient.getLock(lockKey);
//        try {
//            return lock.tryLock(waitTime, leaseTime, unit);
//        } catch (InterruptedException e) {
//            return false;
//        }
//    }
//
//    @Override
//    public void unlock(String lockKey) {
//        RLock lock = redissonClient.getLock(lockKey);
//        lock.unlock();
//    }
//
//    @Override
//    public void unlock(RLock lock) {
//        lock.unlock();
//    }
//}