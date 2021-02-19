package com.youguang.admin.dto;

import lombok.Data;

import java.util.Date;

/**
 * 菜单DTO
 */
@Data
public class MenuDTO {

    /**
     * 主键id
     */
    private Long id;

    /**
     * 父级id
     */
    private Long parentId;

    /**
     * 菜单名称
     */
    private String name;

    /**
     * 菜单路径
     */
    private String url;

    /**
     * 菜单对应的权限
     */
    private String permission;

    /**
     * 类型
     */
    private Integer type;

    /**
     * 图标
     */
    private String icon;

    /**
     * 排序
     */
    private String sort;

    /**
     * 状态
     */
    private Integer status;

    /**
     * 创建人
     */
    private String creatorName;

    /**
     * 创建时间
     */
    private Date createdTime;

    /**
     * 操作人userId
     */
    private Long operatorId;

    /**
     * 操作人姓名
     */
    private String operatorName;
}
