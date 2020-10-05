package com.zxy.galaxy.Controller;


import com.zxy.galaxy.Common.Result;
import com.zxy.galaxy.Entity.User;
import com.zxy.galaxy.Service.UserService;
import org.apache.shiro.authz.annotation.RequiresAuthentication;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    UserService userService;

    @RequiresAuthentication
    @GetMapping("/index")
    public Result index() {
        User user = userService.findUserByUsername("yyl");
        return Result.success(user);
    }

    @GetMapping("addUser")
    public Result addUser() {
        User user = new User();
        user.setUsername("yyl");
        user.setPassword("123");
        user.setEMail("yyl7727@qq.com");
        user.getEMail();
        user.setStatus(0);
        user.setType(1);
        int operationFlag = userService.addUser(user);
        if (operationFlag >= 1) {
            return Result.success("1");
        } else {
            return Result.fail("插入失败");
        }
    }
}
