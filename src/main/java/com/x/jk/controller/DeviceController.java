package com.x.jk.controller;

import com.x.jk.HttpClientUtil;
import com.x.jk.common.Result;
import com.x.jk.po.entity.DeviceInfo;
import com.x.jk.po.entity.Page;
import com.x.jk.po.entity.Token;
import com.x.jk.service.DeviceService;
import com.x.jk.service.TokenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class DeviceController {
    @Autowired
    TokenService tokenService;
    @Autowired
    DeviceService deviceService;
    @RequestMapping("res/dev/getDev")
    public Result getDeviceBySchoolId(Integer id,Integer page,Integer size){
        Page pageObj = new Page();
        pageObj.setPage(page);
        pageObj.setSize(size);
        List<DeviceInfo> deviceInfos=deviceService.getDevBySchoolId(id,pageObj);
        int k = deviceService.getDevCounts(id)%pageObj.getSize();
        int count;
        if(k==0){
            count = deviceService.getDevCounts(id)/pageObj.getSize();
        }else{
            count = deviceService.getDevCounts(id)/pageObj.getSize()+1;
        }
        pageObj.setCount(count);
        return Result.bulid(deviceInfos,pageObj);
    }

    @RequestMapping("res/dev/controlOne")
    public Result controlOneById(Integer id,String direction){
        DeviceInfo deviceInfo = deviceService.getDeviceById(id);
        Token token = tokenService.getToken();
        Map map = new HashMap();
        map.put("accessToken",token.getToken_rs());
        map.put("deviceSerial",deviceInfo.getDevNum());
        map.put("channelNo",String.valueOf(deviceInfo.getChannleNum()));
        map.put("direction",direction);
        map.put("speed","2");
        String data = HttpClientUtil.sendHttpsPost("https://open.ys7.com/api/lapp/device/ptz/start",map);
        return Result.bulid(data);
    }

    @RequestMapping("res/dev/stopDevice")
    public Result stopDevice(Integer id){
        DeviceInfo deviceInfo = deviceService.getDeviceById(id);
        Token token = tokenService.getToken();
        Map map = new HashMap();
        map.put("accessToken",token.getToken_rs());
        map.put("deviceSerial",deviceInfo.getDevNum());
        map.put("channelNo",String.valueOf(deviceInfo.getChannleNum()));
        String data = HttpClientUtil.sendHttpsPost("https://open.ys7.com/api/lapp/device/ptz/stop",map);
        return Result.bulid(data);
    }

    /**根据学校id查询设备列表*/
    @RequestMapping("res/dev/getDevListBySchoolId")
    public Result getDevListBySchoolId(Integer schoolId,Integer page,Integer size){
        List<DeviceInfo> devList = new ArrayList<DeviceInfo>();
        Page pageObj = new Page();
        pageObj.setPage(page);
        pageObj.setSize(size);
        devList = deviceService.getDevListBySchoolId(schoolId,pageObj);
        int k = deviceService.getDevCounts(schoolId)%pageObj.getSize();
        int count;
        if(k==0){
            count = deviceService.getDevCounts(schoolId)/pageObj.getSize();
        }else{
            count = deviceService.getDevCounts(schoolId)/pageObj.getSize()+1;
        }
        pageObj.setCount(count);
        return Result.bulid(devList,pageObj);
    }

    /**修改设备信息*/
    @RequestMapping("res/dev/updateDev")
    public Result UpdateDev(Integer id,String devName,int channleNum,String devNum,
                            int schoolID, int state,String url,String imgUrl,
                            String IOTitle){
        DeviceInfo deviceInfo = new DeviceInfo();
        if (id==null){
            deviceInfo.setId(0);
        }else {
            deviceInfo.setId(id);
        }
        deviceInfo.setDevName(devName);
        deviceInfo.setChannleNum(channleNum);
        deviceInfo.setDevNum(devNum);
        deviceInfo.setSchoolID(schoolID);
        deviceInfo.setState(state);
        deviceInfo.setUrl(url);
        deviceInfo.setImgUrl(imgUrl);
        deviceInfo.setIOTitle(IOTitle);
        try{
            deviceService.UpdateDev(deviceInfo);
        }catch (Exception e){
            return Result.bulid("修改失败");
        }
        return Result.bulid("修改成功");
    }
    @RequestMapping("res/dev/delById")
    public Result delById(Integer id){
        deviceService.delById(id);
        return Result.bulid();
    }
    @RequestMapping("res/dev/getById")
    public Result getById(Integer id){
        DeviceInfo device = deviceService.getDeviceById(id);
        return Result.bulid(device);
    }

}
