package com.x.jk.service;

import com.x.jk.po.entity.SchoolInfo;

import java.util.List;

public interface SchoolService {
    List<SchoolInfo> getAllSchoolInfo();

    void addSchool(String name);

    void updateSchool(Integer id, String name);

    void delSchoolById(Integer id);
}
