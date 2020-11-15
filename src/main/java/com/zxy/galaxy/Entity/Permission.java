package com.zxy.galaxy.Entity;

import lombok.Data;

import java.util.Date;

/**
 * 权限实体类
 */
@Data
public class Permission {
    /**
     * uuid
     */
    private String uuid;
    /**
     * 父节点id
     */
    private String parentId;
    /**
     * 权限编码
     */
    private String permCode;
    /**
     * 权限名称
     */
    private String permName;
    /**
     * 排序
     */
    private String sort;
    /**
     * 权限描述
     */
    private String description;
    /**
     * 状态
     */
    private String status;
    /**
     * 创建人
     */
    private String createBy;
    /**
     * 创建时间
     */
    private Date createTime;
    /**
     * 更新时间
     */
    private Date updateTime;
    /**
     * 是否删除 0：未删除 1：已删除
     */
    private Date isDeleted;
}
