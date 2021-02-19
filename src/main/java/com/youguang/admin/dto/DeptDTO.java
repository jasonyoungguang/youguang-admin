package com.youguang.admin.dto;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Data
public class DeptDTO implements Serializable {
	
	private Long id;
	
	private Long parentId;
	
	private String name;
	
	private Integer type;
	
	private Integer sort;
	
	private Integer status;
	
	private String creatorName;
	
	private Date createdTime;
	
	private Long operatorId = 1L;
	private String operatorName = "杨光";
}
