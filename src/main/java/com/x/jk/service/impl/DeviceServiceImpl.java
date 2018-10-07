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
        int first = (pageObj.getPage() - 1) * pageObj.getSize();
        List<DeviceInfo> infos = deviceMapper.getAllBySchoolId(id,first,pageObj.getSize());
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

    @Override
    public List<DeviceInfo> getDevListBySchoolId(Integer schoolId, Page pageObj) {
        int first = (pageObj.getPage() - 1) * pageObj.getSize();
        return deviceMapper.getDevListBySchoolId(schoolId,first,pageObj.getSize());
    }

    @Override
    public void UpdateDev(DeviceInfo deviceInfo) {
        deviceMapper.UpdateDev(deviceInfo);
    }
}
