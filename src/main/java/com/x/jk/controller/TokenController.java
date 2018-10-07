package com.x.jk.controller;

import com.x.jk.common.Result;
import com.x.jk.service.TokenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TokenController {
    @Autowired
    TokenService tokenService;
    @RequestMapping("access/getToken")
    public Result getToken(){
        return Result.bulid(tokenService.getToken());
    }
}
