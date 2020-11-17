package com.ke.system.user.controller;

import com.alibaba.fastjson.JSON;
import com.ke.system.methods.MethodTools;
import com.ke.system.unity.JsonResult;
import com.ke.system.unity.Page;
import com.ke.system.user.entity.User;
import com.ke.system.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.net.URLDecoder;
import java.util.Date;

/**
 * @Author: Yu Zheng
 * @Description
 * @Date: Create In 9:49 2020/8/14
 * @Modified BY:
 **/
@RestController
@RequestMapping("/user")
public class UserController {

    //用户页面地址
    public final static String USERLISTPAGE = "/user/userList";

    @Autowired
    private UserService userService;

    @RequestMapping("getUser/{id}")
    public String GetUser(@PathVariable int id){
        return userService.Sel(id).toString();
    }

    /**
     * 用户页面
     * @param model
     * @param userName
     * @param pageSize
     * @param pageNo
     * @return
     */
    @RequestMapping("/list")
    public ModelAndView list(ModelAndView model, String userName, int pageSize, int pageNo){
        Page<User> page = userService.findPage(userName, pageNo, pageSize);
        model.addObject("page", page);
        model.addObject("userName", userName);
        model.setViewName("user/list");
        return model;
    }

    @RequestMapping("/saveUser")
    @ResponseBody
    public String saveUser(String name, String password, String phone){
        User user = new User();
        user.setName(name);
        user.setCreateDate(new Date());
        user.setPhone(Long.valueOf(phone));
        user.setPassword(MethodTools.getSaltMD5(password));
        user.setCreateBy("1");
        userService.save(user);
        return "新增用户成功";
    }


}