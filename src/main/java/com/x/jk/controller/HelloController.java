package com.x.jk.controller;

import com.x.jk.common.Result;
import com.x.jk.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Map;

@Controller
public class HelloController {
    @Autowired
    UserService userService;
    @GetMapping("/index")
    public String helloworld(Map<String,Object> map) {
        map.put("msg", "Hello Freemarker");
        return "index";
    }
    @RequestMapping("/getUser")
    public Result showUser(){
        return  Result.bulid(userService.findAll());
    }
}
