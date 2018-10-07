package com.x.jk.service;

import com.x.jk.po.entity.UserInfo;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface UserService {
    List<UserInfo> findAll();
}
