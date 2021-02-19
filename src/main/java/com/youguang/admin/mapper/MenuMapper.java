package com.youguang.admin.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.youguang.admin.entities.AdminMenuEntity;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface MenuMapper extends BaseMapper<AdminMenuEntity> {
	
	/**
	 * 查询所有的菜单
	 */
	List<AdminMenuEntity> queryAllMenu();
}
