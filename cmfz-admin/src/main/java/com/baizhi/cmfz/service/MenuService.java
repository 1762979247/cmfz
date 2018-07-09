package com.baizhi.cmfz.service;

import com.baizhi.cmfz.entity.Menu;

import java.util.List;

/**
 * @Description: 菜单相关的Service接口
 * @Author zhy
 * @Date 2018-07-05 11:42
 */
public interface MenuService {

    /*
     * @Description  查询所有菜单信息(查出来的是泛型为一级菜单的集合)
     * @Author zhy
     * @Date 2018/7/5 11:44
     * @Param []
     * @Return java.util.List<com.baizhi.cmfz.entity.Menu>
     */
    public List<Menu> searchAllMenu();
}
