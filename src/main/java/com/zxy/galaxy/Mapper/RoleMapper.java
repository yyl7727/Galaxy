package com.zxy.galaxy.Mapper;

import java.util.List;

public interface RoleMapper {
    /**
     * 根据角色id获取角色名称
     * @param roleIds 角色id List
     * @return 角色名称 List
     */
    List<String> selectRolesByRoleIds(List<String> roleIds);
}
