package com.zxy.galaxy.Service;

import com.zxy.galaxy.Entity.User;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface UserService {
    /**
     * 获取所有用户信息
     * @return
     */
    List<User> findAllUser();

    /**
     * 根据用户名找到对应用户
     * @param username 用户名
     * @return
     */
    User findUserByUsername(String username);

    /**
     * 添加用户
     * @param user 用户实体
     * @return
     */
    int addUser(User user);
}
