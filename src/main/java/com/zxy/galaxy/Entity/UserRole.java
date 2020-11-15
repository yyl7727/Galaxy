package com.zxy.galaxy.Entity;

import lombok.Data;

import java.util.Date;

/**
 * 用户角色实体类
 */
@Data
public class UserRole {
    /**
     * uuid
     */
    private String uuid;
    /**
     * 用户id
     */
    private String userId;
    /**
     * 角色id
     */
    private String roleId;
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
