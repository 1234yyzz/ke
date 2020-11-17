package com.ke.system.menu.controller;

import com.alibaba.fastjson.JSON;
import com.ke.system.menu.service.MenuService;
import com.ke.system.methods.MethodTools;
import com.ke.system.role.entity.Role;
import com.ke.system.role.service.RoleService;
import com.ke.system.user.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @Author: Yu Zheng
 * @Description
 * @Date: Create In 8:50 2020/8/27
 * @Modified BY:
 **/
@Controller
@RequestMapping("/menu")
public class MenuController {

    @Autowired
    private MenuService menuService;
    @Autowired
    private RoleService roleService;

    /**
     * 获取所有菜单信息
     * @return
     */
    @RequestMapping("/getAll")
    @ResponseBody
    public String getAll(){
        return JSON.toJSONString(menuService.getAllMenus());
    }

    /**
     * 根据userId获取菜单
     * @return
     */
    @RequestMapping("/getMenusByRoleId")
    @ResponseBody
    public String getMenusByUserId(){
        User user = MethodTools.getCurrentUser();
        Role role = roleService.getRoleByUserId(user.getId());
        return JSON.toJSONString(menuService.getMenusByRoleId(role.getId()));
    }
}
