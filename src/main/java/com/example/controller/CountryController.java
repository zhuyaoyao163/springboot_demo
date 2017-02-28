package com.example.controller;

import com.example.common.vo.RspData;
import com.example.config.amqp.Send;
import com.example.domain.Country;
import com.example.service.ICountryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.concurrent.TimeUnit;

/**
 * Created by Administrator on 2016/7/13.
 */
@RestController
public class CountryController {

    @Autowired
    public ICountryService countryService;

    @Autowired
    private Send send;


    @RequestMapping(value = "/country/save")
    public RspData saveCountry(@RequestBody Country country) {
        send.sendMsg("aaaaaaaaaaaa");
        RspData rspData = new RspData();
        if(countryService.saveCountry(country) == 1){
            return RspData.success(null);
        }else {
            return RspData.error(0, "save fail");
        }

    }
}
