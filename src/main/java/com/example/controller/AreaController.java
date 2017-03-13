package com.example.controller;

import com.example.common.ExcelView;
import com.example.domain.Area;
import com.example.service.IAreaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.*;

/**
 * Created by zhuyy on 2017/3/9.
 */
@Controller
public class AreaController {

    @Autowired
    public IAreaService iAreaService;

    private static final LinkedHashMap<String, String> DOWNLOAD_TITLE = new LinkedHashMap<String, String>();

    static {
        DOWNLOAD_TITLE.put("AREA_CODE", "地区代码");
        DOWNLOAD_TITLE.put("AREA_NAME", "地区名称");
        DOWNLOAD_TITLE.put("SHORT_NAME", "地区简称");
        DOWNLOAD_TITLE.put("AREA_LEVEL", "地区级别");
        DOWNLOAD_TITLE.put("PARENT_CODE", "父级代码");
        DOWNLOAD_TITLE.put("HOT_FLAG", "热点地区标志");
        DOWNLOAD_TITLE.put("VALID_STATUS", "是否有效");
        DOWNLOAD_TITLE.put("LICENSE_PREFIX", "车牌前缀");
        DOWNLOAD_TITLE.put("PROVINCE_FLAG", "省级标志");
        DOWNLOAD_TITLE.put("OPERATOR_CODE", "操作代码");
        DOWNLOAD_TITLE.put("OPERATOR_NAME", "操作员");
        DOWNLOAD_TITLE.put("OPERATOR_DATE", "操作日期");
        DOWNLOAD_TITLE.put("FEE_CHANGE_FLAG", "费改标志");
    }
    @RequestMapping("/findProvince")
    public void findProvince(Model model) {
        List<Area> areas = iAreaService.selectProvince();
        model.addAttribute("areas", areas);
    }

    @RequestMapping("/exportAreas")
    public ModelAndView exportAreas() {
        List<Area> areas = iAreaService.selectAllAreas();
        ExcelView viewExcel = new ExcelView("地区数据.xls", "地区数据", DOWNLOAD_TITLE, new List[0]);
        Vector<List<Area>> vector = new Vector<List<Area>>();
        vector.add(areas);
        List<Map<String, Object>>[] contents = new List[vector.size()];
        Iterator<List<Area>> iterator = vector.iterator();
        int n = 0;
        while (iterator.hasNext()) {
            List<Area> temp = iterator.next();
            List<Map<String, Object>> obj = new ArrayList<Map<String,Object>>();
            for (Area area : temp) {
                Map<String, Object> map = new HashMap<String, Object>();
                map.put("AREA_CODE",area.getAreaCode());
                map.put("AREA_NAME",area.getAreaName());
                map.put("SHORT_NAME",area.getShortName());
                map.put("AREA_LEVEL",area.getAreaLevel());
                map.put("PARENT_CODE",area.getParentCode());
                map.put("HOT_FLAG",area.getHotFlag());
                map.put("VALID_STATUS",area.getValidStatus());
                map.put("LICENSE_PREFIX",area.getLicensePrefix());
                map.put("PROVINCE_FLAG",area.getProvinceFlag());
                map.put("OPERATOR_CODE",area.getOperatorCode());
                map.put("OPERATOR_NAME",area.getOperatorName());
                map.put("OPERATOR_DATE",area.getOperatorDate());
                map.put("FEE_CHANGE_FLAG",area.getFeeChangeFlag());
                obj.add(map);
            }
            contents[n] = obj;
            n ++;
        }
        viewExcel = new ExcelView("地区数据.xls", "地区数据", DOWNLOAD_TITLE, contents);
        return new ModelAndView(viewExcel);
    }
}
