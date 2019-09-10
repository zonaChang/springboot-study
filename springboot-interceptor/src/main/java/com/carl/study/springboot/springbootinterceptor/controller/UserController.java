package com.carl.study.springboot.springbootinterceptor.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

/**
 * @author changez
 * @desc
 * @datetime 2019/9/9 23:58
 */
@Slf4j
@RestController
@RequestMapping("/api/user")
public class UserController {

    @GetMapping("/detail")
    public Object detail(String name){
        Map<String, Object> retMap = new HashMap<>();
        retMap.put("name", name);
        retMap.put("age", 22);
        return retMap;
    }

    @PostMapping("/login")
    public Object login(){
        log.info("login..........");
        return "login";
    }

    @PostMapping("/send/code")
    public Object sendCode(){
        log.info("sendCode..........");
        return "sendCode";
    }

}
