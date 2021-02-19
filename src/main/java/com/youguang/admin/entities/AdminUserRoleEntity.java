package com.youguang.admin.entities;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;

/**
 * 用户和角色关联实体
 */
@Data
@TableName("admin_user_role")
public class AdminUserRoleEntity extends BaseEntity implements Serializable {
	
	/**
	 * 用户userId
	 */
	private Long fkAdminUserId;
	
	/**
	 * 角色id
	 */
	private Long fkAdminRoleId;
}
