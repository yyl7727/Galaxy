package com.zxy.galaxy.Entity;

import lombok.Data;

/**
 * 用户实体类
 */
@Data
public class User {
    /**
     * id
     */
    private String uuid;
    /**
     * 用户名
     */
    private String username;
    /**
     * 密码
     */
    private String password;
    /**
     * 邮箱
     */
    private String eMail;
    /**
     * 状态
     */
    private int status;
    /**
     * 类型
     */
    private int type;
}
