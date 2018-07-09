package com.baizhi.cmfz.entity;

import com.alibaba.fastjson.annotation.JSONField;

import java.io.Serializable;
import java.util.Date;

/**
 * @Description: 轮播图相关的实体类
 * @Author zhy
 * @Date 2018-07-05 18:18
 */
public class Picture implements Serializable{
    private String pictureId;
    private String picturePath;
    @JSONField(format = "yyyy-MM-dd HH:mm:ss")
    private Date pictureDate;
    private String pictureDesc;
    private String pictureStatus;

    @Override
    public String toString() {
        return "Picture{" +
                "pictureId='" + pictureId + '\'' +
                ", picturePath='" + picturePath + '\'' +
                ", pictureDate=" + pictureDate +
                ", pictureDesc='" + pictureDesc + '\'' +
                ", pictureStatus='" + pictureStatus + '\'' +
                '}';
    }

    public String getPictureId() {
        return pictureId;
    }

    public void setPictureId(String pictureId) {
        this.pictureId = pictureId;
    }

    public String getPicturePath() {
        return picturePath;
    }

    public void setPicturePath(String picturePath) {
        this.picturePath = picturePath;
    }

    public Date getPictureDate() {
        return pictureDate;
    }

    public void setPictureDate(Date pictureDate) {
        this.pictureDate = pictureDate;
    }

    public String getPictureDesc() {
        return pictureDesc;
    }

    public void setPictureDesc(String pictureDesc) {
        this.pictureDesc = pictureDesc;
    }

    public String getPictureStatus() {
        return pictureStatus;
    }

    public void setPictureStatus(String pictureStatus) {
        this.pictureStatus = pictureStatus;
    }

    public Picture(String pictureId, String picturePath, Date pictureDate, String pictureDesc, String pictureStatus) {

        this.pictureId = pictureId;
        this.picturePath = picturePath;
        this.pictureDate = pictureDate;
        this.pictureDesc = pictureDesc;
        this.pictureStatus = pictureStatus;
    }

    public Picture() {

    }
}
