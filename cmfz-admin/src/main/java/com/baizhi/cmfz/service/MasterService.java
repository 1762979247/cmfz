package com.baizhi.cmfz.service;

import com.baizhi.cmfz.entity.Master;

import java.util.List;
import java.util.Map;

/**
 * @Description: 上师的Service
 * @Author zhy
 * @Date 2018-07-06 17:13
 */
public interface MasterService {

    /**
     * @Description  分页查询上师
     * @Author zhy
     * @Date 2018/7/6 17:19
     * @Param [currentPage, pageSize]
     * @Return java.util.List<com.baizhi.cmfz.entity.Master>
     */
    public Map<String, Object> searchMasterByPage(Integer currentPage, Integer pageSize);

    /**
     * @Description  查询所有上师
     * @Author zhy
     * @Date 2018/7/6 21:40
     * @Return java.util.List<com.baizhi.cmfz.entity.Master>
     */
    public List<Master> searchAll();

    /**
     * @Description  根据关键字，分页查询上师
     * @Author zhy
     * @Date 2018/7/7 16:49
     * @Param [currentPage, pageSize, keywords]
     * @Return java.util.Map<java.lang.String,java.lang.Object>
     */
    public Map<String, Object> searchMasterByKeywords(Integer currentPage, Integer pageSize, String keywords);

    /**
     * @Description  添加上师
     * @Author zhy
     * @Date 2018/7/7 18:47
     * @Param [master]
     * @Return void
     */
    public void addMaster(Master master);

    /**
     * @Description   批量添加上师
     * @Author zhy
     * @Date 2018/7/7 21:55
     * @Param [masters]
     * @Return void
     */
    public void addBatch(List<Master> masters);

    /**
     * @Description  更改上师信息
     * @Author zhy
     * @Date 2018/7/8 9:48
     * @Param [master]
     * @Return void
     */
    public void modifyMaster(Master master);

}
