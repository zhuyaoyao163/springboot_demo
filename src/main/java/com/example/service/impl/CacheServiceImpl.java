package com.example.service.impl;


import com.example.common.Constant;
import com.example.common.WxUtil;
import com.example.service.CacheService;
import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cache.Cache;
import org.springframework.cache.ehcache.EhCacheCacheManager;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;


/**
 * Created by zhuyy on 2016/11/12.
 */
@Service("cacheService")
public class CacheServiceImpl implements CacheService {

    private static final Logger LOGGER = Logger.getLogger(CacheServiceImpl.class);

    @Resource
    private EhCacheCacheManager cacheManager;

    @Value("${wx.appid}")
    private String appid;

    @Value("${wx.secret}")
    private String secret;

    @Override
    public void initDictionary() {
        LOGGER.info("初始化缓存......");
        String access_token = WxUtil.getAccessToken(appid,secret);
        if (!StringUtils.isEmpty(access_token)){
            pushCache(Constant.ACCESS_TOKEN,access_token);
        }else {
            LOGGER.info("初始化缓存中获取access_token失败！");
        }
    }

    /**
     * 向缓存中添加元素
     * @param o1 key
     * @param o2 value
     */
    public void pushCache(Object o1, Object o2) {
        LOGGER.info("pushCache, key值:" + o1.toString());
        Cache cache = cacheManager.getCache(Constant.CACHE_NAME);
        cache.put(o1, o2);
    }

    /**
     * 从缓存中取元素
     * @param o1 key
     * @return
     */
    public Object getCache(Object o1) {
        LOGGER.info("getCache, key值:" + o1.toString());
        Cache cache = cacheManager.getCache(Constant.CACHE_NAME);
        return cache.get(o1.toString()) == null ? null : cache.get(o1.toString()).get();
    }

    /**
     * 清除缓存
     */
    public void clearCache() {
        LOGGER.info("clearCache......");
        Cache cache = cacheManager.getCache(Constant.CACHE_NAME);
        cache.clear();
    }

    /**
     * 通过key值删除缓存
     * @param o1
     */
    public void evictCache(Object o1) {
        LOGGER.info("evictCache......");
        Cache cache = cacheManager.getCache(Constant.CACHE_NAME);
        cache.evict(o1.toString());
    }
}
