package com.x.jk.mybatis.mapper;

import com.x.jk.po.entity.SchoolInfo;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Mapper
public interface SchoolInfoMapper {
    List<SchoolInfo> getAll();
}
