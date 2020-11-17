package com.ke.system.user.mapper;

import com.ke.system.user.entity.User;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @Author: Yu Zheng
 * @Description
 * @Date: Create In 9:51 2020/8/14
 * @Modified BY:
 **/
@Repository
public interface UserMapper {

    User Sel(int id);

    List<User> findPage(@Param("userName") String userName, @Param("startSite") Integer startSite,
                        @Param("endSite") Integer endSite);

    int getAllCount(@Param("userName") String name);

    User getById(@Param("id") Integer id);

    User getByName(@Param("name") String name);

    User getByPhone(@Param("phone") String phone);

    void update(User user);

    void save(User user);

    void delete(User user);
}