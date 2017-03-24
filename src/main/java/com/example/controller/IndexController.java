package com.example.controller;

import com.example.common.Constant;
import com.example.common.MessageUtil;
import com.example.common.Sha1Util;
import com.example.common.exception.BusinessException;
import jdk.nashorn.internal.runtime.arrays.ArrayIndex;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Arrays;

/**
 * Created by zhuyy on 2017/2/28.
 */

@Controller
public class IndexController {

    @Value("${wx.token}")
    private String token;

    private static final Logger logger = LoggerFactory.getLogger(IndexController.class);

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public void index(HttpServletRequest request, HttpServletResponse response) {
        String signature = request.getParameter("signature");
        String nonce = request.getParameter("nonce");
        String timestamp = request.getParameter("timestamp");
        String echostr = request.getParameter("echostr");
        logger.info("微信请求signature:{},nonce:{},timestamp:{},echostr:{}",signature,nonce,timestamp,echostr);
        String[] arr = new String[]{token,nonce,timestamp};
        Arrays.sort(arr);
        StringBuilder sb = new StringBuilder();
        for (String s : arr) {
            sb.append(s);
        }
        String checkSignature = Sha1Util.getSha1(sb.toString());
        logger.info("加密后的signature(checkSignature):{}",checkSignature);
        if (signature.equals(checkSignature)) {
            try {
                response.getWriter().write(echostr);
                response.getWriter().flush();
                response.getWriter().close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }else {
            throw new BusinessException("微信校验未通过！", Constant.EXCEPTION_CODE);
        }
    }

    @RequestMapping(value = "/", method = RequestMethod.POST)
    public void doPost(HttpServletRequest request, HttpServletResponse response) {
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(request.getInputStream()));
            StringBuilder sb = new StringBuilder();
            String line = null;
            while ((line = br.readLine()) != null) {
                sb.append(line).append(System.getProperty("line.separator"));
            }
            String requestStr = sb.toString();
            logger.info("接受微信消息：{}",requestStr);
            String responseXML = MessageUtil.getResponseMessage(requestStr);
            logger.info("回复微信消息：{}",responseXML);
            response.getWriter().write(responseXML);
            response.getWriter().flush();
            response.getWriter().close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
