package com.carl.study.springboot.springbootinterceptor.interceptor;

import lombok.extern.slf4j.Slf4j;
import org.springframework.core.annotation.Order;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author changez
 * @desc
 * @datetime 2019/9/16 9:52
 */
@Slf4j
public class UploadInterceptor extends HandlerInterceptorAdapter {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

        log.info("uri={}", request.getRequestURI());
        return true;
    }
}
