package com.ke.system.login.controller;

import com.alibaba.fastjson.JSON;
import com.ke.system.unity.JsonResult;
import com.ke.system.user.entity.User;
import com.ke.system.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

import java.net.URLDecoder;
import java.util.Date;

import static org.springframework.web.bind.annotation.RequestMethod.GET;

/**
 * @Author: Yu Zheng
 * @Description
 * @Date: Create In 20:57 2020/7/8
 * @Modified BY:
 **/
@Controller
public class LogController {

    @Autowired
    private UserService userService;

    /**
     * 默认登录也页面
     * @return
     */
    @RequestMapping(value = "/login", method = GET)
    public ModelAndView login(HttpServletRequest request, ModelAndView modelAndView){
        modelAndView.addObject("ctx", request.getContextPath());
        modelAndView.setViewName("login/login");
        return modelAndView;
    }

    /**
     * 用户验证登录
     * @param params
     * @return
     */
    @RequestMapping("/login/checkUser")
    @ResponseBody
    public String checkUser(HttpServletRequest request, @RequestBody String params) throws Exception{
        JsonResult<User> result = userService.checkUser(URLDecoder.decode(params, "UTF-8"));
        //将用户信息放进session
        if(result.getSuccess() == true){
            User user = result.getT();
            request.getSession().setAttribute("_session_user", user);
            request.getSession().setAttribute("_session_timestamp", System.currentTimeMillis());
        }
        return JSON.toJSONString(result);
    }

}

