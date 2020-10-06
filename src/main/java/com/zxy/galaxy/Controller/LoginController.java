package com.zxy.galaxy.Controller;

import com.zxy.galaxy.Common.Result;
import com.zxy.galaxy.Common.Util.JwtUtils;
import com.zxy.galaxy.Dto.LoginDto;
import com.zxy.galaxy.Entity.User;
import com.zxy.galaxy.Service.UserService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authz.annotation.RequiresAuthentication;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.Map;

@RestController
public class LoginController {
    @Autowired
    UserService userService;
    @Autowired
    JwtUtils jwtUtils;

    /**
     * 登录
     * @param loginDto
     * @param httpServletResponse
     * @return
     */
    @PostMapping("/login")
    public Result login(@RequestBody LoginDto loginDto, HttpServletResponse httpServletResponse) {
        //后端验证传入的用户名密码不为空
        if (!StringUtils.isEmpty(loginDto.getUsername()) && !StringUtils.isEmpty(loginDto.getPassword())) {
            User user = userService.findUserByUsername(loginDto.getUsername());
            if (user != null) {
                //如果该用户存在
                if (user.getPassword().equals(loginDto.getPassword())) {
                    //密码验证通过
                    String token = jwtUtils.genetateToken(loginDto.getUsername());
                    httpServletResponse.setHeader("Authorization", token);
                    httpServletResponse.setHeader("Access-control-Expose-Headers", "Authorization");

                    return Result.success(setUserInfo(user));
                } else {
                    //密码错误
                    return Result.fail("密码错误");
                }
            } else {
                //用户不存在
                return Result.fail("用户不存在");
            }
        } else {
            //用户名密码不能为空
            return Result.fail("用户名或密码不能为空");
        }
    }

    /**
     * 登录成功后返回的非涉密用户信息
     * @param user
     * @return
     */
    private Map setUserInfo(User user) {
        Map<String, Object> objectMap = new HashMap<>();
        objectMap.put("uuid", user.getUuid());
        objectMap.put("username", user.getUsername());
        objectMap.put("eMail",user.getEMail());
        objectMap.put("status", user.getStatus());
        objectMap.put("type", user.getType());
        return objectMap;
    }

    /**
     * 登出
     * @return
     */
    @RequiresAuthentication
    @GetMapping("/logout")
    public Result logout() {
        //退出交给shiro
        SecurityUtils.getSubject().logout();
        return Result.success(null);
    }
}
