package com.x.jk.service;

import com.x.jk.po.entity.DeviceInfo;
import com.x.jk.po.entity.MediaRes;

import java.util.Date;
import java.util.List;

public interface VODService {
    List<MediaRes> getMediaByTime(String ak,String sk, Date startTime, Date endTime, DeviceInfo device);
}
