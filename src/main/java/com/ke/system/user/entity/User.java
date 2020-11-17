package com.ke.system.user.entity;

import lombok.Data;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @Author: Yu Zheng
 * @Description
 * @Date: Create In 9:49 2020/8/14
 * @Modified BY:
 **/
@Data
public class User {
    private Integer id;
    private String name;
    private Integer roleId;
    private String roleName;
    private String password;
    private Long phone;
    private String createBy;
    private Date createDate;
    private String createDateString;
    private final SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", userName='" + name + '\'' +
                ", passWord='" + password + '\'' +
                '}';
    }

    public String getCreateDateString() {
        createDateString = createDate != null? format.format(createDate) : new String();
        return createDateString;
    }


}
