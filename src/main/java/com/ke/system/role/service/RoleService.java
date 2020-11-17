package com.ke.system.role.service;

import com.ke.system.role.entity.Role;
import com.ke.system.role.mapper.RoleMapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Author: Yu Zheng
 * @Description
 * @Date: Create In 16:34 2020/9/2
 * @Modified BY:
 **/
@Service
public class RoleService {

    @Autowired
    private RoleMapper roleMapper;

    /**
     * 根据userId获取角色信息
     * @param userId
     * @return
     */
    public Role getRoleByUserId(Integer userId){
        return roleMapper.getRoleByUserId(userId);
    }
}
