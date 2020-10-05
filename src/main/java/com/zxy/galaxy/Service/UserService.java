package com.zxy.galaxy.Service;

import com.zxy.galaxy.Entity.User;
import org.springframework.stereotype.Service;

@Service
public interface UserService {
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
