package com.baizhi.cmfz.service.impl;

import com.baizhi.cmfz.dao.MenuDAO;
import com.baizhi.cmfz.entity.Menu;
import com.baizhi.cmfz.service.MenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @Description: 菜单Service接口的实现
 * @Author zhy
 * @Date 2018-07-05 11:45
 */
@Service
@Transactional
public class MenuServiceImpl implements MenuService{

    @Autowired
    private MenuDAO md;

    @Override
    @Transactional(propagation = Propagation.SUPPORTS,readOnly = true)
    public List<Menu> searchAllMenu() {
        List menus = null;
        try {
            menus=md.selectAllMenu();
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
        return menus;
    }
}
