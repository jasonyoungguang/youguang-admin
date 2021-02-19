package com.youguang.admin.service.impl;

import com.youguang.admin.dto.DeptDTO;
import com.youguang.admin.entities.AdminDeptEntity;
import com.youguang.admin.mapper.DeptMapper;
import com.youguang.admin.service.IDeptService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.List;

@Service
public class DeptServiceImpl implements IDeptService {
	
	@Autowired
	private DeptMapper mapper;
	
	@Override
	public List<DeptDTO> allDepts() {
		return mapper.allDepts();
	}
	
	/**
	 * 删除指定部门
	 *
	 * @param deptId       待删除部门id
	 * @param operatorId   操作人userId
	 * @param operatorName 操作人名
	 */
	@Override
	public void deleteDepartment(Long deptId, Long operatorId, String operatorName) {
		AdminDeptEntity deptEntity = mapper.selectById(deptId);
		if (deptEntity == null) {
			throw new RuntimeException(String.format("[%s]：无对应的部门实体存在！", deptId));
		}
		deptEntity.setStatus(AdminDeptEntity.Status.DELETED.getCode());
		deptEntity.decorateUpdateParams(operatorId, operatorName);
		mapper.updateById(deptEntity);
		
		//删除子菜单
		List<AdminDeptEntity> subDepartments = queryDepartmentsByParentId(deptId, AdminDeptEntity.Status.UN_DELETED);
		if (!CollectionUtils.isEmpty(subDepartments)) {
			subDepartments.forEach(sub -> deleteDepartment(sub.getId(), operatorId, operatorName));
		}
	}
	
	/**
	 * 根据部门父级id查找子节点
	 *
	 * @param departmentParentId 部门父级id
	 * @param status             状态{@link AdminDeptEntity.Status}
	 * @return 子部门
	 */
	private List<AdminDeptEntity> queryDepartmentsByParentId(Long departmentParentId, AdminDeptEntity.Status status) {
		return mapper.querySubDepartmentById(departmentParentId, status.getCode());
	}
	
	/**
	 * 添加部门
	 *
	 * @param deptDTO 待添加部门信息
	 */
	@Override
	public void addDepartment(DeptDTO deptDTO) {
		AdminDeptEntity entity = new AdminDeptEntity();
		BeanUtils.copyProperties(deptDTO, entity);
		entity.initialEntity(deptDTO.getOperatorId(), deptDTO.getOperatorName());
		
		mapper.insert(entity);
	}
	
	/**
	 * 更新部门
	 *
	 * @param deptDTO 待更新内容
	 */
	@Override
	public void updateDepartment(DeptDTO deptDTO) {
		Long operatorId = 1L;
		String operatorName = "杨光";
		
		Long departmentId = deptDTO.getId();
		if (departmentId == null) {
			throw new RuntimeException("更新部门，参数id不可为空！");
		}
		AdminDeptEntity entity = getDepartmentById(departmentId);
		if (entity == null) {
			throw new RuntimeException("更新的部门无对应实体！");
		}
		entity.setName(deptDTO.getName());
		entity.setSort(deptDTO.getSort());
		entity.setStatus(deptDTO.getStatus());
		entity.decorateUpdateParams(operatorId, operatorName);
		
		mapper.updateById(entity);
	}
	
	/**
	 * 根据部门id获取部门实体
	 *
	 * @param departmentId 待获取部门id
	 */
	private AdminDeptEntity getDepartmentById(Long departmentId) {
		return mapper.selectById(departmentId);
	}
}
