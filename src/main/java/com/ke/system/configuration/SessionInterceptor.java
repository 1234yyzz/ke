package com.ke.system.configuration;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Date;

/**
 * @Author: Yu Zheng
 * @Description
 * @Date: Create In 10:12 2020/8/15
 * @Modified BY:
 **/

public class SessionInterceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        Object obj = request.getSession().getAttribute("_session_user");
        if(obj == null){
            response.sendRedirect("/KeSystem/login");
            return false;
        }
        Object timestamp = request.getSession().getAttribute("_session_timestamp");
        Date now = new Date();
        if((now.getTime() - (Long)timestamp) >= 10*60*1000){
            request.getSession().removeAttribute("_session_user");
            request.getSession().removeAttribute("_session_timestamp");
            System.out.println("用户登录已失效");
            response.sendRedirect("/KeSystem/login");
            return false;
        }
        request.setAttribute("ctx", request.getContextPath());
        return true;
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
       request.getSession().setAttribute("ctx", request.getContextPath());
    }
}
