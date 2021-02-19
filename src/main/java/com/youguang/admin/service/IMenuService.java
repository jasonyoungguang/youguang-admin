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

    /**
     * 删除菜单
     *
     * @param menuId       菜单id
     * @param operatorId   操作人userId
     * @param operatorName 操作人姓名
     */
    void deleteMenu(Long menuId, Long operatorId, String operatorName);
}
