package com.ke.system.menu.entity;

import com.alibaba.fastjson.annotation.JSONField;
import lombok.Data;
import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @Author: Yu Zheng
 * @Description
 * @Date: Create In 8:56 2020/8/27
 * @Modified BY:
 **/
@Data
public class Menu {

    //菜单id
    @JSONField(name = "id")
    private Integer id;

    //父菜单id
    @JSONField(name = "parentId")
    private Integer parentId;

    //菜单名称
    @JSONField(name = "name")
    private String name;

    //菜单图标
    @JSONField(name = "tag")
    private String flag;

    //菜单级别
    @JSONField(name = "level")
    private Integer level;

    //菜单地址
    @JSONField(name = "address")
    private String address;

    private Integer createBy;

    private Date createTime;

    private Integer updateBy;

    private Date updateTime;

    @JSONField(name = "childs")
    private List<Menu> childs;

    /**
     * 添加子菜单
     * @param m
     */
    public void addChild(Menu m){
        childs = CollectionUtils.isEmpty(childs)? new ArrayList<>() : childs;
        childs.add(m);
    }
}
