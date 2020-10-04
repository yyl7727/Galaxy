package com.zxy.galaxy.Mapper;

import com.zxy.galaxy.Entity.User;

public interface UserMapper {
    User findUserByUsername(String username);
}
