package com.x.jk.po.entity;

public class DeviceInfo {
    private int id;
    private String devName;
    private int channleNum;
    private String  devNum;
    private int schoolID;
    private int state;
    private String url;
    private String imgUrl;
    private String IOTitle;


    public String getIOTitle() {
        return IOTitle;
    }

    public void setIOTitle(String IOTitle) {
        this.IOTitle = IOTitle;
    }

    public String getImgUrl() {
        return imgUrl;
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDevName() {
        return devName;
    }

    public void setDevName(String devName) {
        this.devName = devName;
    }

    public int getChannleNum() {
        return channleNum;
    }

    public void setChannleNum(int channleNum) {
        this.channleNum = channleNum;
    }

    public String getDevNum() {
        return devNum;
    }

    public void setDevNum(String devNum) {
        this.devNum = devNum;
    }

    public int getSchoolID() {
        return schoolID;
    }

    public void setSchoolID(int schoolID) {
        this.schoolID = schoolID;
    }

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
    }
}
