package com.example.mapper;

import com.example.SpringbootDemoApplication;
import com.example.domain.Country;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

/**
 * Created by Administrator on 2016/7/12.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = SpringbootDemoApplication.class)
@WebAppConfiguration
public class CountryMapperTest {
    private static final Logger logger = LoggerFactory.getLogger(CountryMapperTest.class);
    @Autowired
    private CountryMapper countryMapper;

    @Test
    public void testinsert(){
        Country country = new Country();
        country.setCountrycode("Angola");
        country.setCountryname("AO");
        int a = countryMapper.insert(country);
        logger.info("result:"+a);
    }
}
