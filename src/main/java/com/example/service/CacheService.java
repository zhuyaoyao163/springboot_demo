package com.example.service;

/**
 * Created by zhuyy on 2016/11/12.
 */
public interface CacheService {
    public void initDictionary();

    void pushCache(Object o1, Object o2);

    Object getCache(Object o1);

    public void clearCache();

    public void evictCache(Object o1);

}
