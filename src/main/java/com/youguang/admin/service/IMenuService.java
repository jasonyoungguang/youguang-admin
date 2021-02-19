package com.youguang.admin.service;

import com.youguang.admin.dto.MenuDTO;

import java.util.List;

/**
 * 菜单
 */
public interface IMenuService {

    /**
     * 查询所有的菜单
     */
    List<MenuDTO> allMenus();

    /**
     * 添加菜单
     *
     * @param menuDTO 待添加菜单
     */
    void addMenu(MenuDTO menuDTO);
}
