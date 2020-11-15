package com.zxy.galaxy.Mapper;

import java.util.List;

public interface RolePermissionMapper {
    List<String> selectPermsByRoles(List<String> roles);
}
