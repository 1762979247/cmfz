package com.baizhi.cmfz.service;

import com.baizhi.cmfz.entity.Picture;

import java.util.Map;

/**
 * @Description: 轮播图相关的Service
 * @Author zhy
 * @Date 2018-07-05 19:38
 */
public interface PictureService {

    /*
     * @Description  分页展示轮播图
     * @Author zhy
     * @Date 2018/7/5 19:40
     * @Param [currentPage, pageSize]
     * @Return java.util.Map<java.lang.String,java.lang.Object>
     */
    public Map<String,Object> searchPictureByPage(Integer currentPage, Integer pageSize);

    /*
     * @Description  添加轮播图
     * @Author zhy
     * @Date 2018/7/6 9:40
     * @Param [pic]
     * @Return void
     */
    public void addPicture(Picture pic);
}
