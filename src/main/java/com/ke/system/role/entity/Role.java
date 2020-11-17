package com.ke.system.role.entity;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * @Author: Yu Zheng
 * @Description
 * @Date: Create In 16:36 2020/9/2
 * @Modified BY:
 **/
@Data
public class Role implements Serializable {

    private Integer id;

    private String name;

    private Integer parentId;

    private Date createTime;

    private Integer createBy;

    private Date updateTime;

    private Integer updateBy;
}
