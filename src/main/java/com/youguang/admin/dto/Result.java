package com.youguang.admin.dto;

import com.youguang.admin.enums.CodeEnum;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Result<T> implements Serializable {
	
	private Integer code;
	private String msg;
	private T data;
	
	public static <T> Result<T> succeed(String msg) {
		return succeedWith(null, CodeEnum.SUCCESS.getCode(), msg);
	}
	
	public static <T> Result<T> succeed(T model, String msg) {
		return succeedWith(model, CodeEnum.SUCCESS.getCode(), msg);
	}
	
	public static <T> Result<T> succeed(T model) {
		return succeedWith(model, CodeEnum.SUCCESS.getCode(), "ok");
	}
	
	public static <T> Result<T> succeedWith(T data, Integer code, String msg) {
		return new Result<>(code, msg, data);
	}
	
	public static <T> Result<T> failed(String msg) {
		return failedWith(null, CodeEnum.ERROR.getCode(), msg);
	}
	
	public static <T> Result<T> failed(T model, String msg) {
		return failedWith(model, CodeEnum.ERROR.getCode(), msg);
	}
	
	public static <T> Result<T> failedWith(T data, Integer code, String msg) {
		return new Result<>(code, msg, data);
	}
	
	public static <T> Result<T> warned(String msg) {
		return failedWith(null, CodeEnum.MES_WARNING.getCode(), msg);
	}
	
	public static <T> Result<T> warned(T model, String msg) {
		return failedWith(model, CodeEnum.MES_WARNING.getCode(), msg);
	}
	
	public static <T> Result<T> notLogin() {
		return failedWith(null, CodeEnum.NO_LOGIN.getCode(), "请登录");
	}
	
	public static <T> Result<T> importFailed(String msg) {
		return failedWith(null, CodeEnum.IMPORT_FAILED.getCode(), msg);
	}
}
