package com.example.controller;

import com.example.common.vo.RspData;
import com.example.domain.Country;
import com.example.service.ICountryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by Administrator on 2016/7/13.
 */
@RestController
public class CountryController {

    @Autowired
    public ICountryService countryService;

    @RequestMapping(value = "/country/save", method = RequestMethod.POST)
    public RspData saveCountry(Country country) {
        RspData rspData = new RspData();
        if(countryService.saveCountry(country) == 1){
            return RspData.success(null);
        }else {
            return RspData.error(0, "save fail");
        }

    }
}
