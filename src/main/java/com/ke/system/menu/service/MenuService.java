package com.ke.system.menu.service;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.ke.system.menu.entity.Menu;
import com.ke.system.menu.mapper.MenuMapper;
import com.ke.system.unity.JsonResult;
import com.ke.system.unity.Page;
import com.ke.system.unity.StaticParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.*;

/**
 * @Author: Yu Zheng
 * @Description
 * @Date: Create In 8:52 2020/8/27
 * @Modified BY:
 **/
@Service
public class MenuService {

    @Autowired
    private MenuMapper menuMapper;

    /**
     * 获取所有菜单
     * @return
     */
    public JsonResult<List<Menu>> getAllMenus(){
        JsonResult<List<Menu>> result = new JsonResult<List<Menu>>();
        List<Menu> list = menuMapper.getAllMenu();
        if(!CollectionUtils.isEmpty(list)){
            result.setT(transferData(list));
        }
        else {
            result.setErrorCode(StaticParam.NO_DATA_ERROR_CODE);
            result.setSuccess(false);
            result.setMessage("该用户未绑定菜单");
        }
        return result;
    }


    /**
     * 根据用户获取菜单
     * @param roleId
     * @return
     */
    public JsonResult<List<Menu>> getMenusByRoleId(Integer roleId){
        JsonResult<List<Menu>> result = new JsonResult<List<Menu>>();
        List<Menu> list = menuMapper.getMenusByRoleId(roleId);
        if(CollectionUtils.isEmpty(list)){
            result.setErrorCode(StaticParam.NO_DATA_ERROR_CODE);
            result.setMessage("该用户未绑定菜单");
        }
        else {
            result.setT(transferData(list));
        }
        return result;
    }

    /**
     * 组装信息
     * @param list
     * @return
     */
    private List<Menu> transferData(List<Menu> list){
        Iterator<Menu> iterator = list.iterator();
        Map<Integer, Menu> secondMenus = new HashMap<>();
        Map<Integer, Menu> thirdMenus = new HashMap<>();
        Map<Integer, Menu> firstMenus = new HashMap<>();
        while (iterator.hasNext()){
            Menu menu = iterator.next();
            if(menu.getLevel() == 1){
                firstMenus.put(menu.getId(),menu);
            }
            if(menu.getLevel() == 2){
                secondMenus.put(menu.getId(),menu);
            }
            if(menu.getLevel() == 3){
                thirdMenus.put(menu.getId(),menu);
            }
        }
        if(!CollectionUtils.isEmpty(thirdMenus)){
            for(Integer k : thirdMenus.keySet()){
                Menu menu = secondMenus.get(thirdMenus.get(k).getParentId());
                if(menu == null){
                    continue;
                }
                menu.addChild(thirdMenus.get(k));
                secondMenus.put(menu.getId(), menu);
            }
        }
        if(!CollectionUtils.isEmpty(secondMenus)){
            for(Integer k : secondMenus.keySet()){
                Menu menu = firstMenus.get(secondMenus.get(k).getParentId());
                if(menu == null){
                    continue;
                }
                menu.addChild(secondMenus.get(k));
                firstMenus.put(menu.getId(), menu);
            }
        }
        List<Menu> menus = new ArrayList<>();
        if(!CollectionUtils.isEmpty(firstMenus)){
            for(Integer k : firstMenus.keySet()){
                menus.add(firstMenus.get(k));
            }
        }
        return menus;
    }
}
