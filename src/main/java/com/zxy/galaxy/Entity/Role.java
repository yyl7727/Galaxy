package com.zxy.galaxy.Entity;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * 角色实体类
 */
@Data
public class Role implements Serializable {
    /**
     * uuid
     */
    private String uuid;
    /**
     * 父节点uuid
     */
    private String parentId;
    /**
     * 角色名称
     */
    private String roleName;
    /**
     * 备注
     */
    private String remark;
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
