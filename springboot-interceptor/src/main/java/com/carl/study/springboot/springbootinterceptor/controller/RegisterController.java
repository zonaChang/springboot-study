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
@RequestMapping("/api/register")
public class RegisterController {

    @PostMapping("/logout")
    public Object logout(){
        log.info("logout..........");
        return "logout";
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
