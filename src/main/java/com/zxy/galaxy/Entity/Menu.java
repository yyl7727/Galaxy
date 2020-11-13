package com.zxy.galaxy.Entity;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * 菜单实体类
 */
@Data
public class Menu implements Serializable {
    /**
     * uuid
     */
    private String uuid;
    /**
     * 父节点id
     */
    private String parentId;
    /**
     * 菜单名称
     */
    private String menuName;
    /**
     * 菜单地址
     */
    private String url;
    /**
     * 权限
     */
    private String permission;
    /**
     * 类型
     */
    private String type;
    /**
     * 图标
     */
    private String icon;
    /**
     * 状态
     */
    private String status;
    /**
     * 排序
     */
    private String sort;
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
