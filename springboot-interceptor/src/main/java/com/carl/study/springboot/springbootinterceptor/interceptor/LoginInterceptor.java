package com.carl.study.springboot.springbootinterceptor.interceptor;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author changez
 * @desc
 * @datetime 2019/9/9 23:53
 */
@Slf4j
public class LoginInterceptor extends HandlerInterceptorAdapter {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {


        System.out.println("uri="+request.getRequestURI());
        String name = request.getParameter("name");
        log.info("name={}, url={}", name, request.getRequestURI());
        return "carl".equals(name);
    }
}
