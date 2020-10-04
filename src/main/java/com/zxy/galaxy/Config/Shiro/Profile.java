package com.zxy.galaxy.Config.Shiro;

import lombok.Data;

import java.io.Serializable;

@Data
public class Profile implements Serializable {
    /**
     * id
     */
    private String uuid;
    /**
     * 用户名
     */
    private String username;
    /**
     * 邮箱
     */
    private String email;
    /**
     * 状态
     */
    private int status;
    /**
     * 类型
     */
    private int type;
}
