package com.example.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.example.common.Constant;
import com.example.common.enums.DefectEnum;
import com.example.common.enums.ImportanceEnum;
import com.example.common.enums.ProcessEnum;
import com.example.common.exception.BusinessException;
import com.example.common.vo.RspData;
import com.example.domain.Area;
import com.example.domain.CheckOrder;
import com.example.domain.Department;
import com.example.domain.User;
import com.example.service.*;
import com.example.vo.DepartmentVo;
import com.example.vo.JssdkConfigVo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.*;

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

    @Autowired
    private CheckOrderService checkOrderService;

    @Autowired
    private CacheService cacheService;

    private static final Logger logger = LoggerFactory.getLogger(CarConditionController.class);

    @RequestMapping("/addInit")
    public String addInit(Model model,HttpServletRequest request) {

        List<Department> departments = departmentService.findAllDepartment();
        String code = request.getParameter("code");
        logger.info("code:{}",code);
        if (departments != null && departments.size() > 0) {
            Collections.sort(departments, new Comparator<Department>() {
                @Override
                public int compare(Department o1, Department o2) {
                    return o1.getId() - o2.getId();
                }
            });
            List<User> users = userService.findUserByDepartmentId(departments.get(0).getId());
            model.addAttribute("defaultDepartment", departments.get(0));
            model.addAttribute("defaultUsers", users);
            for (User user : users) {
                if (user.getLeaderFlag().equals("1")) {
                    model.addAttribute("defaultLeader", user);
                }
            }
            model.addAttribute("departments", departments);
        }
        JssdkConfigVo jssdkConfigVo = null;
        try {
            jssdkConfigVo = checkOrderService.initJssdk(request.getRequestURL().toString()+"?code="+code+"&state=123");
        } catch (Exception e) {
            throw new BusinessException("初始化jssdk异常！", Constant.EXCEPTION_CODE);
        }
        model.addAttribute("IMPORTANCE_LIST", ImportanceEnum.values());
        model.addAttribute("PROCESS_LIST", ProcessEnum.values());
        model.addAttribute("DEFECT_LIST", DefectEnum.values());
        model.addAttribute("jssdk", jssdkConfigVo);
        return "add";
    }

    @RequestMapping("/initPage")
    public void initPage(HttpServletRequest request, HttpServletResponse response) {

        RspData rspData = new RspData();
        String id = request.getParameter("id");
        DepartmentVo departmentVo = null;

        try {
            List<Department> departments = departmentService.findAllDepartment();

            if (departments != null && departments.size() > 0) {
                for (Department department : departments) {
                    if(department.getId() == Integer.valueOf(id)){
                        departmentVo = new DepartmentVo();
                        List<User> users = userService.findUserByDepartmentId(department.getId());
                        if (users != null && users.size() > 0) {
                            departmentVo.setUsers(users);
                            for (User user : users) {
                                if (department.getDepartmentLeaderId().equals(user.getId().toString())) {
                                    departmentVo.setDepartmentLeaderName(user.getUserName());
                                }
                            }
                        }
                        departmentVo.setDepartment(department);
                    }
                }
            }
        } catch (Exception e) {
            rspData.setMsg("系统异常");
            rspData.setCode(Constant.EXCEPTION_CODE);
        }
        rspData.setCode(Constant.SUCCESS_CODE);
        rspData.setMsg("成功");
        rspData.setData(departmentVo);
        try {
            response.getWriter().write(JSON.toJSONString(rspData));
            response.getWriter().flush();
            response.getWriter().close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @RequestMapping("/downLoadImage")
    public void downLoadImage(HttpServletRequest request, HttpServletResponse response) {
        String serverId = request.getParameter("serverId");
        logger.info("downLoadImage,请求参数：{}",serverId);
        String requestUrl = "http://file.api.weixin.qq.com/cgi-bin/media/get?access_token=ACCESS_TOKEN&media_id=MEDIA_ID";
        String access_token = (String) cacheService.getCache(Constant.ACCESS_TOKEN);
        requestUrl = requestUrl.replace("ACCESS_TOKEN", access_token);
        requestUrl.replace("MEDIA_ID", serverId);
        logger.info("requestUrl:{}", requestUrl);
        try {
            URL url = new URL(requestUrl);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setDoInput(true);
            conn.setRequestMethod("GET");
            conn.setConnectTimeout(30000);
            conn.setReadTimeout(30000);
            //根据上传时间，生成不同的文件夹
            StringBuilder filepath = new StringBuilder();
            filepath.append("E:\\test\\images\\" + "download"+File.separator+"images" + File.separator);
            logger.info("filepath1:{}", filepath.toString());
            File file =new File(filepath.toString());
            if  (!file .exists()  && !file .isDirectory()) {
                logger.info("//不存在");
                file .mkdir();
            } else {
                logger.info("//目录存在");
            }

            // 根据内容类型获取扩展名
            String fileExt = ".jpg";
            // 将mediaId作为文件名
            filepath.append(serverId+ fileExt);
            logger.info("filepath2:{}", filepath.toString());

            BufferedInputStream bis = new BufferedInputStream(conn.getInputStream());
            FileOutputStream fos = new FileOutputStream(new File(filepath.toString()));
            byte[] buf = new byte[10000];
            int size = 0;
            while ((size = bis.read(buf)) != -1)
                fos.write(buf, 0, size);
            fos.flush();
            fos.close();
            bis.close();
            conn.disconnect();

        } catch (IOException e) {
            e.printStackTrace();
        }

        RspData rspData = new RspData();
        rspData.setCode(Constant.SUCCESS_CODE);
        rspData.setMsg("成功");
        rspData.setData(null);
        try {
            response.getWriter().write(JSON.toJSONString(rspData));
            response.getWriter().flush();
            response.getWriter().close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @RequestMapping("/addCheckOrder")
    public String addCheckOrder(HttpServletRequest request, HttpServletResponse response, CheckOrder checkOrder) {
        logger.info("addCheckOrder  request:{}", JSON.toJSONString(checkOrder));
        int res = checkOrderService.insertCheckOrder(checkOrder);
        if (res == 1) {
            return "success";
        }else {
            throw new BusinessException("系统异常！", Constant.EXCEPTION_CODE);
        }

    }
}
