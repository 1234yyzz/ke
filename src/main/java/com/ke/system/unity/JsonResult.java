package com.ke.system.unity;

import com.alibaba.fastjson.annotation.JSONField;
import com.ke.system.user.entity.User;
import lombok.Data;

/**
 * @Author: Yu Zheng
 * @Description
 * @Date: Create In 9:35 2020/8/18
 * @Modified BY:
 **/
@Data
public class JsonResult<T> {

    @JSONField(name = "message")
    private String message = "获取信息成功";

    @JSONField(name = "success")
    private Boolean success = true;

    @JSONField(name = "errorCode")
    private String errorCode = StaticParam.NO_ERROR;

    @JSONField(name = "data")
    private T t;

}
