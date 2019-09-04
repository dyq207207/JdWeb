package org.lanqiao.jd.util;

import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class CheckLogInterceptor implements HandlerInterceptor {
    long start = System.currentTimeMillis();
    @Override
    public boolean preHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o) throws Exception {
        Cookie[] cookies = httpServletRequest.getCookies();
        if (cookies != null && cookies.length >0) {
            for (Cookie cookie : cookies) {
                if(cookie.getName().equals("loginName")){
                    return true;
                }
            }
        }
        httpServletResponse.sendRedirect("/jdlogin.html");
        return false;
    }

}