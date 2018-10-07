package com.x.jk.service.impl;

import com.baidubce.services.vod.VodClient;
import com.baidubce.services.vod.model.ListMediaResourceResponse;
import com.baidubce.services.vod.model.MediaResource;
import com.baidubce.services.vod.model.PlayableUrl;
import com.x.jk.po.entity.DeviceInfo;
import com.x.jk.po.entity.MediaRes;
import com.x.jk.po.entity.VodClientIns;
import com.x.jk.service.VODService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class VODServiceImpl implements VODService {
    @Override
    public List<MediaRes> getMediaByTime(String ak,String sk, Date startTime, Date endTime, DeviceInfo device) {
        VodClientIns vodClientIns = new VodClientIns();
        VodClient vodClient = vodClientIns.VodClientInstent(ak,sk);
        if (device.getIOTitle()==null){
            device.setIOTitle("无");
        }
        ListMediaResourceResponse responce = vodClient.listMediaResources(1, 999, "PUBLISHED", startTime, endTime, device.getIOTitle());
        List<MediaResource> media = responce.getMedia();
        List<MediaRes> mediaResList=new ArrayList<>();
        for (MediaResource mediaResource:media){
            MediaRes mediaRes = new MediaRes();
            List<PlayableUrl> urlList = mediaResource.getPlayableUrlList();
            mediaRes.setCreateTime(mediaResource.getCreateTime());
            mediaRes.setDuration(mediaResource.getMeta().getDurationInSeconds());
            mediaRes.setMediaID(mediaResource.getMediaId());
            if (urlList.size()>0){
                mediaRes.setUrl(urlList.get(0).getUrl());
            }
            mediaResList.add(mediaRes);
        }
        mediaResList= sortByTime(mediaResList);
        return mediaResList;
    }

    private List<MediaRes> sortByTime(List<MediaRes> mediaResList) {
        List<MediaRes> rs=new ArrayList<>();
        for (int i=mediaResList.size()-1;i>0;i--){
            rs.add(mediaResList.get(i));
        }
       // mediaResList.sort((MediaRes m1,MediaRes m2) ->m1.getCreateTime().compareTo(m2.getCreateTime()));
        return rs;
    }
}
