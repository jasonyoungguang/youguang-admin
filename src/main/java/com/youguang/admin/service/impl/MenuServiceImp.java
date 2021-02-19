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
}
