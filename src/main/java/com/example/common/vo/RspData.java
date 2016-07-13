package com.example.common.vo;



/**
 * Created by duming on 2016/4/12.
 */
public class RspData {

    private static final int SUCCESS_CODE = 1;
    private int code;
    private String msg;
    private Object data;

    public RspData() {
    }

    public RspData(int code, String msg, Object data) {
        this.code = code;
        this.msg = msg;
        this.data = data;
    }

    public static RspData success(Object data) {
        return new RspData(SUCCESS_CODE, null, data);
    }

    public static RspData error(int code, String msg) {
        return new RspData(code, msg, null);
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }


    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }
}
