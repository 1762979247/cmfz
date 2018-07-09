package com.baizhi.cmfz.dao;

import com.baizhi.cmfz.entity.Log;

/**
 * @Description:    日志相关的DAO
 * @Author zhy
 * @Date 2018-07-09 20:11
 */
public interface LogDAO {

    /**
     * @Description  添加一行日志信息
     * @Author zhy
     * @Date 2018/7/9 20:13
     * @Param [log]
     * @Return java.lang.Integer
     */
    public Integer insertLog(Log log);
}
