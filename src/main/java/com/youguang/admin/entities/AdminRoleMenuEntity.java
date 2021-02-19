package com.youguang.admin.entities;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;

/**
 * 角色和菜单实体
 */
@Data
@TableName("admin_role_menu")
public class AdminRoleMenuEntity extends BaseEntity implements Serializable {
	
	/**
	 * 关联额角色id
	 */
	private Long fkAdminRoleId;
	
	/**
	 * 关联的菜单id
	 */
	private Long fkAdminMenuId;
}
