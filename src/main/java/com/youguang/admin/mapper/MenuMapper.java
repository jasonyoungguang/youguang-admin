package com.youguang.admin.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.youguang.admin.entities.AdminMenuEntity;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface MenuMapper extends BaseMapper<AdminMenuEntity> {

    /**
     * 查询所有的菜单
     */
    List<AdminMenuEntity> queryAllMenu();

    /**
     * 根据菜单父节点id查找子节点
     *
     * @param parentId 菜单父级id
     * @param status   状态{@link AdminMenuEntity.Status}
     * @return 子菜单集合
     */
    List<AdminMenuEntity> queryMenusByParentId(@Param("parentId") Long parentId, @Param("status") Integer status);
}
