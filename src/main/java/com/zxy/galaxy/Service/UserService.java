package com.zxy.galaxy.Service;

import com.zxy.galaxy.Entity.User;
import org.springframework.stereotype.Service;

@Service
public interface UserService {
    User findUserByUsername(String username);
}
