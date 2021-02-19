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
}
