package com.baizhi.cmfz.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * @Description: 菜单Menu的实体类
 * @Author zhy
 * @Date 2018-07-05 10:04
 */
public class Menu implements Serializable{

    private String id;          //菜单编号
    private String menuName;    //菜单名称
    private String menuCode;    //菜单英文名称
    private String menuIcon;    //菜单图标
    private String menuUrl;     //菜单的跳转路径
    private String menuType;    //菜单类别(一级|二级)
    private String parentId;    //父菜单Id
    //menus：当查询所有类别信息时，查出来的是一级类别的集合，每个一级类别对象，都有一个集合类型的属性menus，用于存储本一级类别中的所有二级类别
    private List<Menu> menus = new ArrayList<Menu>();
    //parentMenu：当查询二级类别时，parentMenu属性用于保证该二级类别有对应的一级(父)类别信息
    private Menu parentMenu;

    @Override
    public String toString() {
        return "Menu{" +
                "id='" + id + '\'' +
                ", menuName='" + menuName + '\'' +
                ", menuCode='" + menuCode + '\'' +
                ", menuIcon='" + menuIcon + '\'' +
                ", menuUrl='" + menuUrl + '\'' +
                ", menuType='" + menuType + '\'' +
                ", parentId='" + parentId + '\'' +
                ", menus=" + menus +
                ", parentMenu=" + parentMenu +
                '}';
    }

    public String getId() {

        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getMenuName() {
        return menuName;
    }

    public void setMenuName(String menuName) {
        this.menuName = menuName;
    }

    public String getMenuCode() {
        return menuCode;
    }

    public void setMenuCode(String menuCode) {
        this.menuCode = menuCode;
    }

    public String getMenuIcon() {
        return menuIcon;
    }

    public void setMenuIcon(String menuIcon) {
        this.menuIcon = menuIcon;
    }

    public String getMenuUrl() {
        return menuUrl;
    }

    public void setMenuUrl(String menuUrl) {
        this.menuUrl = menuUrl;
    }

    public String getMenuType() {
        return menuType;
    }

    public void setMenuType(String menuType) {
        this.menuType = menuType;
    }

    public String getParentId() {
        return parentId;
    }

    public void setParentId(String parentId) {
        this.parentId = parentId;
    }

    public List<Menu> getMenus() {
        return menus;
    }

    public void setMenus(List<Menu> menus) {
        this.menus = menus;
    }

    public Menu getParentMenu() {
        return parentMenu;
    }

    public void setParentMenu(Menu parentMenu) {
        this.parentMenu = parentMenu;
    }

    public Menu(String id, String menuName, String menuCode, String menuIcon, String menuUrl, String menuType, String parentId, List<Menu> menus, Menu parentMenu) {

        this.id = id;
        this.menuName = menuName;
        this.menuCode = menuCode;
        this.menuIcon = menuIcon;
        this.menuUrl = menuUrl;
        this.menuType = menuType;
        this.parentId = parentId;
        this.menus = menus;
        this.parentMenu = parentMenu;
    }

    public Menu() {

    }
}
