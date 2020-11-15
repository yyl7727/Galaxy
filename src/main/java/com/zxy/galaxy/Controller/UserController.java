package com.zxy.galaxy.Controller;

import com.zxy.galaxy.Entity.User;
import com.zxy.galaxy.Service.UserService;
import org.apache.shiro.authz.annotation.RequiresAuthentication;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

@Controller
@RequestMapping("/user")
public class UserController {
    @Autowired
    UserService userService;


}
