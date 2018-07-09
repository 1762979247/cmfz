package com.baizhi.cmfz.controller;

import com.baizhi.cmfz.entity.Menu;
import com.baizhi.cmfz.service.MenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * @Description: 菜单相关的控制器
 * @Author zhy
 * @Date 2018-07-05 11:54
 */
@Controller
@RequestMapping("/menu")
public class MenuController {

    @Autowired
    private MenuService ms;

    @RequestMapping("/searchAllMenu")
    @ResponseBody
    public List<Menu> searchAllMenu(){
        return ms.searchAllMenu();
    }

}
