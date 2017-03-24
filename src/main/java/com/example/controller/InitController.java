package com.example.controller;

import com.example.service.CacheService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.stereotype.Controller;

import javax.annotation.Resource;

/**
 * Created by zhuyy on 2016/11/12.
 */
@Controller
public class InitController implements InitializingBean {

    private static final Logger LOGGER = Logger.getLogger(InitController.class);

    @Resource
    private CacheService cacheService;

    @Override
    public void afterPropertiesSet() throws Exception {
        LOGGER.info("系统开始初始化缓存");
        long begin = System.currentTimeMillis();
        cacheService.initDictionary();
        LOGGER.info("系统初始化缓存完成,耗时："+(System.currentTimeMillis() - begin)/1000 + "秒");
    }
}
