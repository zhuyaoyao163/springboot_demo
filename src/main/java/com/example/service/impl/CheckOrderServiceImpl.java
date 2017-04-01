package com.example.service.impl;

import com.alibaba.fastjson.JSON;
import com.example.common.Constant;
import com.example.common.Sha1Util;
import com.example.domain.CheckOrder;
import com.example.mapper.CheckOrderMapper;
import com.example.service.CacheService;
import com.example.service.CheckOrderService;
import com.example.vo.JssdkConfigVo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;
import java.util.SortedMap;
import java.util.TreeMap;

/**
 * Created by zhuyy on 2017/3/28.
 */
@Service("checkOrderService")
public class CheckOrderServiceImpl implements CheckOrderService{

    @Resource
    private CacheService cacheService;

    @Resource
    private CheckOrderMapper checkOrderMapper;

    private Logger logger = LoggerFactory.getLogger(CheckOrderServiceImpl.class);

    public JssdkConfigVo initJssdk(String requestUrl) throws Exception {
        logger.info("初始化jssdk,入参:{}",requestUrl);
        String appId = (String) cacheService.getCache(Constant.APP_ID);
        String appSecret = (String) cacheService.getCache(Constant.APP_SECRET);
        String access_token = (String) cacheService.getCache(Constant.ACCESS_TOKEN);
        String jsapi_ticket = (String) cacheService.getCache(Constant.JSAPI_TICKET);
        String noncestr = Sha1Util.getNonceStr(); //随机串
        String timestamp = Sha1Util.getTimeStamp(); //时间戳
        SortedMap<String, String> signParams = new TreeMap<String, String>();
        signParams.put("jsapi_ticket", jsapi_ticket); //jsapi_ticket
        signParams.put("noncestr", noncestr); //随机串
        signParams.put("timestamp", timestamp); //时间戳
        signParams.put("url",  requestUrl);//允许使用的页面url
        String signature = Sha1Util.createSHA1Sign(signParams);
        JssdkConfigVo jssdkConfigVo = new JssdkConfigVo();
        jssdkConfigVo.setAppId(appId);
        jssdkConfigVo.setNonceStr(noncestr);
        jssdkConfigVo.setSignature(signature);
        jssdkConfigVo.setTimestamp(timestamp);
        logger.info("初始化jssdk,返回:{}", JSON.toJSONString(jssdkConfigVo));
        return jssdkConfigVo;
    }

    @Override
    public int insertCheckOrder(CheckOrder checkOrder) {
        checkOrder.setFlag(Constant.VALID_FLAG);
        checkOrder.setCreateTime(new Date());
        return checkOrderMapper.insert(checkOrder);
    }
}
