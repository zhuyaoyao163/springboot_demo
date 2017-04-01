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

    private static final Logger logger = LoggerFactory.getLogger(WxUtilTest.class);


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

    public static void createMenu() {
        String accessToken = getAccessToken();
        String url = "https://api.weixin.qq.com/cgi-bin/menu/create?access_token=" + accessToken;
        String menuStr = "{\n" +
                "     \"button\":[\n" +
                "     {\t\n" +
                "          \"type\":\"click\",\n" +
                "          \"name\":\"今日歌曲\",\n" +
                "          \"key\":\"V1001_TODAY_MUSIC\"\n" +
                "      },\n" +
                "      {\n" +
                "           \"name\":\"菜单\",\n" +
                "           \"sub_button\":[\n" +
                "           {\t\n" +
                "               \"type\":\"view\",\n" +
                "               \"name\":\"录单\",\n" +
                "               \"url\":\"https://open.weixin.qq.com/connect/oauth2/authorize?appid=wxcb5d1365c034060c&redirect_uri=http://zhuyaoyao.natapp1.cc/carCondition/addInit&response_type=code&scope=snsapi_userinfo&state=123#wechat_redirect\"\n" +
                "            },\n" +
                "            {\n" +
                "               \"type\":\"click\",\n" +
                "               \"name\":\"赞一下我们\",\n" +
                "               \"key\":\"V1001_GOOD\"\n" +
                "            }]\n" +
                "       }]\n" +
                " }";
        String responseContent = HttpClientUtil.sendHttpPostJson(url, menuStr);
        logger.info(responseContent);
    }
    public static void main(String[] args) {
        createMenu();
    }
}
