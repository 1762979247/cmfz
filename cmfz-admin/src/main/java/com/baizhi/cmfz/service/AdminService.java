package com.baizhi.cmfz.service;

import com.baizhi.cmfz.entity.Admin;

/**
 * Created by Administrator on 2018/7/4.
 * @author zhy
 * @version 1.0
 */
public interface AdminService {

    /**
     * 管理员登录
     * @param username
     * @param password
     * @return Admin
     */
    public Admin searchAdminByName(String username, String password);
}
