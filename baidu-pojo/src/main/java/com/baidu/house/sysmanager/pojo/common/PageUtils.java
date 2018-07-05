package com.baidu.house.sysmanager.pojo.common;

import com.github.pagehelper.PageInfo;

import java.util.HashMap;
import java.util.Map;

public class PageUtils<T> {

    private Integer pageNum;
    private Integer pageSize;

    private PageInfo<T> pageInfo;

    private HashMap<String,Object> like = new HashMap<>();

    public HashMap<String, Object> getLike() {
        return like;
    }

    public void setLike(HashMap<String, Object> like) {
        this.like = like;
    }

    public PageInfo<T> getPageInfo() {
        return pageInfo;
    }

    public void setPageInfo(PageInfo<T> pageInfo) {
        this.pageInfo = pageInfo;
    }

    public Integer getPageNum() {
        return pageNum;
    }

    public void setPageNum(Integer pageNum) {
        this.pageNum = pageNum;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

}
