package com.zxy.galaxy.Controller;

import com.zxy.galaxy.Config.Exception.LoginException;
import com.zxy.galaxy.Entity.User;
import com.zxy.galaxy.Service.UserService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authz.AuthorizationException;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;


@Controller
public class LoginController {
    @Autowired
    UserService userService;

    @RequestMapping("/subLogin")
    public String login(User user) {
        Subject subject = SecurityUtils.getSubject();
        if (!subject.isAuthenticated()) {
            UsernamePasswordToken token = new UsernamePasswordToken(user.getUsername(),user.getPassword());
            try {
                subject.login(token);//认证
            } catch (UnknownAccountException unknownAccountException) {
                throw new LoginException("账号不存在", unknownAccountException);
            } catch (IncorrectCredentialsException incorrectCredentialsException) {
                throw new LoginException("账号或密码错误", incorrectCredentialsException);
            } catch (AuthenticationException authenticationException) {
                throw new LoginException("认证失败", authenticationException);
            } catch (AuthorizationException authorizationException) {
                throw new LoginException("无访问权限", authorizationException);
            }
        }
        return "index";
    }

    @ExceptionHandler(LoginException.class)
    public ModelAndView loginExceptionHandler(LoginException loginException) {
        ModelAndView modelAndView = new ModelAndView("error");
        modelAndView.addObject("message", loginException.getMessage());
        return modelAndView;
    }
}
