package com.zxy.galaxy.Entity;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * 部门实体类
 */
@Data
public class Dept implements Serializable {
    /**
     * id
     */
    private String uuid;
    /**
     * 父节点id
     */
    private String parentId;
    /**
     * 部门名称
     */
    private String deptName;
    /**
     * 类型
     */
    private String type;
    /**
     * 排序
     */
    private Integer sort;
    /**
     * 状态
     */
    private String status;
    /**
     * 是否删除 0：未删除 1：已删除
     */
    private String isDeleted;
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
}
