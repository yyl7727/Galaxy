package com.zxy.galaxy.Entity;

import lombok.Data;

import java.util.Date;

/**
 * 角色权限实体类
 */
@Data
public class RolePermission {
    /**
     * uuid
     */
    private String uuid;
    /**
     * 角色id
     */
    private String roleId;
    /**
     * 权限id
     */
    private String permId;
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
