package com.baizhi.cmfz.dao;

import com.baizhi.cmfz.entity.Admin;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

/**
 * Created by Administrator on 2018/7/4.
 * @author zhy
 * @version 1.0
 */
public interface AdminDAO {

    /**
     * 根据用户名查询管理员，用于登录
     * @param username
     * @return Admin
     */
    public Admin selectAdminByname(@Param("username") String username);

}
