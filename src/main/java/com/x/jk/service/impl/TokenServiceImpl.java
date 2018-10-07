package com.x.jk.service.impl;

import com.x.jk.mybatis.mapper.TokenMapper;
import com.x.jk.po.entity.Token;
import com.x.jk.service.TokenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TokenServiceImpl implements TokenService {
    @Autowired
    TokenMapper tokenMapper;
    @Override
    public Token getToken() {
        return tokenMapper.getToken();
    }
}
