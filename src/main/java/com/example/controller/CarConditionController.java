package com.example.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by zhuyy on 2017/3/6.
 */

@Controller
public class CarConditionController {

    @RequestMapping("/addInit")
    public String addInit(Model model) {

        return "add";
    }
}
