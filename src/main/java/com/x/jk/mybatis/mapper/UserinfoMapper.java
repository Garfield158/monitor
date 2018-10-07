package com.x.jk.mybatis.mapper;

import com.x.jk.po.entity.UserInfo;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface UserinfoMapper {
    List<UserInfo> getAllUser();
}
