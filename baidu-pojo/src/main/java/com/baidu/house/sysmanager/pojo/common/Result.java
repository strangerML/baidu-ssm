package com.baidu.house.sysmanager.pojo.common;

import java.io.Serializable;

public class Result<T> implements Serializable {

    /**
     * 成功的标志
     */
    private boolean success;

    /**
     * 返回的消息
     */
    private String message;

    /**
     * 返回的代码
     */
    private Integer code;

    private long timestamp = System.currentTimeMillis();

    /**
     * 返回的结果
     */

    private T result;

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public long getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(long timestamp) {
        this.timestamp = timestamp;
    }

    public T getResult() {
        return result;
    }

    public void setResult(T result) {
        this.result = result;
    }
}
