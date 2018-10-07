package com.x.jk.service.impl;

import com.x.jk.mybatis.mapper.SchoolInfoMapper;
import com.x.jk.po.entity.SchoolInfo;
import com.x.jk.service.SchoolService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SchoolServiceImpl implements SchoolService {
    @Autowired
    SchoolInfoMapper schoolInfoMapper;
    @Override
    public List<SchoolInfo> getAllSchoolInfo() {
        return schoolInfoMapper.getAll();
    }

    @Override
    public void addSchool(String name) {
        schoolInfoMapper.addSchool(name);
    }

    @Override
    public void updateSchool(Integer id, String name) {
        SchoolInfo schoolInfo = new SchoolInfo();
        schoolInfo.setId(id);
        schoolInfo.setSchoolName(name);
        schoolInfoMapper.updateSchool(schoolInfo);
    }

    @Override
    public void delSchoolById(Integer id) {
        schoolInfoMapper.delById(id);
    }
}
