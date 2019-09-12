package com.carl.study.springboot.springbootinterceptor.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

/**
 * @author changez
 * @desc
 * @datetime 2019/9/12 21:00
 */
@Slf4j
@RestController
@RequestMapping("/api/goods")
public class GoodsController {

    @GetMapping("/detail")
    public Object detail(String name){
        Map<String, Object> retMap = new HashMap<>();
        retMap.put("name", name);
        retMap.put("age", 22);
        System.out.println("detail..........");
        return retMap;
    }
}
