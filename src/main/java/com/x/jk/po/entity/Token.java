package com.x.jk.po.entity;

public class Token {
    private int id;
    private String appKey;
    private String secret;
    private Long expireTime;
    private String token_rs;

    public Token() {
    }

    public Token(int id, String appKey, String secret, Long expireTime, String token_rs) {
        this.id = id;
        this.appKey = appKey;
        this.secret = secret;
        this.expireTime = expireTime;
        this.token_rs = token_rs;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getAppKey() {
        return appKey;
    }

    public void setAppKey(String appKey) {
        this.appKey = appKey;
    }

    public String getSecret() {
        return secret;
    }

    public void setSecret(String secret) {
        this.secret = secret;
    }

    public Long getExpireTime() {
        return expireTime;
    }

    public void setExpireTime(Long expireTime) {
        this.expireTime = expireTime;
    }

    public String getToken_rs() {
        return token_rs;
    }

    public void setToken_rs(String token_rs) {
        this.token_rs = token_rs;
    }

}
