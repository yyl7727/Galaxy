package com.zxy.galaxy.Service.impl;

import com.zxy.galaxy.Entity.User;
import com.zxy.galaxy.Mapper.UserMapper;
import com.zxy.galaxy.Service.UserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class UserServiceImpl implements UserService {
    @Resource
    UserMapper userMapper;

    @Override
    public User findUserByUsername(String username) {
        return userMapper.findUserByUsername(username);
    }
}
