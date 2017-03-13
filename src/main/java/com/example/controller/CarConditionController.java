package com.example.controller;

import com.example.domain.Area;
import com.example.service.IAreaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

/**
 * Created by zhuyy on 2017/3/6.
 */

@Controller
public class CarConditionController {

    @Autowired
    public IAreaService iAreaService;

    @RequestMapping("/addInit")
    public String addInit(Model model) {

        List<Area> areas = iAreaService.selectProvince();
        model.addAttribute("areas", areas);
        return "add";
    }
}
