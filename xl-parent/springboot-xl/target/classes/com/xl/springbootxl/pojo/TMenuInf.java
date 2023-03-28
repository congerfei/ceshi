package com.xl.springbootxl.pojo;

import lombok.Data;

import java.io.Serializable;

/**
 * T_MENU_INF    菜单表，前缀MENU，1-2表示一级菜单，3-4表示二级菜单，5-6表示三级菜单 7-8预留表示省份
 * @author 
 */
@Data
public class TMenuInf implements Serializable {
    /**
     * 菜单id
     */
    private String menuId;

    /**
     * 菜单名字
     */
    private String menuNm;

    /**
     * 菜单层级
     */
    private Long menuLvl;

    private Long dispNo;

    /**
     * 父级菜单id
     */
    private String supMenu;

    /**
     * 菜单图标
     */
    private String menuIcon;

    /**
     * 菜单渠道
     */
    private String chnlTp;

    /**
     * 菜单路径
     */
    private String menuUrl;

    private static final long serialVersionUID = 1L;
}