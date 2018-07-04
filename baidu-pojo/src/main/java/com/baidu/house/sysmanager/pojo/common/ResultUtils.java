package com.baidu.house.sysmanager.pojo.common;

public class ResultUtils {

    private Integer status;
    private String msg;

    private Object data;

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
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

    public static ResultUtils build(Integer status, String msg, Object data) {
        return new ResultUtils(status, msg, data);
    }

    public static ResultUtils ok() {
        return new ResultUtils(null);
    }

    public static ResultUtils build(Integer status, String msg) {
        return new ResultUtils(status, msg, null);
    }

    public ResultUtils(Integer status, String msg, Object data) {
        this.status = status;
        this.msg = msg;
        this.data = data;
    }

    public ResultUtils(Object data) {
        this.status = 200;
        this.msg = "OK";
        this.data = data;
    }









}
