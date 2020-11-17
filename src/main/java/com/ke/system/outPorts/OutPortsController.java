package com.ke.system.outPorts;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @Author: Yu Zheng
 * @Description
 * @Date: Create In 16:19 2020/10/8
 * @Modified BY:
 **/
@RequestMapping("/outPorts")
@Controller
public class OutPortsController {

    @RequestMapping("/firstPort")
    @ResponseBody
    public String firstPort(String name, String password){
        return "用户名为：" + name + " /n 密码为：" + password;
    }
}
