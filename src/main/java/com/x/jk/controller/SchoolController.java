package com.x.jk.controller;

import com.x.jk.common.Result;
import com.x.jk.service.SchoolService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SchoolController {
    @Autowired
    SchoolService schoolService;
    @RequestMapping("res/School/getAll")
    public Result findAllSchool(){
        return Result.bulid(schoolService.getAllSchoolInfo());
    }
}
