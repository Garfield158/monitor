package com.x.jk.controller;

import com.x.jk.common.Result;
import com.x.jk.po.entity.SchoolInfo;
import com.x.jk.service.SchoolService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class SchoolController {
    @Autowired
    SchoolService schoolService;
    @RequestMapping("res/School/getAll")
    public Result findAllSchool(){
        return Result.bulid(schoolService.getAllSchoolInfo());
    }
    @RequestMapping("res/School/add")
    public Result addOrUpdateSchool(Integer id,String name){
        if (id==null){
            schoolService.addSchool(name);
        }else {
            schoolService.updateSchool(id,name);
        }
        return Result.bulid();
    }
    @RequestMapping("res/School/delById")
    public Result delById(Integer id){
        schoolService.delSchoolById(id);
        return Result.bulid();
    }
    @RequestMapping("res/School/pageFind")
    public Result getAllByPage(Integer pageNum,Integer pageSize){
        if (pageNum==null||pageNum==0){
            pageNum=1;
        }
        if (pageSize==null){
            pageSize=10;
        }
        List<SchoolInfo> data = schoolService.getAllSchoolInfo();

        int fromIndex = (pageNum - 1) * pageSize;
        if (fromIndex >= data.size()) {
           return Result.bulid(5000,"已到最大页");
        }
        int toIndex = pageNum * pageSize;
        if (toIndex >= data.size()) {
            toIndex = data.size();
        }
        List<SchoolInfo> schoolInfos = data.subList(fromIndex, toIndex);
        Map<String,Object> datamap=new HashMap<>();
        datamap.put("total",data.size());
        datamap.put("data",schoolInfos);
        return Result.bulid(datamap);

    }
}
