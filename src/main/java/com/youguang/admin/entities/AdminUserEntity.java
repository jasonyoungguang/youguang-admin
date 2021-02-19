package com.youguang.admin.entities;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;

/**
 * 用户实体
 */
@Data
@TableName("admin_user")
public class AdminUserEntity extends BaseEntity implements Serializable {
	
	/**
	 * 部门id
	 */
	private Long fkAdminDeptId;
	
	/**
	 * 用户名
	 */
	private String username;
	
	/**
	 * 密码
	 */
	private String password;
	
	/**
	 * 真实姓名
	 */
	private String realName;
	
	/**
	 * 性别：0：女性；1：男性
	 */
	private Integer gender;
	
	/**
	 * 电话号码
	 */
	private String phoneNumber;
	
	/**
	 * 邮件
	 */
	private String email;
	
	/**
	 * 头像
	 */
	private String avatar;
	
	/**
	 * 职位
	 */
	private String jobTitle;
}
