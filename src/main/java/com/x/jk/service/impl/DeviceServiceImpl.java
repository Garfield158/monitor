package com.x.jk.service.impl;

import com.x.jk.mybatis.mapper.DeviceMapper;
import com.x.jk.po.entity.DeviceInfo;
import com.x.jk.po.entity.Page;
import com.x.jk.service.DeviceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DeviceServiceImpl implements DeviceService {
    @Autowired
    DeviceMapper deviceMapper;
    @Override
    public List<DeviceInfo> getDevBySchoolId(int id, Page pageObj) {
        int first = (pageObj.getPage() - 1) * Page.size;
        List<DeviceInfo> infos = deviceMapper.getAllBySchoolId(id,first,Page.size);
        return infos;
    }

    @Override
    public DeviceInfo getDeviceById(Integer id) {
        return deviceMapper.getDeviceById(id);
    }

    @Override
    public Integer getDevCounts(Integer id) {
        return deviceMapper.getDevCounts(id);
    }
}
