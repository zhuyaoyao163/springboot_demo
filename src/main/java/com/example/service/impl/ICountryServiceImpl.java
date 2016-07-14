package com.example.service.impl;

import com.example.config.DataSource;
import com.example.config.DynamicDataSource;
import com.example.domain.Country;
import com.example.mapper.CountryMapper;
import com.example.service.ICountryService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * Created by Administrator on 2016/7/13.
 */
@Service("countryService")
public class ICountryServiceImpl implements ICountryService {

    @Resource
    private CountryMapper countryMapper;

    @Override
    @DataSource("slave1")
    public int saveCountry(Country country) {
        return countryMapper.insert(country);
    }
}
