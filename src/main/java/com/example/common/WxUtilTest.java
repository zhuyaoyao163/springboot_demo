package com.example.common;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

/**
 * Created by zhuyy on 2017/3/22.
 */

public class WxUtilTest {

    private static final String APPID = "wxcb5d1365c034060c";
    private static final String APPSECRET = "b3a87f8c7bc841956e127b0fb2990fdc";

    private static final Logger logger = LoggerFactory.getLogger("MyApp.class");


    public static String getAccessToken() {
        String url = "https://api.weixin.qq.com/cgi-bin/token?grant_type=client_credential&appid="+APPID+"&secret="+APPSECRET;
        String access_token = getclumn(url, Constant.ACCESS_TOKEN);
        logger.info("access_token:"+access_token);
        return access_token;
    }

    public static String getclumn(String url,String clumn) {
        logger.info("调用微信接口获取{},url:{}",clumn,url);
        StringBuilder json = new StringBuilder();
        try {
            URL urlObject = new URL(url);
            URLConnection uc = urlObject.openConnection();
            BufferedReader in = new BufferedReader(new InputStreamReader(uc
                    .getInputStream(),"utf-8"));
            String inputLine = null;
            while ((inputLine = in.readLine()) != null) {
                json.append(inputLine);
            }
            in.close();
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        JSONObject object = JSON.parseObject(json.toString());
        logger.info("微信接口返回报文:{}",json.toString());
        return (String) object.get(clumn);

    }

    public static void main(String[] args) {
        getAccessToken();
    }
}
