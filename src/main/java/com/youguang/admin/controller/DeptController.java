package com.youguang.admin.controller;

import com.youguang.admin.dto.DeptDTO;
import com.youguang.admin.dto.PageResult;
import com.youguang.admin.dto.Result;
import com.youguang.admin.service.IDeptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("")
public class DeptController {
	
	@Autowired
	private IDeptService deptService;
	
	@ResponseBody
	@GetMapping("/allDepts")
	public PageResult<DeptDTO> allDepts() {
		return PageResult.success(deptService.allDepts());
	}
	
	/**
	 * 删除部门
	 *
	 * @param deptId 待删除部门ID
	 */
	@ResponseBody
	@DeleteMapping("/dept")
	public Result<String> deleteDept(@RequestParam Long deptId) {
		Long operatorId = 1L;
		String operatorName = "杨光";
		deptService.deleteDepartment(deptId, operatorId, operatorName);
		return Result.succeed("删除成功！");
	}
	
	/**
	 * 添加部门
	 *
	 * @param deptDTO 待添加内容
	 */
	@ResponseBody
	@PostMapping("/department")
	public Result<String> addDepartment(@RequestBody DeptDTO deptDTO) {
		deptService.addDepartment(deptDTO);
		return Result.succeed("添加部门成功！");
	}
	
	/**
	 * 更新部门
	 *
	 * @param deptDTO 待更新内容
	 */
	@ResponseBody
	@PutMapping("/department")
	public Result<String> updateDepartment(@RequestBody DeptDTO deptDTO) {
		deptService.updateDepartment(deptDTO);
		return Result.succeed("更新部门成功！");
	}
	
	//跳转页面
	@RequestMapping("/index")
	public String deptIndex() {
		return "index";
	}
	
	@RequestMapping("/addDepartment")
	public String addDepartment(Integer type, Long parentId, Model model) {
		model.addAttribute("type", type);
		model.addAttribute("parentId", parentId);
		return "page/department_add";
	}
}
