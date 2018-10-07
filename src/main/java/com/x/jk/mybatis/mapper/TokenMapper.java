package com.x.jk.mybatis.mapper;

import com.x.jk.po.entity.Token;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface TokenMapper {
    Token getToken();
    void updateToken(Token token);
}
