package com.ke.system.menu.mapper;

import com.ke.system.menu.entity.Menu;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @Author: Yu Zheng
 * @Description
 * @Date: Create In 8:52 2020/8/27
 * @Modified BY:
 **/
@Repository
public interface MenuMapper {

    List<Menu> getAllMenu();

    List<Menu> getMenusByRoleId(@Param("roleId") Integer roleId);

}
