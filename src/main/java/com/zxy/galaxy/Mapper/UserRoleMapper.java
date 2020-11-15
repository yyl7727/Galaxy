package com.zxy.galaxy.Mapper;

import com.zxy.galaxy.Entity.UserRole;

import java.util.List;

public interface UserRoleMapper {

    List<String> selectRolesByUserName(String username);
}
