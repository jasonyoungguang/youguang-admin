package com.youguang.admin.enums;

public enum CodeEnum {
	
	/**
	 * 成功返回
	 */
	SUCCESS(0),
	
	/**
	 * 异常返回
	 */
	ERROR(1),
	
	/**
	 * 未登录
	 */
	NO_LOGIN(2),
	
	/**
	 * 消息提醒
	 */
	MES_WARNING(3),
	
	/**
	 * 需要验证码
	 */
	VERIFICATION_CODE(4),
	
	/**
	 * 账号已锁定
	 */
	ACCOUNT_LOCKED(5),
	
	/**
	 * 专用于价格导入功能的code，导入失败
	 */
	IMPORT_FAILED(6);
	
	private Integer code;
	
	CodeEnum(Integer code) {
		this.code = code;
	}
	
	public Integer getCode() {
		return code;
	}
}

