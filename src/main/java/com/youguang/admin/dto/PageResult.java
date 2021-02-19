package com.youguang.admin.dto;

import com.youguang.admin.enums.CodeEnum;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PageResult<T> {
	/**
	 * 是否成功：0 成功、1 失败
	 */
	private int code;
	
	/**
	 * 消息
	 */
	private String msg;
	
	/**
	 * 总数
	 */
	private Integer count;

//	/**
//	 * 当前页
//	 */
//	private Integer currentPage;
	
	/**
	 * 当前页结果集
	 */
	private List<T> data;
	
	public static <T> PageResult<T> success(List<T> data) {
		return new PageResult<>(CodeEnum.SUCCESS.getCode(), "成功", data == null ? 0 : data.size(), data);
	}
}
