package com.youguang.admin.entities;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;

/**
 * 角色实体
 */
@Data
@TableName("admin_role")
public class AdminRoleEntity extends BaseEntity implements Serializable {
	
	/**
	 * 父级id
	 */
	private Long parentId;
	
	/**
	 * 名称
	 */
	private String name;
	
	/**
	 * 类型：0：分类；1：角色
	 */
	private Integer type;
	
	/**
	 * 角色备注
	 */
	private String remark;
}
