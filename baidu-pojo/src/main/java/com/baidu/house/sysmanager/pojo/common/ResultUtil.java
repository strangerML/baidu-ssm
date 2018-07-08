package com.baidu.house.sysmanager.pojo.common;

public class ResultUtil<T> {

    //定义 返回的结果
    private  Result<T> result;

    //构造方法
    public ResultUtil(){
        result = new Result<>();
        result.setSuccess(true);
        result.setCode(200);
        result.setMessage("success");
    }

    public  Result<T> setData(T t ){

        this.result.setSuccess(true);
        this.result.setResult(t);
        this.result.setCode(200);
        return this.result;
    }

    public Result<T> setData(T t , String msg){
        this.result.setSuccess(true);
        this.result.setMessage(msg);
        this.result.setCode(200);
        this.result.setResult(t);
        return this.result;
    }

    public Result<T> setData(T t ,String msg,Integer code){
        this.result.setSuccess(true);
        this.result.setCode(code);
        this.result.setMessage(msg);
        this.result.setResult(t);
        return this.result;
    }

    public Result<T> setErrorMsg(String msg){
        this.result.setMessage(msg);
        this.result.setCode(500);
        this.result.setSuccess(false);
        return this.result;
    }

    public Result<T> setErrorMsg(Integer code,String msg){
        this.result.setSuccess(false);
        this.result.setCode(code);
        this.result.setMessage(msg);

        return this.result;

    }

}
