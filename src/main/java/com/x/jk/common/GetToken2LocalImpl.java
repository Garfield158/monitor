package com.x.jk.common;


import com.alibaba.fastjson.JSONObject;
import com.x.jk.HttpClientUtil;
import com.x.jk.mybatis.mapper.DeviceMapper;
import com.x.jk.mybatis.mapper.TokenMapper;
import com.x.jk.po.entity.DeviceInfo;
import com.x.jk.po.entity.Token;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


@Component
public class GetToken2LocalImpl  {
    @Autowired
    private TokenMapper tokenMapper;
    @Autowired
    private DeviceMapper deviceMapper;






    /**定时任务取token*/
    @Scheduled(cron = "0 0 0 * * ?")
    public void getTokenFromServer(){
        String dateStart = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());
        System.out.println("=====自动任务开始"+dateStart+"=====");
        //查询本地的appKey,appSecret
        Token token = getToken();
        Map map = new HashMap();
        map.put("appKey",token.getAppKey());
        map.put("appSecret",token.getSecret());
        String json = HttpClientUtil.sendHttpsPost("https://open.ys7.com/api/lapp/token/get",map);
        JSONObject jsonObj = JSONObject.parseObject(json);
        JSONObject obj = JSONObject.parseObject(jsonObj.get("data").toString());
        //取得时间戳
        Long expireTime = Long.parseLong(obj.get("expireTime").toString());
        //取得accessToken
        String accessToken = obj.get("accessToken").toString();
        Token token_new = new Token();
        token_new.setExpireTime(expireTime);
        token_new.setToken_rs(accessToken);
        updateToken(token_new);
        String dateEnd = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());
        System.out.println("=====自动任务结束"+dateEnd+"=====");
    }

//    @Scheduled(fixedRate = 5000)
//    public void getImgUrlTask() {
//        String url="https://open.ys7.com/api/lapp/device/capture";
//        String token_rs = tokenMapper.getToken().getToken_rs();
//        List<DeviceInfo> deviceInfos= deviceMapper.getAllDevice();
//        for (DeviceInfo dev:deviceInfos) {
//            String devNum = dev.getDevNum();
//            int channleNum = dev.getChannleNum();
//            Map<String,String> pmap=new HashMap<>();
//            pmap.put("accessToken",token_rs);
//            pmap.put("deviceSerial",devNum);
//            pmap.put("channelNo",channleNum+"");
//            String httpsPost = HttpClientUtil.sendHttpsPost(url, pmap);
//            System.out.println(httpsPost);
//            JSONObject jsonObj = JSONObject.parseObject(httpsPost);
//            JSONObject obj = JSONObject.parseObject(jsonObj.get("data").toString());
//            String picUrl = obj.get("picUrl").toString();
//            deviceMapper.updateDevImgUrl(picUrl,dev.getId());
//            try {
//                Thread.sleep(10000);
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
//        }
//    }

    private Token getToken(){
        return tokenMapper.getToken();
    }
    private void updateToken(Token token){
        tokenMapper.updateToken(token);
    }
}
