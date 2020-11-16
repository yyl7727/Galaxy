package com.zxy.galaxy.Mapper;

import java.util.List;

public interface RolePermissionMapper {
    /**
     * 根据角色id获取权限code
     * @param roles 角色id List
     * @return 权限code List
     */
    List<String> selectPermsByRoles(List<String> roles);
}
