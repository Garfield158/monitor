package com.x.jk.service;

import com.x.jk.po.entity.DeviceInfo;
import com.x.jk.po.entity.Page;

import java.util.List;

public interface DeviceService {
    List<DeviceInfo> getDevBySchoolId(int id, Page pageObj);

    DeviceInfo getDeviceById(Integer id);

    Integer getDevCounts(Integer id);

    List<DeviceInfo> getDevListBySchoolId(Integer schoolId, Page pageObj);

    void UpdateDev(DeviceInfo deviceInfo);
}
