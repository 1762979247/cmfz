package com.baizhi.cmfz.entity;

import org.jeecgframework.poi.excel.annotation.Excel;

import java.io.Serializable;

/**
 * @Description: 上师的实体类
 * @Author zhy
 * @Date 2018-07-06 16:54
 */
public class Master implements Serializable {
    @Excel(name = "上师编号", width = 40.0)
    private String masterId;
    @Excel(name = "法名", width = 30.0)
    private String masterName;
    @Excel(name = "头像路径", width = 20.0)
    private String masterPhoto;
    @Excel(name = "上师简介" ,width = 50.0)
    private String masterIntro;

    @Override
    public String toString() {
        return "Master{" +
                "masterId='" + masterId + '\'' +
                ", masterName='" + masterName + '\'' +
                ", masterPhoto='" + masterPhoto + '\'' +
                ", masterIntro='" + masterIntro + '\'' +
                '}';
    }

    public String getMasterId() {
        return masterId;
    }

    public void setMasterId(String masterId) {
        this.masterId = masterId;
    }

    public String getMasterName() {
        return masterName;
    }

    public void setMasterName(String masterName) {
        this.masterName = masterName;
    }

    public String getMasterPhoto() {
        return masterPhoto;
    }

    public void setMasterPhoto(String masterPhoto) {
        this.masterPhoto = masterPhoto;
    }

    public String getMasterIntro() {
        return masterIntro;
    }

    public void setMasterIntro(String masterIntro) {
        this.masterIntro = masterIntro;
    }

    public Master(String masterId, String masterName, String masterPhoto, String masterIntro) {

        this.masterId = masterId;
        this.masterName = masterName;
        this.masterPhoto = masterPhoto;
        this.masterIntro = masterIntro;
    }

    public Master() {

    }



}
