package com.baizhi.cmfz.dao;

import com.baizhi.cmfz.entity.Menu;

import java.util.List;

/**
 * @Description: 菜单相关的DAO接口
 * @Author zhy
 * @Date 2018-07-05 10:50
 */
public interface MenuDAO {
    /*
     * @Description 查询所有类别信息，查出来的是泛型为一级类别的集合，每个一级类别对象都持有一个此一级类别下的的二级类别集合，叫menus
     * @Author zhy
     * @Date 2018/7/5 10:53
     * @Return java.util.List<com.baizhi.cmfz.entity.Menu>
     */
    public List<Menu> selectAllMenu();
}
