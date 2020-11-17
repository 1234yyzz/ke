package com.ke.system.role.controller;

import com.ke.system.role.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @Author: Yu Zheng
 * @Description
 * @Date: Create In 22:11 2020/8/24
 * @Modified BY:
 **/
@Controller
@RequestMapping("/role")
public class RoleController {

    @Autowired
    private RoleService roleService;
}
