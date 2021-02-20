package com.youguang.admin.service.impl;

import com.youguang.admin.dto.MenuDTO;
import com.youguang.admin.entities.AdminMenuEntity;
import com.youguang.admin.mapper.MenuMapper;
import com.youguang.admin.service.IMenuService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.List;
import java.util.stream.Collectors;

/**
 * 菜单service实现类
 */
@Service
public class MenuServiceImp implements IMenuService {
	
	@Autowired
	private MenuMapper mapper;
	
	/**
	 * 查询所有菜单
	 */
	@Override
	public List<MenuDTO> allMenus() {
		List<AdminMenuEntity> menuEntities = mapper.queryAllMenu();
		if (CollectionUtils.isEmpty(menuEntities)) {
			return null;
		} else {
			return menuEntities.stream().map(menu -> {
				MenuDTO menuDTO = new MenuDTO();
				BeanUtils.copyProperties(menu, menuDTO);
				return menuDTO;
			}).collect(Collectors.toList());
		}
	}
	
	/**
	 * 添加菜单
	 *
	 * @param menuDTO 待添加菜单
	 */
	@Override
	public void addMenu(MenuDTO menuDTO) {
		if (menuDTO == null) {
			throw new RuntimeException("添加菜单参数不可为空！");
		}
		AdminMenuEntity menuEntity = new AdminMenuEntity();
		BeanUtils.copyProperties(menuDTO, menuEntity);
		menuEntity.initialEntity(menuDTO.getOperatorId(), menuDTO.getOperatorName());
		mapper.insert(menuEntity);
	}
	
	/**
	 * 删除菜单
	 *
	 * @param menuId       菜单id
	 * @param operatorId   操作人userId
	 * @param operatorName 操作人姓名
	 */
	@Override
	public void deleteMenu(Long menuId, Long operatorId, String operatorName) {
		if (menuId == null) {
			throw new RuntimeException("删除菜单，id不可为空！");
		}
		AdminMenuEntity menuEntity = getMenuById(menuId);
		if (menuEntity != null) {
			menuEntity.decorateUpdateParams(operatorId, operatorName);
			menuEntity.setStatus(AdminMenuEntity.Status.DELETED.getCode());
			
			mapper.updateById(menuEntity);
			
			//删除子节点
			List<AdminMenuEntity> menuEntities = getMenusByParentId(menuEntity.getId(), AdminMenuEntity.Status.UN_DELETED);
			if (!CollectionUtils.isEmpty(menuEntities)) {
				//TODO 这里需要优化，将这里更改为updateBatchById(entities)
				menuEntities.forEach(menu -> {
					menu.setStatus(AdminMenuEntity.Status.DELETED.getCode());
					menu.decorateUpdateParams(operatorId, operatorName);
					mapper.updateById(menuEntity);
				});
			}
		}
	}
	
	/**
	 * 根据菜单id查找子节点
	 *
	 * @param parentId 父级节点
	 * @param status   状态{@link AdminMenuEntity.Status}
	 * @return 菜单子节点
	 */
	private List<AdminMenuEntity> getMenusByParentId(Long parentId, AdminMenuEntity.Status status) {
		if (parentId == null && status == null) {
			return null;
		}
		
		return mapper.queryMenusByParentId(parentId, status.getCode());
	}
	
	/**
	 * 根据菜单id查找菜单实体
	 *
	 * @param menuId 菜单id
	 */
	private AdminMenuEntity getMenuById(Long menuId) {
		return mapper.selectById(menuId);
	}
	
	/**
	 * 更新菜单
	 *
	 * @param menuDTO 待更新菜单
	 */
	@Override
	public void updateMenu(MenuDTO menuDTO) {
		if (menuDTO == null) {
			throw new RuntimeException("更新菜单，参数不可为空！");
		}
		Long menuId = menuDTO.getId();
		if (menuId == null) {
			throw new RuntimeException("更新菜单Id不可为空！");
		}
		
		Integer status = menuDTO.getStatus();
		if (AdminMenuEntity.Status.UN_DELETED != AdminMenuEntity.Status.getByCode(status)) {
			deleteMenu(menuId, menuDTO.getOperatorId(), menuDTO.getOperatorName());
		} else {
			AdminMenuEntity menuEntity = getMenuById(menuId);
			if (menuEntity != null) {
				menuEntity.setName(menuDTO.getName());
				menuEntity.setPermission(menuDTO.getPermission());
				menuEntity.setStatus(menuDTO.getStatus());
				menuEntity.setSort(menuDTO.getSort());
				menuEntity.decorateUpdateParams(menuDTO.getOperatorId(), menuDTO.getOperatorName());
				
				mapper.updateById(menuEntity);
			}
		}
	}
}
