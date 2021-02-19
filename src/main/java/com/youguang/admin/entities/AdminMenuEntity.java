package com.youguang.admin.entities;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;

/**
 * 菜单实体
 */
@Data
@TableName("admin_menu")
public class AdminMenuEntity extends BaseEntity implements Serializable {
	/**
	 * 父级id
	 */
	private Long parentId;
	
	/**
	 * 名称
	 */
	private String name;
	
	/**
	 * 地址
	 */
	private String url;
	
	/**
	 * 权限，如果是多个权限用英文逗号（","）隔开
	 */
	private String permission;
	
	/**
	 * 类型：0：目录；1：菜单；2：按钮；3：导航菜单；
	 */
	private Integer type;
	
	/**
	 * 图标
	 */
	private String icon;
	
	/**
	 * 排序，值越小越靠前
	 */
	private Integer sort;
}
