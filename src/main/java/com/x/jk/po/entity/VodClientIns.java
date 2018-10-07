package com.x.jk.po.entity;

import com.baidubce.BceClientConfiguration;
import com.baidubce.auth.DefaultBceCredentials;
import com.baidubce.services.vod.VodClient;
import com.x.jk.po.properties.WebSetting;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.env.Environment;


public class VodClientIns {

    private  String ACCESS_KEY_ID ;
    private  String SECRET_ACCESS_KEY ;
    @Autowired
    private Environment env;

    public VodClientIns() {

    }

    public  VodClient VodClientInstent(String ak, String sk){
        BceClientConfiguration config = new BceClientConfiguration();
        config.setCredentials(new DefaultBceCredentials(ak, sk));
        // config.setEndpoint("http://vod.bj.baidubce.com");
        config.setEndpoint("http://vod.bj.baidubce.com");
        return new VodClient(config);
    }

    public  void setAccessKeyId(String accessKeyId) {
        ACCESS_KEY_ID = accessKeyId;
    }
    public  void setSecretAccessKey(String secretAccessKey) {
        SECRET_ACCESS_KEY = secretAccessKey;
    }
}
