package com.zxy.galaxy.Mapper;

import java.util.List;

public interface RoleMapper {

    List<String> selectRolesByRoleIds(List<String> roleIds);
}
