package com.x.jk.common;


import com.x.jk.po.entity.Page;

public class Result {
    private int code=200;
    private String msg;
    private Object data;
    private Page page;

    public Result( Object data) {

        this.data = data;
    }

    public Result( Object data,Page page) {

        this.data = data;
        this.page = page;
    }

    public Result(int code,String msg){
        this.code=code;
        this.msg=msg;
    }

    public Result(int code) {
        this.code = code;
    }

    public static Result bulid(){
       return new Result(200);
    }
    public static Result bulid(Object data){
        return new Result(data);
    }
    public static Result bulid(Object data, Page page){
        return new Result(data,page);
    }
    public static Result bulid(int code, String msg){
        return new Result(code,msg);
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public Page getPage() {
        return page;
    }

    public void setPage(Page page) {
        this.page = page;
    }
}
