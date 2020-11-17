package com.ke.system.index.controller;

import com.ke.system.menu.entity.Menu;
import com.ke.system.menu.service.MenuService;
import com.ke.system.methods.MethodTools;
import com.ke.system.role.entity.Role;
import com.ke.system.role.service.RoleService;
import com.ke.system.unity.JsonResult;
import com.ke.system.user.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

import java.util.ArrayList;
import java.util.List;

import static org.springframework.web.bind.annotation.RequestMethod.GET;

/**
 * @Author: Yu Zheng
 * @Description
 * @Date: Create In 21:20 2020/7/7
 * @Modified BY:
 **/
@Controller
@RequestMapping
public class IndexController {

    @Autowired
    private RoleService roleService;

    @Autowired
    private MenuService menuService;

    @RequestMapping(value = "/index", method = GET)
    public ModelAndView index(HttpServletRequest request, ModelAndView modelAndView){
        User user = MethodTools.getCurrentUser();
        Role role = roleService.getRoleByUserId(user.getId());
        JsonResult<List<Menu>> jsonResult =  menuService.getMenusByRoleId(role.getId());
        List<Menu> menus = jsonResult.getT() != null? jsonResult.getT() : new ArrayList<>();
        modelAndView.addObject("menus", menus);
        modelAndView.setViewName("/index/index");
        return modelAndView;
    }

    @RequestMapping(value = "/text")
    public ModelAndView text(ModelAndView modelAndView){
        modelAndView.setViewName("/index/text");
        return modelAndView;
    }
}

