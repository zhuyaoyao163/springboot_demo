package com.example.controller;

import com.alibaba.fastjson.JSON;
import com.example.SpringbootDemoApplication;
import com.example.domain.Country;
import org.hamcrest.Matchers;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.boot.test.TestRestTemplate;
import org.springframework.boot.test.WebIntegrationTest;
import org.springframework.http.HttpEntity;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

import static org.junit.Assert.assertNotNull;

/**
 * Created by Administrator on 2016/7/15.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = SpringbootDemoApplication.class)
@WebIntegrationTest("server.port:8888")
public class ControllerTest {

    private static final Logger LOGGER = LoggerFactory.getLogger(ControllerTest.class);
    private RestTemplate template = new TestRestTemplate();
    @Value("${local.server.port}")// 注入端口号
    private int port;

    @Test
    public void CountryControllerTest() {
        String url = "http://localhost:"+port+"/country/save";
        MultiValueMap<String, Object> headers = new LinkedMultiValueMap<String, Object>();
        headers.add("Accept", "application/json");
        headers.add("Content-Type", "application/json");

        Country country = new Country();
        country.setCountryname("dasdsa");
        country.setCountrycode("3242");
        String requestBody = JSON.toJSONString(country);
        HttpEntity request = new HttpEntity(requestBody, headers);
        String result = template.postForObject(url, request, String.class);
        LOGGER.info(result);
        assertNotNull(result);
    }
}
