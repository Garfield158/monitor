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
}
