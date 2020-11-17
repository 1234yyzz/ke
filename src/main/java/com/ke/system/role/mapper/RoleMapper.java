package com.ke.system.role.mapper;

import com.ke.system.role.entity.Role;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

/**
 * @Author: Yu Zheng
 * @Description
 * @Date: Create In 16:34 2020/9/2
 * @Modified BY:
 **/
@Repository
public interface RoleMapper {

    Role getRoleByUserId(@Param("userId") Integer userId);
}
