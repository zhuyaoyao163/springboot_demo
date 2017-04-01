package com.example.service;

import com.example.domain.CheckOrder;
import com.example.vo.JssdkConfigVo;

/**
 * Created by zhuyy on 2017/3/28.
 */
public interface CheckOrderService {

    public JssdkConfigVo initJssdk(String requestUrl) throws Exception;

    public int insertCheckOrder(CheckOrder checkOrder);
}
