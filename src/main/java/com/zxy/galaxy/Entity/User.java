package com.zxy.galaxy.Entity;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * 用户实体类
 */
@Data
public class User implements Serializable {
    /**
     * uuid
     */
    private String uuid;
    /**
     * 部门id
     */
    private String deptId;
    /**
     * 用户名
     */
    private String username;
    /**
     * 密码
     */
    private String password;
    /**
     * 盐值
     */
    private String salt;
    /**
     * 真实姓名
     */
    private String realName;
    /**
     * 职位
     */
    private String jobTitle;
    /**
     * 联系电话
     */
    private String  cellPhoneNumber;
    /**
     * 邮箱
     */
    private String eMail;
    /**
     * 状态
     */
    private int status;
    /**
     * 删除标识 0：未删除 1：已删除
     */
    private int isDeleted;
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
     * 最后登录时间
     */
    private Date lastTime;
}
