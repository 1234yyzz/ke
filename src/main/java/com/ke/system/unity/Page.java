package com.ke.system.unity;


import lombok.Data;

import java.util.List;

/**
 * @Author: Yu Zheng
 * @Description
 * @Date: Create In 15:26 2020/7/29
 * @Modified BY:
 **/
@Data
public class Page<T> {

    public Page(){}

    public Page(int pageNo, int pageSize){
        this.pageNo = pageNo;
        this.pageSize = pageSize;
    }

    //页面大小
    private int pageSize;

    //当前页码
    private int pageNo;

    //页数
    private int pageNum;

    //开始位置
    private int startSite;

    //终止位置
    private int endSite;

    private List<T> lists;
}
