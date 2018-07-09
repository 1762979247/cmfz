package com.baizhi.cmfz.dao;

import com.baizhi.cmfz.entity.Master;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @Description: 上师的DAO
 * @Author zhy
 * @Date 2018-07-06 16:57
 */
public interface MasterDAO {

    /**
     * @Description    分页查询上师
     * @Author zhy
     * @Date 2018/7/6 17:04
     * @Param [begin, offSet]
     * @Return java.util.List<com.baizhi.cmfz.entity.Master>
     */
    public List<Master> selectMasterByPage(@Param("begin") Integer begin, @Param("offSet") Integer offSet);

    /**
     * @Description  查询上师表中数据总条数
     * @Author zhy
     * @Date 2018/7/6 16:59
     * @Return java.lang.Integer
     */
    public Integer selectCount();

    /**
     * @Description    查询所有上师，用于poi导出
     * @Author zhy
     * @Date 2018/7/6 21:34
     * @Return java.util.List<com.baizhi.cmfz.entity.Master>
     */
    public List<Master> selectAll();

    /**
     * @Description  根据关键字，分页查询上师
     * @Author zhy
     * @Date 2018/7/7 15:59
     * @Param [begin, offSet, keywords]
     * @Return java.util.List<com.baizhi.cmfz.entity.Master>
     */
    public List<Master> selectMasterByKeywords(@Param("begin")Integer begin, @Param("offSet")Integer offSet, @Param("keywords") String keywords);

    /**
     * @Description  根据关键组字查询上师表中数据总条数
     * @Author zhy
     * @Date 2018/7/7 15:59
     * @Param [keywords]
     * @Return java.lang.Integer
     */
    public Integer selectCountByKeywords(@Param("keywords") String keywords);

    /**
     * @Description  添加上师
     * @Author zhy
     * @Date 2018/7/7 18:42
     * @Param [master]
     * @Return java.lang.Integer
     */
    public Integer insertMaster(Master master);

    /**
     * @Description  批量添加上师
     * @Author zhy
     * @Date 2018/7/7 21:30
     * @Param [masters]
     * @Return java.lang.Integer
     */
    public Integer batchInsert(@Param("masters") List<Master> masters);

    /**
     * @Description    更改上师信息
     * @Author zhy
     * @Date 2018/7/8 9:42
     * @Param [master]
     * @Return java.lang.Integer
     */
    public Integer updateMaster(Master master);
}
