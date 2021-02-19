package com.youguang.admin.service;

import com.youguang.admin.dto.DeptDTO;

import java.util.List;

public interface IDeptService {
	
	List<DeptDTO> allDepts();
	
	/**
	 * 删除指定部门
	 *
	 * @param deptId       待删除部门id
	 * @param operatorId   操作人userId
	 * @param operatorName 操作人名
	 */
	void deleteDepartment(Long deptId, Long operatorId, String operatorName);
	
	/**
	 * 添加部门
	 *
	 * @param deptDTO 待添加部门信息
	 */
	void addDepartment(DeptDTO deptDTO);
	
	/**
	 * 更新部门
	 *
	 * @param deptDTO 待更新内容
	 */
	void updateDepartment(DeptDTO deptDTO);
}
