package com.zxy.galaxy.Controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.zxy.galaxy.Common.Result;
import com.zxy.galaxy.Entity.User;
import com.zxy.galaxy.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * 视频例子参考用
 */
@RestController
public class TemplateController {
    @Autowired
    UserService userService;

    @GetMapping("/getUserByPage")
    public Result list(Integer pageNum, Integer pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        List<User> userList = userService.findAllUser();
        PageInfo<User> userPageInfo = new PageInfo<>(userList);
        return Result.success(userPageInfo);
    }
}
