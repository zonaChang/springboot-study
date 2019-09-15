package com.carl.study.springboot.security.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.PublicKey;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author changez
 * @desc
 * @datetime 2019/9/14 12:14
 */
@RestController
@RequestMapping("/api/goods")
public class GoodsController {

    @GetMapping("list")
     public Object list(){

        System.out.println(Thread.currentThread().getStackTrace()[1].getMethodName()+"--------");
        List list = new ArrayList();
        Map map2 = new HashMap();
        map2.put("name", "zona");
        map2.put("age", 22);
        Map map1 = new HashMap();
        map1.put("name", "carl");
        map1.put("age", 18);
        list.add(map1);
        list.add(map2);
        return list;
    }

    @GetMapping("detail")
    public Object detail(){
        System.out.println(Thread.currentThread().getStackTrace()[1].getMethodName()+"--------");
        Map map = new HashMap();
        return map;
    }

    @PostMapping("add")
    public Object add(Map<String, Object> paramMap){

        System.out.println(Thread.currentThread().getStackTrace()[1].getMethodName()+"--------");
        Map<String, Object> retMap = new HashMap<>();
        return retMap;
    }
}
