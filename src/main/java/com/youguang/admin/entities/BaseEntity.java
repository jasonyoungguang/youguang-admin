package com.youguang.admin.entities;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

/**
 * 基础实体
 */
@Getter
@Setter
public class BaseEntity {
	
	/**
	 * 主键id
	 */
	@TableId(type = IdType.AUTO)
	private Long id;
	
	/**
	 * 状态
	 */
	private Integer status;
	
	public enum Status {
		UNKNOWN(-99, "未知"),
		DELETED(-1, "禁用"),
		UN_DELETED(1, "启用");
		
		private Integer code;
		
		private String desc;
		
		Status(Integer code, String desc) {
			this.code = code;
			this.desc = desc;
		}
		
		public static Status getByCode(Integer code) {
			Status result = UNKNOWN;
			if (code != null) {
				for (Status i : Status.values()) {
					if (i.getCode().intValue() == code) {
						result = i;
						break;
					}
				}
			}
			return result;
		}
		
		public Integer getCode() {
			return code;
		}
		
		public String getDesc() {
			return desc;
		}
	}
	
	private Long creatorId;
	private String creatorName;
	private Date createdTime;
	private Long modifierId;
	private String modifierName;
	private Date modifiedTime;
	
	/**
	 * 初始化实体数据
	 *
	 * @param operatorId   操作人userId
	 * @param operatorName 操作人姓名
	 */
	public void initialEntity(Long operatorId, String operatorName) {
		this.setCreatorId(operatorId);
		this.setCreatorName(operatorName);
		this.setCreatedTime(new Date());
		this.setModifierId(operatorId);
		this.setModifierName(operatorName);
		this.setModifiedTime(new Date());
	}
	
	/**
	 * 装配更新实体的参数
	 *
	 * @param operatorId   操作人userId
	 * @param operatorName 操作人姓名
	 */
	public void decorateUpdateParams(Long operatorId, String operatorName) {
		this.setModifierId(operatorId);
		this.setModifierName(operatorName);
		this.setModifiedTime(new Date());
	}
}
