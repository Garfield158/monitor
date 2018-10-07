package com.x.jk.service.impl;

import com.x.jk.mybatis.mapper.UserinfoMapper;
import com.x.jk.po.entity.UserInfo;
import com.x.jk.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    UserinfoMapper userinfoMapper;
    @Override
    public List<UserInfo> findAll() {
        return userinfoMapper.getAllUser();
    }
}
