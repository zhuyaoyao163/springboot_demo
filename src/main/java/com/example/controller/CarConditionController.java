package com.example.controller;

import com.example.common.enums.DefectEnum;
import com.example.common.enums.ImportanceEnum;
import com.example.common.enums.ProcessEnum;
import com.example.domain.Area;
import com.example.service.DepartmentService;
import com.example.service.IAreaService;
import com.example.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

/**
 * Created by zhuyy on 2017/3/6.
 */

@Controller
@RequestMapping("/carCondition")
public class CarConditionController {

    @Autowired
    public IAreaService iAreaService;

    @Autowired
    private UserService userService;

    @Autowired
    private DepartmentService departmentService;

    @RequestMapping("/addInit")
    public String addInit(Model model) {


        List<Area> areas = iAreaService.selectProvince();
        model.addAttribute("areas", areas);
        model.addAttribute("IMPORTANCE_LIST", ImportanceEnum.values());
        model.addAttribute("PROCESS_LIST", ProcessEnum.values());
        model.addAttribute("DEFECT_LIST", DefectEnum.values());
        return "add";
    }
}
