package com.youguang.admin.entities;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;

/**
 * 部门实体
 */
@Data
@TableName("admin_dept")
public class AdminDeptEntity extends BaseEntity implements Serializable {
	
	/**
	 * 父级id
	 */
	private Long parentId;
	
	/**
	 * 名称
	 */
	private String name;
	/**
	 * 类型：
	 * 0：公司；
	 * 1：部门；
	 * 2：科室/小组
	 */
	private Integer type;
	
	/**
	 * 排序，值越小越靠前
	 */
	private Integer sort;
}
