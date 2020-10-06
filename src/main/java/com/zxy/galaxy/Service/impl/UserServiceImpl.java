package com.zxy.galaxy.Service.impl;

import com.zxy.galaxy.Entity.User;
import com.zxy.galaxy.Mapper.UserMapper;
import com.zxy.galaxy.Service.UserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    @Resource
    UserMapper userMapper;

    /**
     * 获取所有用户信息
     * @return
     */
    @Override
    public List<User> findAllUser() {
        return null;
    }

    /**
     * 根据用户名找到对应用户
     * @param username 用户名
     * @return
     */
    @Override
    public User findUserByUsername(String username) {
        return userMapper.findUserByUsername(username);
    }

    /**
     * 添加用户
     * @param user 用户实体
     * @return
     */
    @Override
    public int addUser(User user) {
        return userMapper.addUser(user);
    }
}
