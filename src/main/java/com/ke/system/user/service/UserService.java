package com.ke.system.user.service;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.ke.system.methods.MethodTools;
import com.ke.system.unity.JsonResult;
import com.ke.system.unity.Page;
import com.ke.system.unity.StaticParam;
import com.ke.system.user.entity.User;
import com.ke.system.user.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

/**
 * @Author: Yu Zheng
 * @Description
 * @Date: Create In 9:50 2020/8/14
 * @Modified BY:
 **/
@Service
public class UserService {

    @Autowired
    UserMapper userMapper;

    public User Sel(int id){
        return userMapper.Sel(id);
    }

    /**
     * 页面查询
     * @param userName
     * @param pageNo
     * @param pageSize
     * @return
     */
    public Page<User> findPage(String userName, int pageNo, int pageSize){
        Page<User> page = MethodTools.assemblePage(new Page<User>(pageNo, pageSize));
        page.setLists(userMapper.findPage(userName, page.getStartSite(), page.getEndSite()));
        page.setPageNum(userMapper.getAllCount(userName));
        return page;
    }


    /**
     * 根据id获取用户信息
     * @param id
     * @return
     */
    public User getById(Integer id){
        return userMapper.getById(id);
    }

    public void update(User user){
        userMapper.update(user);
    }

    public void save(User user){
        userMapper.save(user);
    }

    public void delete(User user){
        userMapper.delete(user);
    }

    /**
     * 校验用户信息
     * @param params
     * @return
     */
    public JsonResult<User> checkUser(String params){
        params = params.replaceAll("=", "");
        JSONObject paramsJson = JSON.parseObject(params);
        String name = paramsJson.getString("name");
        String password = paramsJson.getString("password");
        String type = paramsJson.getString("type");
        JsonResult result = new JsonResult();
        result.setSuccess(true);
        result.setMessage("用户验证通过");
        result.setErrorCode(StaticParam.NO_ERROR);
        User user = new User();
        if(StringUtils.endsWithIgnoreCase(type, StaticParam.CHECK_USER_PARAM_TYPE_NAME)){
            user = userMapper.getByName(name);
            if(user == null){
                result.setSuccess(false);
                result.setMessage("用户不存在");
                result.setErrorCode(StaticParam.NO_DATA_ERROR_CODE);
                return result;
            }
        }
        if(StringUtils.endsWithIgnoreCase(type, StaticParam.CHECK_USER_PARAM_TYPE_PHONE)){
            user = userMapper.getByPhone(name);
            if(user == null){
                result.setSuccess(false);
                result.setMessage("用户不存在");
                result.setErrorCode(StaticParam.NO_DATA_ERROR_CODE);
                return result;
            }
        }
        if(!MethodTools.getSaltverifyMD5(password, user.getPassword())){
            result.setSuccess(false);
            result.setMessage("密码错误");
            result.setErrorCode(StaticParam.DATA_ERROR_CODE);
        }
        result.setT(user);
        return result;
    }
}