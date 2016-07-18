package com.example.common.interceptor;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import static org.hibernate.jpa.internal.QueryImpl.LOG;

/**
 * Created by Administrator on 2016/7/15.
 */
public class EfficiencyInterceptor implements HandlerInterceptor {
    private static final Logger LOGGER = LoggerFactory.getLogger(EfficiencyInterceptor.class);
    private long time = System.currentTimeMillis();
    @Override
    public boolean preHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o) throws Exception {
        time = System.currentTimeMillis();
        LOGGER.info(httpServletRequest.getRequestURI() + ":" +"preHandle");
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, ModelAndView modelAndView) throws Exception {
        long interval = System.currentTimeMillis() - time;
        LOGGER.info(httpServletRequest.getRequestURI()+":"+"afterCompletion,time used:"+interval);
    }

    @Override
    public void afterCompletion(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) throws Exception {
        LOGGER.info(httpServletRequest.getRequestURI()+":"+"postHandle");
    }
}
