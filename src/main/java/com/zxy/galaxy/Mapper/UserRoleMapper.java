package com.zxy.galaxy.Mapper;

import java.util.List;

public interface UserRoleMapper {
    /**
     * 根据用户名查询用户角色
     * @param username 用户名
     * @return Role List
     */
    List<String> selectRolesByUserName(String username);
}
