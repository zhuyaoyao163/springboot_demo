package com.example.config;

import com.example.common.Constant;
import com.example.common.WxUtil;
import com.example.service.CacheService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

/**
 * Created by zhuyy on 2017/3/24.
 */

@Component
public class Jobs {

    public final static long ONE_MINUTE =  60 * 1000;

    private static final Logger logger = LoggerFactory.getLogger(Jobs.class);
    @Resource
    private CacheService cacheService;

    @Scheduled(cron="0 0 0/2 * * ?")
    public void refreshAccesstoken() {
        logger.info("定时任务执行开始，获取access_token");
        String appid = cacheService.getCache(Constant.APP_ID) == null ? null : cacheService.getCache(Constant.APP_ID).toString();
        String secret = cacheService.getCache(Constant.APP_SECRET) == null ? null : cacheService.getCache(Constant.APP_SECRET).toString();
        String access_token = WxUtil.getAccessToken(appid, secret);
        logger.info("定时任务执行完成，获取access_token：{}",access_token);
        cacheService.pushCache(Constant.ACCESS_TOKEN, access_token);
    }
}
