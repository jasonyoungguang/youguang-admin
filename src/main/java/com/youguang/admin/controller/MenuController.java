package com.youguang.admin.controller;

import com.alibaba.fastjson.JSON;
import com.youguang.admin.dto.MenuDTO;
import com.youguang.admin.dto.PageResult;
import com.youguang.admin.dto.Result;
import com.youguang.admin.service.IMenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

/**
 * 菜单controller
 */
@Controller
public class MenuController {
	
	@Autowired
	private IMenuService service;
	
	/**
	 * 查询所有菜单
	 */
	@ResponseBody
	@GetMapping("/allMenus")
	public PageResult<MenuDTO> queryAllMenus() {
		return PageResult.success(service.allMenus());
	}
	
	/**
	 * 添加菜单
	 *
	 * @param menuDTO 待添加菜单信息
	 */
	@ResponseBody
	@PostMapping("/menu")
	public Result<String> addMenu(@RequestBody MenuDTO menuDTO) {
		System.out.println(JSON.toJSONString(menuDTO));
		return Result.succeed("添加菜单成功！");
	}
	
	// 页面渲染
	@RequestMapping("/menuIndex")
	public String menuIndex() {
		return "page/menu_list";
	}
	
	/**
	 * 转发到添加菜单页面
	 *
	 * @param model    model
	 * @param type     型号
	 * @param parentId 父级菜单id
	 */
	@RequestMapping("/dispatchAddMenu")
	public String dispatchAddMenu(Model model, @RequestParam(required = false) Integer type, @RequestParam(required = false) Long parentId) {
		model.addAttribute("type", type);
		model.addAttribute("parentId", parentId);
		System.out.println("type:" + type + ";parentId:" + parentId);
		return "page/menu_add";
	}
}
