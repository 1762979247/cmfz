package com.baizhi.cmfz.entity;

import com.alibaba.fastjson.annotation.JSONField;

import java.io.Serializable;
import java.util.Date;

/**
 * @Description:    日志的实体类
 * @Author zhy
 * @Date 2018-07-09 20:07
 */
public class Log implements Serializable{
    private String id;
    private String optUser;
    @JSONField(format = "yyyy-MM-dd HH:mm:ss")
    private Date time;
    private String resource;
    private String action;
    private String message;
    private String result;

    @Override
    public String toString() {
        return "Log{" +
                "id='" + id + '\'' +
                ", optUser='" + optUser + '\'' +
                ", time=" + time +
                ", resource='" + resource + '\'' +
                ", action='" + action + '\'' +
                ", message='" + message + '\'' +
                ", result='" + result + '\'' +
                '}';
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getOptUser() {
        return optUser;
    }

    public void setOptUser(String optUser) {
        this.optUser = optUser;
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }

    public String getResource() {
        return resource;
    }

    public void setResource(String resource) {
        this.resource = resource;
    }

    public String getAction() {
        return action;
    }

    public void setAction(String action) {
        this.action = action;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }

    public Log(String id, String optUser, Date time, String resource, String action, String message, String result) {

        this.id = id;
        this.optUser = optUser;
        this.time = time;
        this.resource = resource;
        this.action = action;
        this.message = message;
        this.result = result;
    }

    public Log() {

    }
}
