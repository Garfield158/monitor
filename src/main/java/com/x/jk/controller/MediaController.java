package com.x.jk.controller;

import com.x.jk.common.Result;
import com.x.jk.po.entity.DeviceInfo;
import com.x.jk.po.entity.MediaRes;
import com.x.jk.service.DeviceService;
import com.x.jk.service.VODService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class MediaController {
    @Autowired
    VODService vodService;
    @Autowired
    DeviceService deviceService;
    @Autowired
     Environment env;
    @RequestMapping("res/media/getByTime")
    public Result getLBSrcList(String startDate,String startTime,Integer id){
        DeviceInfo device = deviceService.getDeviceById(id);
        if ("".equals(startTime)||startTime==null){
            startTime="00:00";
        }
        if ("".equals(startDate)||startDate==null){
            startDate="2008-08-18";
        }
        String dateStr= startDate+" "+startTime;
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm");
        Date date = null;
        try {
            date = format.parse(dateStr);
        } catch (ParseException e) {
            e.printStackTrace();
        }
          String ACCESS_KEY_I=env.getProperty("com.baidu.ak");
          String SECRET_ACCESS_KEY =env.getProperty("com.baidu.sk");
        List<MediaRes> mediaByTime = vodService.getMediaByTime(ACCESS_KEY_I,SECRET_ACCESS_KEY, date, new Date(),device);
        Map<String,Object> rs=new HashMap<>();
        rs.put("mediaByTime",mediaByTime);
        rs.put("size",mediaByTime.size());
        return Result.bulid(rs);
    }
}
