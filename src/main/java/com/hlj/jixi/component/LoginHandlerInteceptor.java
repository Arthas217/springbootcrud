package com.hlj.jixi.component;

import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @Author zc217
 * @Date 2020/9/4
 * 登录检查拦截器（防止主页非法用户访问）
 */
public class LoginHandlerInteceptor implements HandlerInterceptor {
    /**
     * 预检查
     */
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        Object loginUser = request.getSession().getAttribute("loginUser");
        if(loginUser == null){
            //未登录
            request.setAttribute("msg","未登录用户，请先登录");
            request.getRequestDispatcher("/login.html").forward(request,response);
            return false;
        }else {
            return true;
        }
    }
}
