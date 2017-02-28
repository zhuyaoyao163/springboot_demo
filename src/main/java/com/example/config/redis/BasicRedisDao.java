//package com.example.config.redis;
//
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.beans.factory.annotation.Qualifier;
//import org.springframework.data.redis.core.BoundValueOperations;
//import org.springframework.stereotype.Repository;
//
//import java.util.Collection;
//import java.util.concurrent.TimeUnit;
//import java.util.function.Supplier;
//
///**
// * Created by jiajiancheng on 2016/3/19.
// */
//@Repository
//public class BasicRedisDao {
//
//    private static final Logger LOGGER = LoggerFactory.getLogger(BasicRedisDao.class);
//
//    @Autowired
//    @Qualifier("redisTemplateProxy")
//    private RedisTemplateProxy redisTemplate;
//
//    public <T> T getByKey(String key, Supplier<T> supplier) {
//        return insertIfNotExist(key, getByKey(key), supplier);
//    }
//
//    public void deleteByKey(String key) {
//        long time = System.currentTimeMillis();
//        redisTemplate.delete(key);
//        LOGGER.debug("delete cache from redis, key:" + key + ", cost:" + (System.currentTimeMillis() - time));
//    }
//
//    @SuppressWarnings("unchecked")
//    private <T> T getByKey(String key) {
//        long time = System.currentTimeMillis();
//        BoundValueOperations<String, Object> boundValueOps = redisTemplate.boundValueOps(key);
//        T t = (T) boundValueOps.get();
//        int size = isEmpty(t) ? 0 : 1;
//        LOGGER.debug("get cache from redis, key:" + key + ", size:" + size + ", cost:" + (System.currentTimeMillis() - time));
//        return t;
//    }
//
//    @SuppressWarnings("unchecked")
//    private <T> T insertIfNotExist(String key, T t, Supplier<T> supplier) {
//        if (t == null) {
//            long time = System.currentTimeMillis();
//            t = supplier.get();
//            if(isEmpty(t)) {
//                return t;
//            }
//            BoundValueOperations<String, Object> boundValueOpt = redisTemplate.boundValueOps(key);
//            boundValueOpt.set(t);
//            boundValueOpt.expire(1, TimeUnit.DAYS);
//            LOGGER.debug("entrance cache to redis, key:" + key + ", cost:" + (System.currentTimeMillis() - time));
//        }
//        return t;
//    }
//
//    private <T> boolean isEmpty(T t) {
//        return t == null || (t instanceof Collection && ((Collection)t).size() == 0);
//    }
//
//}
