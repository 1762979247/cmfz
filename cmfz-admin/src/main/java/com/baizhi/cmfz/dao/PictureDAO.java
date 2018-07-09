package com.baizhi.cmfz.dao;

import com.baizhi.cmfz.entity.Picture;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @Description: 轮播图相关的DAO
 * @Author zhy
 * @Date 2018-07-05 18:29
 */
public interface PictureDAO {

    /*
     * @Description  分页查询轮播图
     * @Author zhy
     * @Date 2018/7/5 18:31
     * @Param [begin, end]
     * @Return java.util.List<com.baizhi.cmfz.entity.Picture>
     */
    public List<Picture> selectAll(@Param("begin") Integer begin, @Param("end") Integer end);

    /*
     * @Description 查询轮播图表中数据条数，用于分页
     * @Author zhy
     * @Date 2018/7/6 9:33
     * @Return java.lang.Integer
     */
    public Integer selectCount();

    /*
     * @Description 添加轮播图
     * @Author zhy
     * @Date 2018/7/6 9:34
     * @Param [pic]
     * @Return java.lang.Integer
     */
    public Integer insertPicture(Picture pic);
}
