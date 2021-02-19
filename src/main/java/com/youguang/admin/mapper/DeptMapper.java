package com.youguang.admin.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.youguang.admin.dto.DeptDTO;
import com.youguang.admin.entities.AdminDeptEntity;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface DeptMapper extends BaseMapper<AdminDeptEntity> {
	
	List<DeptDTO> allDepts();
	
	/**
	 * 根据父级部门id查找子部门
	 *
	 * @param parentId 父级部门id
	 * @param status   状态
	 * @return 子部门
	 */
	List<AdminDeptEntity> querySubDepartmentById(@Param("parentId") Long parentId, @Param("status") Integer status);
}
